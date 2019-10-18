package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.dto.TransportadoraOperador;
import br.com.indepdevbr.services.imp.MotoristaServiceImp;
import br.com.indepdevbr.services.imp.TransportadoraServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de cadastro para transportadoras, operadores e motoristas",
		produces="application/json", consumes="application/json"
)
@RequestMapping("/cadastro")
@RestController
public class CadastroController {
	
	@Autowired
	private MotoristaServiceImp motoristaServiceImp;
	
	@Autowired
	private TransportadoraServiceImp transportadoraServiceImp;
	
	@ApiOperation(value = "Endpoint de cadastro de motorista")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna os dados do motorista que foram persistido com sucesso"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PostMapping(value = "/motorista", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Motorista cadastrarMotorista(@Valid @RequestBody Motorista motorista) {		
		return motoristaServiceImp.inserir(motorista);
	}
	
	
	@ApiOperation(value = "Endpoint de cadastro da Transportadora com primeiro operador")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna os dados da Transportadora, Endereço e Operador que foram persistido com sucesso"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PostMapping( value = "/transportadora_operador", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TransportadoraOperador cadastrarTransportadoraOperador(
			@Valid @RequestBody TransportadoraOperador transportadoraOperador) {		
		return transportadoraServiceImp.cadastrarTransportadoraOperador(transportadoraOperador);
	}
}
