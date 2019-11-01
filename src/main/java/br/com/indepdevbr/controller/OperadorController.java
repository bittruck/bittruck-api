package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.services.imp.OperadorServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de modificações nos dados dos operadores",
		produces="application/json", consumes="application/json"
)
@RestController
public class OperadorController {
	
	@Autowired
	private OperadorServiceImp operadorServiceImp;
	
	@ApiOperation(value = "Endpoint de inserir operador")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retornar os dados inseridos do operador"),
		@ApiResponse(
				code = 404, 
				message = "Transportadora não encontrada pelo id"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição")
		}
	)
	@PostMapping(value = "/transportadora/{idTransportadora}/operador", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"OPERADOR_ADMIN"})
	public Operador inserir(
			@PathVariable("idTransportadora") Long idTransportadora,
			@Valid @RequestBody Operador operador) {
		return operadorServiceImp.inserir(idTransportadora, operador);
	}
	
	@ApiOperation(value = "Endpoint de listagem de operador")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retornar um objeto com dados da paginação e uma lista de operadores da pagina corrente"),
		@ApiResponse(
				code = 404, 
				message = "Transportadora não encontrada pelo id"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição")
		}
	)
	@GetMapping(value = "/transportadora/{idTransportadora}/operador", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"OPERADOR_ADMIN"})
	public Page<Operador> listaPorIdTransportadoraPaginado(
			@PathVariable("idTransportadora") Long idTransportadora,
			Pageable pageable
			) {
		return operadorServiceImp.listaPorIdTransportadoraPaginado(idTransportadora, pageable);
	}
	

	@ApiOperation(value = "Endpoint de busca de operador")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna dados do operador com base no id da transportadora e id do operador"),
		@ApiResponse(
				code = 404, 
				message = "Operador não encontrado pelo id e pelo id da transportadora"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição")
		}
	)
	@GetMapping(
			value = "/transportadora/{idTransportadora}/operador/{idOperador}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"OPERADOR_ADMIN"})
	public Operador buscarPorIdEIdTransportadora(
			@PathVariable("idTransportadora") Long idTransportadora,
			@PathVariable("idOperador") Long idOperador
			) {
		
		return operadorServiceImp.buscarPorIdEIdTransportadora(idOperador, idTransportadora);
	}
	
	@PutMapping(value = "/transportadora/{idTransportadora}/operador}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Operador atualizar(
			@PathVariable("idTransportadora") Long idTransportadora,
			@Valid @RequestBody Operador operador
			) {
		return operadorServiceImp.atualizar(idTransportadora, operador);
	}
	
}
