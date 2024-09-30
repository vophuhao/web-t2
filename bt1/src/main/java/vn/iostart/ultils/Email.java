package vn.iostart.ultils;

import java.util.Properties;
import java.util.Random;
/*import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/
import vn.iostart.model.Users;

public class Email {
    
//    // Method to generate a random 6-digit code
//    public String getRandom() {
//        Random rnd = new Random();
//        int number = rnd.nextInt(999999);
//        return String.format("%06d", number);
//    }
//    
//    // Method to send email to the user's email address
//    public boolean sendEmail(Users user) {
//        boolean isSent = false;
//        String toEmail = user.getEmail();
//        String fromEmail = "vophuhao2004@gmail.com";
//        String password = "Phuhao123";
//        
//        try {
//            // Set up properties for the email server
//            Properties properties = configEmail(new Properties());
//            
//            // Create a session to authenticate the sender's email address and password
//            Session session = Session.getInstance(properties, new Authenticator() { 
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() { 
//                    return new PasswordAuthentication(fromEmail, password);
//                }
//            });
//            
//            // Create and set up the email message
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(fromEmail));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//            message.setSubject("Your Password");
//            message.setText("Password: " + user.getPassWord());
//            
//            // Send the email message
//            Transport.send(message);
//            isSent = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return isSent;
//    }
//    
//    // Method to configure email server properties
//    private Properties configEmail(Properties properties) {
//        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//        properties.setProperty("mail.smtp.port", "587");
//        properties.setProperty("mail.smtp.auth", "true");
//        properties.setProperty("mail.smtp.starttls.enable", "true");
//        return properties;
//    }
//
//    // Placeholder method for additional functionality
//    public boolean Emailsend(Users user) {
//        // TODO Auto-generated method stub
//        return false;
//    }
//}
}
