package br.com.indepdevbr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.services.imp.TransportadoraServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de modificações nos dados da transportadora",
		produces="application/json", consumes="application/json"
)
@RestController
@RequestMapping("/transportadora")
public class TransportadoraController {
	
	@Autowired
	private TransportadoraServiceImp transportadoraServiceImp;
	
	@ApiOperation(value = "Endpoint de autenticação")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retornar os dados atualizado da transportadora"),
		@ApiResponse(
				code = 404, 
				message = "Transportadora não encontrada pelo id"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição")
		}
	)
	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"OPERADOR_ADMIN, ADMIN"})
	public Transportadora alterar(Transportadora transportadora) {
		return transportadoraServiceImp.alterar(transportadora);
	}
	
}
