package com.gamemall.gamemall.service;

import com.gamemall.gamemall.entity.Code;
import com.gamemall.gamemall.entity.EmailConfig;
import com.gamemall.gamemall.entity.User;
import com.gamemall.gamemall.repositoy.CodeRepository;
import com.gamemall.gamemall.repositoy.UserRepository;
import com.gamemall.gamemall.utils.EmailHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import java.io.IOException;
@Slf4j
@Service
public class EmailService {

    private CodeRepository CodeRepository;

    @Autowired
    public EmailService(CodeRepository codeRepository) {
        this.CodeRepository = codeRepository;
    }

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
            emailHelper.sendEmail(emailConfig, email, "验证码", buildEmailContent(email), null, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String buildEmailContent(String email) {
        EmailHelper emailHelper = new EmailHelper();
        String code = emailHelper.getVerifyCode();
        Code coder =  CodeRepository.findByEmail(email);
        if( StringUtils.isEmpty(coder)){
            coder = new Code();
        }
        coder.setEmail(email);
        coder.setCode(code);
        CodeRepository.saveAndFlush(coder);
        log.info("coder"+coder);
        return "您好，您的验证码是 "+code+" ,请及时输入，以防过期！";
    }

    public Boolean checkCode(String email,String code) {
        Code coder =  CodeRepository.findByEmail(email);
        log.info("code"+code);
        log.info("coder"+coder.getCode());
        if(coder.getCode().equals(code)){
            return true;
        } else{
            return false;
        }
    }
}
