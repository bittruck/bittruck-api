package br.com.indepdevbr.tools.mail.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.com.indepdevbr.tools.mail.IEmailService;

@Component
public class EmailServiceImp implements IEmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Override
	public void enviarEmail(String assunto, String corpo, String... para) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(para);
		mailMessage.setSubject(assunto);
		mailMessage.setText(corpo);
		emailSender.send(mailMessage);
	}

}
