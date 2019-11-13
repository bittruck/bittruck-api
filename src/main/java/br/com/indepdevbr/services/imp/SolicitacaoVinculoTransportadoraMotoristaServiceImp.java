package br.com.indepdevbr.services.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.enums.EStatusSolicitacao;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.ISolicitacaoVinculoTransportadoraMotoristaService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.SolicitacaoVinculoTransportadoraMotoristaRepository;

@Service
public class SolicitacaoVinculoTransportadoraMotoristaServiceImp extends SuperClasse<SolicitacaoVinculoTransportadoraMotoristaRepository>
		implements ISolicitacaoVinculoTransportadoraMotoristaService {
	
	@Autowired
	private OperadorServiceImp operadorServiceImp;
	
	@Autowired
	private MotoristaServiceImp motoristaServiceImp;
	
	@Autowired
	private TransportadoraServiceImp transportadoraServiceImp;
	
	@Autowired
	private VinculoTransportadoraMotoristaServiceImp vinculoTransportadoraMotoristaServiceImp;
	
	@Override
	public SolicitacaoVinculoTransportadoraMotorista solicitarInclusaoMotorista(Long idTransportadora, Long idMotorista, Long idOperador) {
		try {
			Motorista motorista = motoristaServiceImp.buscarPorId(idMotorista);
			Operador operador = operadorServiceImp.buscarPorIdEIdTransportadora(idOperador, idTransportadora);
			Transportadora transportadora = transportadoraServiceImp.buscarPorId(idTransportadora);
			SolicitacaoVinculoTransportadoraMotorista solicitacao = new SolicitacaoVinculoTransportadoraMotorista(transportadora, motorista, operador, new Date(), EStatusSolicitacao.SOLICITADA);
			solicitacao = repository.save(solicitacao);
			return solicitacao;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}		
	}
	
	@Override
	public List<SolicitacaoVinculoTransportadoraMotorista> listarSolicitacoesVinculoTransportadoraMotoristaPorIdMotorista(Long idMotorista) {
		try {
			List<SolicitacaoVinculoTransportadoraMotorista> solicitacoes = repository.findByMotoristaId(idMotorista);
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
	
	@Override
	public SolicitacaoVinculoTransportadoraMotorista responderSolicitacaoVinculoTransportadoraMotorista(Long idSolicitacao, Long idMotorista, EStatusSolicitacao desResposta) {
		try {
			return repository.findByIdAndMotoristaId(idSolicitacao, idMotorista)
						.map( solicitacao -> {
							solicitacao.setDatResposta(new Date());
							solicitacao.setDesStatus(desResposta);
							if(desResposta == EStatusSolicitacao.APROVADA) {
								solicitacao.setDesStatus(desResposta);
								solicitacao.setDatResposta(new Date());
							}
							vinculoTransportadoraMotoristaServiceImp.inserir(idSolicitacao);
							return solicitacao;
						})
						.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhuma solicitação encontrada pelo id: " + idSolicitacao + "e idMotorista: " + idMotorista));			
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

}
