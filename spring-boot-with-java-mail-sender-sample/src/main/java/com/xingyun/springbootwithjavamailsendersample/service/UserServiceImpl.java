package com.xingyun.springbootwithjavamailsendersample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/21 19:30
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;

    @Override
    public void registerEmail(String subject,String content,String[] toUserEmailArray) {

        //发送消息对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        // use the true flag to indicate you need a multipart message
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(subject);
            //邮件谁发送的
            mimeMessageHelper.setFrom(mailProperties.getUsername());
            //添加邮件发送给谁
            mimeMessageHelper.setTo(toUserEmailArray);
            //添加邮件正文
            mimeMessageHelper.setText(content,true);
            //邮件正文图片
            ClassPathResource classPathResource=new ClassPathResource("/static/images/share-public.png");
            //内嵌图片 绑定ID
            mimeMessageHelper.addInline("logoImage",classPathResource);
            //获取附件图片
            FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\xingyun\\Pictures\\program.jpg"));
            //添加附件
            mimeMessageHelper.addAttachment("program.jpg",fileSystemResource);

            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Messaging Exception:",e);
        }
    }
}
