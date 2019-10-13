package br.com.indepdevbr.services.imp;

import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Endereco;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.services.IEnderecoService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.EnderecoRepository;

@Service
public class EnderecoServiceImp extends SuperClasse<EnderecoRepository> implements IEnderecoService {

	@Override
	public Endereco inserir(Endereco endereco) {
		try {
			Endereco enderecoPersist = repository.save(endereco);
			return enderecoPersist;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

}
