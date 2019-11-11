package br.com.indepdevbr.services;

import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.dto.cadastro_transportadora.TransportadoraOperador;

public interface ITransportadoraService {
	
	public TransportadoraOperador cadastrarTransportadoraOperador(TransportadoraOperador transportadoraOperador);
	
	public Transportadora alterar(Transportadora transportadora);

	public SolicitacaoVinculoTransportadoraMotorista solicitarInclusaoMotorista(Long idTransportadora, Long idMotorista,
			Long idOperador);
	
}
