package br.com.indepdevbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Procedimento;
import br.com.indepdevbr.services.imp.ProcedimentoServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de buscar de tipo de procedimento",
		produces="application/json", consumes="application/json"
)
@RestController
@RequestMapping("/procedimento")
public class ProcedimentoController {
	
	@Autowired
	private ProcedimentoServiceImp procedimentoServiceImp;
	
	@ApiOperation(value = "Endpoint de busca de procedimento pelo id informado")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna o procecdimento pelo id informado"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum procedimento encontrado pelo id informado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping("/{idProcedimento}")
	@Secured({"OPERADOR, OPERADOR_ADMIN"})
	public Procedimento buscarPorId(@PathVariable("idProcedimento") Long idProcedimento) {
		return procedimentoServiceImp.buscarPorId(idProcedimento);
	}
	
	
	@ApiOperation(value = "Endpoint de listagem de todos os procecimentos")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna uma lista com todos os procedimentos"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum procedimento encontrado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping
	@Secured({"OPERADOR, OPERADOR_ADMIN"})
	public List<Procedimento> listaTodos() {
		return procedimentoServiceImp.listarTodos();
	}
	
}
