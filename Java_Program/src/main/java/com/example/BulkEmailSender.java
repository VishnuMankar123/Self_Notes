package com.example;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;

import java.io.File;
import java.util.*;

public class BulkEmailSender {

    // Sender credentials
    private static final String USERNAME = "snehalmankar911@gmail.com";
    private static final String PASSWORD = "xjos zwws afja gqpv"; // Gmail App Password

    public static void main(String[] args) {

        // List of email IDs
        List<String> recipients = Arrays.asList(
            "peopleops@tyasorix.com","HR@CYBERASOL.COM"
        );

        // Resume file path
        String resumePath = "C:\\Users\\Pratiti_Users\\Downloads\\Resume\\Snehal Mankar Resume.pdf";

        for (String email : recipients) {
            sendEmail(email, resumePath);
        }
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