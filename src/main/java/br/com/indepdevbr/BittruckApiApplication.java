package br.com.indepdevbr;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.indepdevbr.models.Administrador;
import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.enums.ENivelPermissao;
import br.com.indepdevbr.models.enums.ESimNao;
import br.com.indepdevbr.services.imp.AdministradorServiceImp;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class BittruckApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BittruckApiApplication.class, args);
	}

	private List<Administrador> admins = Arrays.asList(
				new Administrador("Welton Leão Machado", "welton@bittruck.com.br", "12345678978", 
						new Usuario("welton@bittruck.com.br", "123456", ESimNao.SIM, ENivelPermissao.ADMIN)),
				new Administrador("Paulo Henrique", "paulo@bittruck.com.br", "12345678978", 
						new Usuario("paulo@bittruck.com.br", "123456", ESimNao.SIM, ENivelPermissao.ADMIN))
			);
	
	@Autowired
	private AdministradorServiceImp service;
	
	@Override
	public void run(String... args) throws Exception {
		admins.forEach(service::inserir);		
	} 

}
