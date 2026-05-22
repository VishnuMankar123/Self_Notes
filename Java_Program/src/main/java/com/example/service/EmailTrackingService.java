package com.example.service;


import com.example.entity.EmailTracking;
import com.example.repository.EmailTrackingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;

@Service
public class EmailTrackingService {

    private final EmailTrackingRepository emailTrackingRepository;

    private static final String USERNAME = "snehalmankar911@gmail.com";
    private static final String PASSWORD = "xjos zwws afja gqpv";

    public EmailTrackingService(EmailTrackingRepository emailTrackingRepository) {
        this.emailTrackingRepository = emailTrackingRepository;
    }

    public List<String> saveEmail(List<String> recipients) {
        String resumePath = "C:\\Users\\Pratiti_Users\\Downloads\\Resume\\Snehal Mankar Resume.pdf";
        List<String> sentEmails = new ArrayList<>();
        for (String email : recipients) {
            sendEmail(email, resumePath);
            EmailTracking emailTracking = new EmailTracking();
            emailTracking.setEmailId(email);
            emailTracking.setCreatedDate(LocalDateTime.now());
            emailTracking.setUser("Snehal Mankar");
            emailTrackingRepository.save(emailTracking);
            sentEmails.add(email);
        }

        return sentEmails;
    }

    private  void sendEmail(String toEmail, String resumePath) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject("Application for .NET Developer | Immediate Availability");

            // Email Body
            String body = "Hi Team,\n\n"
                    + "I hope you are doing well.\n\n"
                    + "I am writing to express my interest in the .NET Developer position at your organization. "
                    + "I have 2.4 years of experience in C#, ASP.NET MVC, .NET Core, Web API, and SQL Server. "
                    + "Currently, I am working as a Software Engineer, where I have developed secure and scalable "
                    + "banking and financial applications, including transaction-based APIs and database optimization.\n\n"
                    + "I am confident that my technical expertise and problem-solving skills would make me a valuable "
                    + "addition to your team. Please find my resume attached for your review. I would welcome the opportunity "
                    + "to discuss how I can contribute to your organization.\n\n"
                    + "Thank you for your time and consideration.\n\n"
                    + "Best Regards,\n"
                    + "Snehal Mankar\n"
                    + "Mobile: 8668335784";

            // Multipart (Body + Attachment)
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(resumePath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email sent to: " + toEmail);

            // Delay to avoid spam blocking
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Failed for: " + toEmail);
            e.printStackTrace();
        }
    }
}