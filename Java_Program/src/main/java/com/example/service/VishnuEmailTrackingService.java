package com.example.service;

import com.example.entity.EmailTracking;
import com.example.repository.EmailTrackingRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Properties;

@Service
public class VishnuEmailTrackingService {

    private final EmailTrackingRepository emailTrackingRepository;

    private static final String USERNAME = "vishnudasmankar25@gmail.com";
    private static final String PASSWORD = "jqhd rotj wygl vvtu"; // Gmail App Password

    public VishnuEmailTrackingService(EmailTrackingRepository emailTrackingRepository) {
        this.emailTrackingRepository = emailTrackingRepository;
    }

    public List<String> vishnuSaveEmail(List<String> recipients) {
        String resumePath = "C:\\Users\\Pratiti_Users\\Downloads\\Resume\\Vishnudas Mankar Resume.pdf";
        List<String> sentEmails = new ArrayList<>();
        for (String email : recipients) {
            sendEmail(email, resumePath);
            EmailTracking emailTracking = new EmailTracking();
            emailTracking.setEmailId(email);
            emailTracking.setCreatedDate(LocalDateTime.now());
            emailTracking.setUser("Vishnudas Mankar");
            emailTrackingRepository.save(emailTracking);
            sentEmails.add(email);
        }

        return sentEmails;
    }



    private static void sendEmail(String toEmail, String resumePath) {

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

            message.setSubject("Application for Java Backend Developer Position");

            // Email Body
            String body = "Dear Hiring Team,\n\n"
                    + "I hope you are doing well.\n\n"
                    + "I am writing to express my interest in the Java Backend Developer position. "
                    + "I bring 4 years of experience in Java, Spring Boot, and Microservices architecture.\n\n"
                    + "In my current role as a Software Engineer, I design and develop scalable backend systems, "
                    + "RESTful APIs, and real-time data processing solutions. My technical expertise includes Java, "
                    + "Spring Boot, Microservices, MySQL, Docker, Kubernetes,AWS Cloud Services and third-party API integrations. "
                    + "I have hands-on experience in building secure, high-performance applications, containerization, "
                    + "and deploying services in cloud-native environments. I also focus on optimizing database queries "
                    + "to improve system efficiency.\n\n"
                    + "Key Skills:\n"
                    + "• Java, Spring Boot, Microservices\n"
                    + "• REST API Development\n"
                    + "• MySQL & Database Optimization\n"
                    + "• Third-party API Integration\n\n"
                    + "I am highly interested in contributing my backend development expertise to your organization "
                    + "and adding value to your engineering team.\n"
                    + "Please find my resume attached for your review. I would welcome the opportunity to discuss how "
                    + "my skills align with your requirements.\n\n"
                    + "Thank you for your time and consideration.\n\n"
                    + "Best Regards,\n"
                    + "Vishnudas Mankar\n"
                    + "Mobile: 9623731809\n"
                    + "Email: vishnudasmankar25@gmail.com";

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
