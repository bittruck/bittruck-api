package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Endereco;
import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.dto.TransportadoraOperador;
import br.com.indepdevbr.models.exception.BittruckException;
import br.com.indepdevbr.services.ITransportadoraService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.TransportadoraRepository;

@Service
public class TransportadoraServiceImp extends SuperClasse<TransportadoraRepository> implements ITransportadoraService {
	
	@Autowired
	private OperadorServiceImp operadorServiceImp;
	
	@Autowired
	private EnderecoServiceImp enderecoServiceImp;

	@Override
	public TransportadoraOperador cadastrarTransportadoraOperador(TransportadoraOperador transportadoraOperador) {
		try {
			Endereco endereco = enderecoServiceImp.inserir(transportadoraOperador.getEndereco());
			Transportadora transportadora = repository.save(new Transportadora(transportadoraOperador.getDesRazaoSocial(), 
															   transportadoraOperador.getDesEmailContato(), 
															   transportadoraOperador.getCodCnpj(), 
															   transportadoraOperador.getNumTelefone(), 
															   endereco));
			Operador operador = operadorServiceImp.cadastrar(transportadora, transportadoraOperador.getOperador());
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

}
