package blog;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan
public class ExtraConfig {
@Bean
    public JavaMailSender mailSender() {
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setProtocol("smtp");
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("WildflyConitaf@gmail.com");
        javaMailSender.setPassword("wildflyconitaf10");
        
        Properties props = new Properties();

 	      
 	props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.starttls.enable", "true");
        
        javaMailSender.setJavaMailProperties(props);
        return javaMailSender;
    }
}