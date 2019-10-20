package br.com.indepdevbr.services;

import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.dto.TransportadoraOperador;

public interface ITransportadoraService {
	
	public TransportadoraOperador cadastrarTransportadoraOperador(TransportadoraOperador transportadoraOperador);
	
	public Transportadora alterar(Transportadora transportadora);
	
}
