package br.com.indepdevbr.services;

import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.Transportadora;

public interface IOperadorService {
	
	public Operador buscarPorCodLogin(String desEmail);
	
	public Operador cadastrar(Transportadora transportadora, Operador operador);
	
	public Operador inserir(Long idTransportadora, Operador operador);
	
}
