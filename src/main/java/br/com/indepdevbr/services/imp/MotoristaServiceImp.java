package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.config.EProperties;
import br.com.indepdevbr.config.GeneralProperties;
import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IMotoristaService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.MotoristaRepository;
import br.com.indepdevbr.tools.mail.imp.EmailServiceImp;

@Service
public class MotoristaServiceImp extends SuperClasse<MotoristaRepository> implements IMotoristaService {

	
	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
//	@Autowired
//	private EmailServiceImp emailServiceImp;
//	
//	@Autowired
//	private GeneralProperties properties;
	
	@Override
	public Motorista inserir(Motorista motorista) {
		try {
			Usuario usuarioMotorista = usuarioServiceImp.inserir(motorista.getUsuario());
			motorista.setUsuario(usuarioMotorista);
			Motorista motoristaPersist = repository.save(motorista);
//			String corpoMensamge = "Por favor, clique no link abaixo para ativar seu cadastro:\n\n\n\n\n\n";
//			corpoMensamge += properties.getPropertyValue(EProperties.BITTRUCK_API_HOST) + "/api/motorista/ativar";
//			emailServiceImp.enviarEmail("Ativação de cadastro", corpoMensamge, "potatobs@gmail.com");
			return motoristaPersist;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

	@Override
	public Motorista buscarPorId(Long idMotorista) {
		try {
			Motorista motorista = repository.findById(idMotorista)
						.map( m -> {
							return m;
						}).orElseThrow(() -> new RecursoNaoEncontradoException("Motorista não encontrado pelo id:" + idMotorista));
			return motorista;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro no processsamento da requisição", e);
			}
		}
	}

}
