package blog.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan
public class MailConfig
{
    @Bean
    public JavaMailSender javaMailService()
    {
	JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	
	javaMailSender.setProtocol("SMTP");
	javaMailSender.setHost("smtp.gmail.com");
	
	javaMailSender.setUsername("Wildfly@lifna.com");
	javaMailSender.setPassword("WildflyConitaf10");
	
	Properties props = new Properties();
	props.put("mail.smtp.starttls.enable", false);
	javaMailSender.setJavaMailProperties(props);
	
	return javaMailSender;
    }

    @Bean
    public SimpleMailMessage simpleMailMessage()
    {
	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	return simpleMailMessage;
    }
}