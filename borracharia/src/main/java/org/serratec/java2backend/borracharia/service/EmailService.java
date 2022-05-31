package org.serratec.java2backend.borracharia.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import org.serratec.java2backend.borracharia.dto.ServicoDTO;
import org.serratec.java2backend.borracharia.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
	private JavaMailSender emailSender;
	
	private final String emailRemetente = "serratecRenan@gmail.com";
	
	public JavaMailSender javaMailSender() {
		
	JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
	Properties prop = new Properties();
	
	enviarEmail.setHost("smtp.gmail.com");
	enviarEmail.setPort(465);
	enviarEmail.setUsername("serratecRenan@gmail.com");
	enviarEmail.setPassword("senha");
	enviarEmail.setProtocol("smtp");
	enviarEmail.setDefaultEncoding("UTF-8");
	prop.put("mail.smtp.auth", true);
	prop.put("mail.smtp.ssl.enable", true);
	enviarEmail.setJavaMailProperties(prop);
	
	return enviarEmail;
	
	}
	public void sendMessage(String to, String subject, String text) {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailRemetente);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
			emailSender.send(message);
			
	}
	
public void emailTeste(ServicoDTO servicoDTO) throws MessagingException, EmailException {
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		try {
			helper.setFrom(emailRemetente);
			helper.setTo("email destinatario");
			
			helper.setSubject("Serviço Borracharia");
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n" 
								+ "<body>\r\n"
									+ "<div>\r\n"
									+ "<h3># Borracharia 8-bits #</h3><br/>"
									+ "<h4>Segue os dados do serviço realizado:</h4><br/>"
									+ "---------------------------------------------------<br/>"
									+ "Serviço Realizado: " + servicoDTO.getTipoServ()+ "<br/>"
									+ "Valor do serviço: R$ " + servicoDTO.getValorServ() + "<br/>"
									+ "Data do serviço: " + servicoDTO.getDataServ() + "<br/>"
									+ "---------------------------------------------------<br/>"
									+ "<br/>"
									+ "Att,<br/>"
									+ "Ricardo F Pereira<br/>"
									+ "Equipe Borracharia 8-bits<br/>"
									+  "Uma mão na roda!!!"
									+ "</div>\r\n"
								+ "</body>\r\n"
							+ "</html>\r\n");
			helper.setText(sBuilder.toString(), true);
			
			emailSender.send(message);
			
		}catch (Exception e) {
			throw new EmailException("Houve erro ao enviar o email " + e.getMessage());
		}
	}

}
	

