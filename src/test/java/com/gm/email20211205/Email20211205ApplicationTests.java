package com.gm.email20211205;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author gm
 * 测试
 */
@SpringBootTest
class Email20211205ApplicationTests {
 @Autowired
 JavaMailSender javaMailSender;

 /**
  * 发送简单邮件
  */
 @Test
 public void sendEMail() {
  SimpleMailMessage message = new SimpleMailMessage();
  //  邮件主题
  message.setSubject("测试");
  //  邮件发送者
  message.setFrom("981933880@qq.com");
  //  抄录自己
  message.setCc("981933880@qq.com");
  //  邮件接收者
  message.setTo("360684594@qq.com");
  //  邮件发送日期
  message.setSentDate(new Date());
  //  邮件正文
  message.setText("邮件的正文");

  javaMailSender.send(message);
 }

 /**
  * 发送附件邮件 accessory
  */
 @Test
 public void sendAccessoryEMail() throws MessagingException {
  MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//  使用MimeMessageHelper 完成邮件带附件功能 ,狄第二个参数为true,邮件正文为HTML格式
  MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
  //  邮件主题
  helper.setSubject("测试");
  //  邮件发送者
  helper.setFrom("981933880@qq.com");
  //  抄录自己
  helper.setCc("981933880@qq.com");
  //  邮件接收者
  helper.setTo("360684594@qq.com");
  //  邮件发送日期
  helper.setSentDate(new Date());
  //  邮件正文
  helper.setText("邮件的正文");

  helper.addAttachment("test.txt",new File("C:\\Users\\gm_admin\\Desktop\\test.txt"));
  javaMailSender.send(mimeMessage);
 }

 // TODO: 2021/12/5 邮件正文插入图片,
 public void sendImgEmail(){

 }

 // TODO: 2021/12/5  使用邮件模板发送邮件
 public void SendModelEmail(){

 }
}
