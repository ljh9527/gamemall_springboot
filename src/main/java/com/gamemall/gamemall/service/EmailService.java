package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.EmailConfig;
import com.gamemall.gamemall.utils.EmailHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
@Slf4j
@Service
public class EmailService {

    public String sendEmail(String email) {
        EmailConfig emailConfig = new EmailConfig();
        emailConfig.setHost("smtp.qq.com");
        emailConfig.setUserName("670684985@qq.com");
        emailConfig.setPassword("dxiddjrwsovbbefc");
        emailConfig.setPort(25);
        emailConfig.setProtocol("smtp");
        log.info("emailConfig:"+emailConfig);
        EmailHelper emailHelper = new EmailHelper();
        try {
            emailHelper.sendEmail(emailConfig, email, "验证码", buildEmailContent(), null, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String buildEmailContent() {
        EmailHelper emailHelper = new EmailHelper();
        String code = emailHelper.getVerifyCode();
        return "您好，您的验证码是 "+code+" ,请及时输入，以防过期！";
    }
}
