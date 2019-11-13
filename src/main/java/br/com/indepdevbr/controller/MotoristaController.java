package br.com.indepdevbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;
import br.com.indepdevbr.models.VinculoTransportadoraMotorista;
import br.com.indepdevbr.models.enums.EStatusSolicitacao;
import br.com.indepdevbr.services.imp.MotoristaServiceImp;
import br.com.indepdevbr.services.imp.SolicitacaoVinculoTransportadoraMotoristaServiceImp;
import br.com.indepdevbr.services.imp.VinculoTransportadoraMotoristaServiceImp;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {
	
	@Autowired
	private MotoristaServiceImp motoristaServiceImp;
	
	@Autowired
	private SolicitacaoVinculoTransportadoraMotoristaServiceImp solicitacaoVinculoTransportadoraMotoristaServiceImp;
	
	@Autowired
	private VinculoTransportadoraMotoristaServiceImp vinculoTransportadoraMotoristaServiceImp; 
	
	@GetMapping("/{idMotorista}")
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Motorista buscarPorId(@PathVariable("idMotorista") Long idMotorista) {
		return motoristaServiceImp.buscarPorId(idMotorista);
	}
	
	@GetMapping("/{idMotorista}/solicitacao/transportadora")
	@Secured({"MOTORISTA"})
	public List<SolicitacaoVinculoTransportadoraMotorista> listarSolicitacoesPorIdMotorista(
			@PathVariable("idMotorista") Long idMotorista
			) {
		return solicitacaoVinculoTransportadoraMotoristaServiceImp.listarSolicitacoesVinculoTransportadoraMotoristaPorIdMotorista(idMotorista);
	}
	
	@PutMapping("/{idMotorista}/solicitacao/transportadora/{idSolicitacao}")
	@Secured({"MOTORISTA"})
	public SolicitacaoVinculoTransportadoraMotorista responderSolicitacaoVinculoTransportadoraMotorista(
			@PathVariable("idMotorista") Long idMotorista,
			@PathVariable("idSolicitacao") Long idSolicitacao,
			@RequestParam("des_resposta") EStatusSolicitacao desResposta
			) {
		return solicitacaoVinculoTransportadoraMotoristaServiceImp.responderSolicitacaoVinculoTransportadoraMotorista(idSolicitacao, idMotorista ,desResposta);
	}
	
	@GetMapping("/{idMotorista}/vinculo/transportadora")
	@Secured({"MOTORISTA"})
	public List<VinculoTransportadoraMotorista> listarVinculosComTransportadoraPorIdMotorista(
			@PathVariable("idMotorista") Long idMotorista
			) {
		return vinculoTransportadoraMotoristaServiceImp.listarVinculosPorIdMotorista(idMotorista);
	}
}
