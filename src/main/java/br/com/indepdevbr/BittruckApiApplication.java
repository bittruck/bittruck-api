package br.com.indepdevbr;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.enums.ENivelPermissao;
import br.com.indepdevbr.models.enums.ESimNao;
import br.com.indepdevbr.services.imp.UsuarioServiceImp;

@SpringBootApplication
@EnableJpaAuditing
public class BittruckApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BittruckApiApplication.class, args);
	}

	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	private List<Usuario> usuarios = Arrays.asList(
			new Usuario("admin1", "123456", ESimNao.SIM, ENivelPermissao.ADMIN),
			new Usuario("admin2", "123456", ESimNao.SIM, ENivelPermissao.ADMIN)
			);
	
	@Override
	public void run(String... args) throws Exception {
		usuarios.forEach(usuarioServiceImp::inserir);
	}

}
