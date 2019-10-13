package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Endereco;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.dto.TransportadoraOperador;
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
	public void cadastrarTransportadoraOperador(TransportadoraOperador transportadoraOperador) {
		try {
			Endereco endereco = enderecoServiceImp.inserir(transportadoraOperador.getEndereco());
			Transportadora transportadora = repository.save(new Transportadora(transportadoraOperador.getDesRazaoSocial(), 
															   transportadoraOperador.getDesEmailContato(), 
															   transportadoraOperador.getCodCnpj(), 
															   transportadoraOperador.getNumTelefone(), 
															   endereco));
			operadorServiceImp.cadastrar(transportadora, transportadoraOperador.getOperador());			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
