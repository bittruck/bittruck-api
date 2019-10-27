package br.com.indepdevbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Endereco;
import br.com.indepdevbr.services.imp.EnderecoServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de pesquisa de endereço",
		produces="application/json", consumes="application/json"
)
@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoServiceImp enderecoServiceImp;
	
	@ApiOperation(value = "Metodo de busca de endereço por CEP")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna um endereço com base no CEP"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum endereço encontrado pelo cep informado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(value = "/buscarPorCep", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"OPERADOR_ADMIN, OPERADOR"})
	public List<Endereco> buscarPorCep(
			 @RequestParam("codCep") String codCep
			) {
		return enderecoServiceImp.buscarPorCep(codCep);
	}
	
	@GetMapping(value = "/buscarCepPorEndereco")
	@Secured({"OPERADOR_ADMIN", "OPERADOR"})
	public List<Endereco> buscarCepPorEndereco(
				@RequestParam("nomEstado") String nomEstado,
				@RequestParam("nomCidade") String nomCidade,
				@RequestParam("desLogradouro") String desLogradouro
			) {
		return enderecoServiceImp.buscarPorNomEstadoNomCidadeDesLogradouro(nomEstado, nomCidade, desLogradouro);
	}

}
