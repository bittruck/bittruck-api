package br.com.indepdevbr.services.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.dto.cadastro_transportadora.TransportadoraOperador;
import br.com.indepdevbr.models.enums.EStatusSolicitacao;
import br.com.indepdevbr.models.exception.BittruckException;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.ITransportadoraService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.SolicitacaoVinculoTransportadoraMotoristaRepository;
import br.com.indepdevbr.services.repository.TransportadoraRepository;

@Service
public class TransportadoraServiceImp extends SuperClasse<TransportadoraRepository> implements ITransportadoraService {
	
	@Autowired
	private OperadorServiceImp operadorServiceImp;
	
	@Autowired
	private SolicitacaoVinculoTransportadoraMotoristaRepository solicitacaoVinculoTransportadoraMotoristaRepository;
	
	@Autowired
	private MotoristaServiceImp motoristaServiceImp;
	

	@Override
	public TransportadoraOperador cadastrarTransportadoraOperador(TransportadoraOperador transportadoraOperador) {
		try {
			Transportadora transportadora = repository.save(new Transportadora(transportadoraOperador.getDesRazaoSocial(), 
															   transportadoraOperador.getDesEmailContato(), 
															   transportadoraOperador.getCodCnpj(), 
															   transportadoraOperador.getNumTelefone(), 
															   transportadoraOperador.getEndereco()));
			Operador operador = operadorServiceImp.cadastrarPrimeiroOperador(transportadora, transportadoraOperador.getOperador());
			TransportadoraOperador cadastroTransportadoraOperador = 
					new TransportadoraOperador(transportadora.getId(), transportadora.getCriadoEm(), transportadora.getAtualizadoEm(),
												transportadora.getCodCnpj(), transportadora.getDesEmailContato(),transportadora.getDesRazaoSocial(), 
												transportadora.getMcaAtivo(), transportadora.getNumTelefone(), 
												transportadora.getEndereco(), 
												operador);
			return cadastroTransportadoraOperador;
		} catch (Exception e) {
			throw new BittruckException("Ocorreu um erro no processamento da requisição", e);
		}
	}
	
	

	@Override
	public Transportadora alterar(Transportadora transportadora) {
		try {
			if(repository.existsById(transportadora.getId())) {
				throw new RecursoNaoEncontradoException("Nenhuma transportadora encontrada pelo id: " + transportadora.getId());
			}
			return repository.save(transportadora);
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}
	
	@Override
	public SolicitacaoVinculoTransportadoraMotorista solicitarInclusaoMotorista(Long idTransportadora, Long idMotorista, Long idOperador) {
		try {
			Motorista motorista = motoristaServiceImp.buscarPorId(idMotorista);
			Operador operador = operadorServiceImp.buscarPorIdEIdTransportadora(idOperador, idTransportadora);
			Transportadora transportadora = repository.findById(idTransportadora).get();
			SolicitacaoVinculoTransportadoraMotorista solicitacao = new SolicitacaoVinculoTransportadoraMotorista(transportadora, motorista, operador, new Date(), EStatusSolicitacao.SOLICITADA);
			solicitacao = solicitacaoVinculoTransportadoraMotoristaRepository.save(solicitacao);
			return solicitacao;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}		
	}

}
