package br.com.indepdevbr.services.imp;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Endereco;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IEnderecoService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.EnderecoRepository;
import br.com.indepdevbr.tools.clients.viacep.ViaCepClient;
import br.com.indepdevbr.tools.clients.viacep.domain.EnderecoViaCep;

@Service
public class EnderecoServiceImp extends SuperClasse<EnderecoRepository> implements IEnderecoService {

	@Autowired
	private ViaCepClient viaCepClient;
	
	@Override
	public Endereco inserir(Endereco endereco) {
		try {
			Endereco enderecoPersist = repository.save(endereco);
			return enderecoPersist;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}
	
	@Override
	public List<Endereco> buscarPorCep(String codCep) {
		try {
			List<Endereco> endereco = repository.findByCodCep(codCep);
			if(endereco.size() > 0)
				return endereco;
			List<EnderecoViaCep> enderecoViaCep = viaCepClient.buscarPorCep(codCep);
			if(enderecoViaCep.size() > 0) {
				List<Endereco> enderecos = enderecoViaCep
												.stream()
												.map( viaCep -> new Endereco(
																	viaCep.getCep(),
																	viaCep.getLogradouro(),
																	viaCep.getBairro(),
																	viaCep.getLocalidade(),
																	viaCep.getUf())
												 )
												.collect(Collectors.toList());
				return enderecos;
			} else
				throw new RecursoNaoEncontradoException("Nenhum endereco encontrado pelo cep informado");
		} catch(IOException e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		} 
	}

	@Override
	public List<Endereco> buscarPorNomEstadoNomCidadeDesLogradouro(String nomEstado, String nomCidade, String desLogradouro) {
		try {
			List<Endereco> enderecos = repository.findByNomEstadoAndNomCidadeAndDesLogradouro(nomEstado, nomCidade, desLogradouro);
			if(enderecos.size() > 0) {
				return enderecos;
			}
			enderecos = viaCepClient.buscarCepPorEndereco(nomEstado, nomCidade, desLogradouro)
									.stream()
									.map( viaCep -> {
										viaCep.setCep(viaCep.getCep().replace("-", ""));
										return viaCep;
									})
									.map( viaCep -> new Endereco(
											viaCep.getCep(),
											viaCep.getLogradouro(),
											viaCep.getBairro(),
											viaCep.getLocalidade(),
											viaCep.getUf())
									)
									.collect(Collectors.toList());
			if(enderecos.size() > 0 ) {
				return enderecos;
			} else {
				throw new RecursoNaoEncontradoException("Nenhum endereco encontrado pelo cep informado");
			}
		} catch(IOException e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		} 
	}

}
