package com.fhlxc.backend;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
* @author Xingchao Long
* @date 2019/17/16 10:17:48
* @ClassName SendMail
* @Description 发送邮件的类
*/

public class SendMail {
    public static void send(String title, String content,String receiver) {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.163.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("z15881614642@163.com", "fhlxc447730");
                }
            });
            session.setDebug(true);
            
            Transport ts = session.getTransport();
            ts.connect("smtp.163.com", "z15881614642@163.com", "fhlxc447730");
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("z15881614642@163.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setContent(content, "text/plain; charset=utf-8");
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
        } catch (GeneralSecurityException | MessagingException e) {
            e.printStackTrace();
        }
    }
}
