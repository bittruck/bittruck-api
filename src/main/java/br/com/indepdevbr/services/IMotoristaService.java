package br.com.indepdevbr.services;

import br.com.indepdevbr.models.Motorista;

public interface IMotoristaService {
	
	public Motorista inserir(Motorista motorista);
	
	public Motorista buscarPorId(Long idMotorista);
	
}
