package com.xingyun.springbootwithjavamailsendersample.controller.api;

import com.xingyun.springbootwithjavamailsendersample.service.UserService;
import com.xingyun.springbootwithjavamailsendersample.util.RandomNumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/21 19:20
 */
@RestController
public class SendEmailController {

    @Resource
    private UserService userService;

    @Resource
    private TemplateEngine templateEngine;


    @GetMapping(value = "/sendEmail")
    public String sendEmailTemplatePage(){

        String emailSubject="Spring Boot With Java Email Test";
        //邮件想发送给谁,在这里配置
        String[] toUserEmailArray={"fairy_xingyun@hotmail.com"};
        //获取六位随机数
        int verificationCode= RandomNumberUtils.getRandomNumber();

        Context context = new Context();
        //设置传入模板的页面的参数 参数名为:code ,随机验证码
        context.setVariable("code",verificationCode);
        //emailTemplate是你要发送的模板我这里用的是Thymeleaf
        String emailContent = templateEngine.process("email-template", context);
        userService.registerEmail(emailSubject,emailContent,toUserEmailArray);
        return "send finished";
    }
}
