package br.com.indepdevbr.tools.mail;

public interface IEmailService {
	public void enviarEmail(String assunto, String corpo, String... para);
}
