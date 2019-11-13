package br.com.indepdevbr.services;

import java.util.List;

import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;
import br.com.indepdevbr.models.enums.EStatusSolicitacao;

public interface ISolicitacaoVinculoTransportadoraMotoristaService {

	public SolicitacaoVinculoTransportadoraMotorista solicitarInclusaoMotorista(Long idTransportadora, Long idMotorista,
			Long idOperador);

	public List<SolicitacaoVinculoTransportadoraMotorista> listarSolicitacoesVinculoTransportadoraMotoristaPorIdMotorista(
			Long idMotorista);

	public SolicitacaoVinculoTransportadoraMotorista responderSolicitacaoVinculoTransportadoraMotorista(Long idSolicitacao,
			Long idMotorista, EStatusSolicitacao desResposta);

}
