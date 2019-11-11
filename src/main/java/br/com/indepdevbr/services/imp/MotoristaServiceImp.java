package br.com.indepdevbr.services.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;
import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.enums.EStatusSolicitacao;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IMotoristaService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.MotoristaRepository;
import br.com.indepdevbr.services.repository.SolicitacaoVinculoTransportadoraMotoristaRepository;

@Service
public class MotoristaServiceImp extends SuperClasse<MotoristaRepository> implements IMotoristaService {

	
	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@Autowired
	private SolicitacaoVinculoTransportadoraMotoristaRepository solicitacaoVinculoTransportadoraMotoristaRepository;
	
	@Override
	public Motorista inserir(Motorista motorista) {
		try {
			Usuario usuarioMotorista = usuarioServiceImp.inserir(motorista.getUsuario());
			motorista.setUsuario(usuarioMotorista);
			Motorista motoristaPersist = repository.save(motorista);
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
	
	
	public List<SolicitacaoVinculoTransportadoraMotorista> listarSolicitacoesVinculoTransportadoraMotoristaPorIdMotorista(Long idMotorista) {
		try {
			List<SolicitacaoVinculoTransportadoraMotorista> solicitacoes = solicitacaoVinculoTransportadoraMotoristaRepository.findByMotoristaId(idMotorista);
			if(solicitacoes.size() > 0)
				return solicitacoes;
			else 
				throw new RecursoNaoEncontradoException("Nenhuma solicitação encontrada");
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}
	
	public SolicitacaoVinculoTransportadoraMotorista responderSolicitacaoVinculoTransportadoraMotorista(Long idSolicitacao, Long idMotorista, EStatusSolicitacao desResposta) {
		try {
			return solicitacaoVinculoTransportadoraMotoristaRepository
					.findByIdAndMotoristaId(idSolicitacao, idMotorista)
					.map( solicitacao -> {
						solicitacao.setDatResposta(new Date());
						solicitacao.setDesStatus(desResposta);
						return solicitacaoVinculoTransportadoraMotoristaRepository.save(solicitacao);
					})
					.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhuma solicitação encontrada pelo id: " + idSolicitacao));
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}
	

}
