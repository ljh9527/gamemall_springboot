package com.gamemall.gamemall.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamemall.gamemall.entity.EmailConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

@Component
public class EmailHelper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final Integer VERIFYCODE = 1000000;

    public String getVerifyCode() {
        SecureRandom random = new SecureRandom();
        return String.format("%06d", random.nextInt(VERIFYCODE));
    }

    public void sendEmail(EmailConfig emailConfigObject, String destEmail, String subject, String content, InputStream attachment, String attachmentName, String attachmentType) throws IOException, MessagingException {

        if (destEmail == null || destEmail.trim().isEmpty()) {
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
//        EmailConfig emailConfigObject = objectMapper.readValue(emailConfig, EmailConfig.class);
        JavaMailSender javaMailSender = buildJavaMailSender(emailConfigObject);
        MimeMessage mimeMessage = buildMimeMessage(javaMailSender, destEmail, emailConfigObject.getUserName(),
                subject, content);

        if (attachment != null) {
            mimeMessage.setContent(createContent(attachment, content, attachmentName, attachmentType));
        }

        javaMailSender.send(mimeMessage);
    }


    private JavaMailSender buildJavaMailSender(EmailConfig emailConfig) {
        // 由于需要从数据读取邮箱配置，因此直接使用JavaMailSender的实现类，而不直接注入JavaMailSender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setUsername(emailConfig.getUserName());
        mailSender.setPassword(emailConfig.getPassword());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setProtocol(emailConfig.getProtocol());
        return mailSender;
    }

    private MimeMessage buildMimeMessage(JavaMailSender javaMailSender, String to, String from, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);

        return mimeMessage;
    }

    private Multipart createContent(InputStream inputStream, String content, String name, String attachmentType) throws IOException, MessagingException {
        MimeBodyPart fileBody = new MimeBodyPart();
        DataSource source = new ByteArrayDataSource(inputStream, attachmentType);
        fileBody.setDataHandler(new DataHandler(source));
        System.setProperty("mail.mime.charset", "UTF-8");
        fileBody.setFileName(name);
        fileBody.setHeader("Content-Type", "text/html; charset=UTF-8");

        BodyPart msgBodyPart = new MimeBodyPart();
        msgBodyPart.setText(content);

        MimeMultipart multipart = new MimeMultipart("mixed");
        multipart.addBodyPart(fileBody);
        multipart.addBodyPart(msgBodyPart);

        return multipart;
    }
}
