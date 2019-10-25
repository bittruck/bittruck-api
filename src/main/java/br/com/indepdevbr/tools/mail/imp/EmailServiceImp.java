package br.com.indepdevbr.tools.mail.imp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.com.indepdevbr.tools.mail.IEmailService;

@Component
public class EmailServiceImp implements IEmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	private final Logger logger = LogManager.getLogger(EmailServiceImp.class);
	
	@Override
	public void enviarEmail(String assunto, String corpo, String... para) {
		try {
			logger.info("metodo=enviarEmail, para=[" + para + "], assunto=" + assunto + ", corpo=" + corpo);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(para);
			mailMessage.setSubject(assunto);
			mailMessage.setText(corpo);
			emailSender.send(mailMessage);
		} catch (Exception e) {
			logger.error("metodo=enviarEmail, throw=" + e.getLocalizedMessage(), e);
		}
	}

}
