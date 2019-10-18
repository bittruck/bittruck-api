package br.com.indepdevbr.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.Transportadora;

public interface IOperadorService {
	
	public Operador buscarPorCodLogin(String desEmail);
	
	public Operador cadastrar(Transportadora transportadora, Operador operador);
	
	public Operador inserir(Long idTransportadora, Operador operador);

	public Operador buscarPorIdEIdTransportadora(Long id, Long transportadoraId);
	
	public Page<Operador> listaPorIdTransportadoraPaginado(Long transportadoraId, Pageable pageable);
	
}
