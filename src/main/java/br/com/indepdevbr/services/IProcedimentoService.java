package br.com.indepdevbr.services;

import java.util.List;

import br.com.indepdevbr.models.Procedimento;

public interface IProcedimentoService {
	
	public Procedimento buscarPorId(Long id);
	
	public List<Procedimento> listarTodos();
	
}
