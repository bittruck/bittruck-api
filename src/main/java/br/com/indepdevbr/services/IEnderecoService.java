package br.com.indepdevbr.services;

import java.util.List;

import br.com.indepdevbr.models.Endereco;

public interface IEnderecoService {
	
	public Endereco inserir(Endereco endereco);

	public List<Endereco> buscarPorCep(String codCep);
	
	public List<Endereco> buscarPorNomEstadoNomCidadeDesLogradouro(String nomEstado, String nomCidade, String desLogradouro);
	
}
