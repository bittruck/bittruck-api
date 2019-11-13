package br.com.indepdevbr.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;
import br.com.indepdevbr.models.VinculoTransportadoraMotorista;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IVinculoTransportadoraMotoristaService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.SolicitacaoVinculoTransportadoraMotoristaRepository;
import br.com.indepdevbr.services.repository.VinculoTransportadoraMotoristaRepository;

@Service
public class VinculoTransportadoraMotoristaServiceImp extends SuperClasse<VinculoTransportadoraMotoristaRepository>
		implements IVinculoTransportadoraMotoristaService {

	
	@Autowired
	private SolicitacaoVinculoTransportadoraMotoristaRepository solicitacaoVinculoTransportadoraMotoristaRepository;
	
	@Override
	public VinculoTransportadoraMotorista inserir(Long idSolicitacaoVinculoTransportadoraMotorista) {
		try {
			SolicitacaoVinculoTransportadoraMotorista solicitacaoVinculo = 
			solicitacaoVinculoTransportadoraMotoristaRepository.findById(idSolicitacaoVinculoTransportadoraMotorista)
																	.map( solicitacao -> solicitacao)
																	.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhuma solicitação encontrada pelo id: " + idSolicitacaoVinculoTransportadoraMotorista));
			VinculoTransportadoraMotorista vinculo = new VinculoTransportadoraMotorista();
			vinculo.setMotorista(solicitacaoVinculo.getMotorista());
			vinculo.setTransportadora(solicitacaoVinculo.getTransportadora());
			vinculo.setSolicitacaoVinculoTransportadoraMotorista(solicitacaoVinculo);
			return repository.save(vinculo);
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}
	
	public List<VinculoTransportadoraMotorista> listarVinculosPorIdMotorista(Long idMotorista) {
		try {
			List<VinculoTransportadoraMotorista> vinculos = repository.findByMotoristaId(idMotorista);
			if(vinculos.size() > 0 ) 
				return vinculos;
			else
				throw new RecursoNaoEncontradoException("Nenhum vinculo encontrado pelod idMotorista: " + idMotorista);
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}
	
}
