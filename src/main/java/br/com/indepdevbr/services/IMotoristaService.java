package br.com.indepdevbr.services;

import java.util.List;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;

public interface IMotoristaService {
	
	public Motorista inserir(Motorista motorista);
	
	public Motorista buscarPorId(Long idMotorista);

	public List<SolicitacaoVinculoTransportadoraMotorista> listarSolicitacoesVinculoTransportadoraMotoristaPorIdMotorista(Long idMotorista);
	
}
