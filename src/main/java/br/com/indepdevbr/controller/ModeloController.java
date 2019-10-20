package br.com.indepdevbr.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Modelo;
import br.com.indepdevbr.services.imp.ModeloServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de buscar, inserção e atualização de Modelos de Marca de veiculo",
		produces="application/json", consumes="application/json"
)
@RestController
@RequestMapping("/marca/{idMarca}/modelo")
public class ModeloController {
	
	@Autowired
	private ModeloServiceImp modeloServiceImp;
	
	@ApiOperation(value = "Endpoint de busca de modelo pelo idMarca e id do modelo")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna a Modelo pelo idMarca e id Modelo informado"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum modelo encontrado pelo idMarca e id do modelo"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(value = "/{idModelo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Modelo buscarPorIdEIdMarca(
			@PathVariable("idMarca") Long idMarca,
			@PathVariable("idModelo") Long idModelo) {
		return modeloServiceImp.buscarPorIdEIdMarca(idModelo, idMarca);				
	}
	
	@ApiOperation(value = "Endpoint de listagem de todos os modelos pelo idMarca")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna a lista de todos os modelos indicado pelo idMarca"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum modelo encontrado pelo idMarca"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Modelo> listarTodosPorIdMarca(
			@PathVariable("idMarca") Long idMarca
			) {
		return modeloServiceImp.listarTodosPorIdMarca(idMarca);
	}
	
	
	@ApiOperation(value = "Endpoint de listagem de modelos de forma paginada. "
			+ "É nesserário sempre enviar na url os seguintes parâmetros page, size e  sort."
			+ " Exemplo /marca/1/modelo/paginado?page=0&size=5&sort=criadoEm,Asc")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "retornar a pagina com informações correntes e a lista de modelos"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum modelo encontrado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(value = "/paginado", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"MOTORISTA","OPERADOR","OPERADOR_ADMIN"})
	public Page<Modelo> listarPaginadoPorIdMarca(@PathVariable("idMarca") Long idMarca,
			Pageable pageable) {
		return modeloServiceImp.listarPaginadoPorIdMarca(idMarca, pageable);
	}
	
	@ApiOperation(value = "Endpoint de buscar Modelo por iniciais compativeis. Para isso, é necessário enviar o parametro nomModelo na URL."
			+ " Exemplo: /marca/1/modelo/contem?nomModelo=VOL. Retornará todas os modelos que começam VOL no nome e idMarca = 1")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna a lista de Modelos compativeis com o parametro nomModelo e idMarca passados"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum modelo encontrado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(value = "/comeca_com", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Modelo> buscarPorIdMarcaENomModeloComecaCom(
			@PathVariable("idMarca") Long idMarca,
			@RequestParam("nomModelo") String nomModelo) {		
		return modeloServiceImp.buscarPorIdMarcaENomModeloComecaCom(idMarca, nomModelo);
	}
	
	
	@ApiOperation(value = "Endpoint de inserção de Modelo")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna os parâmetros persistidos do Modelo"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"ADMIN"})
	public Modelo inserir(@PathVariable("idMarca") Long idMarca,
						  @Valid @RequestBody Modelo modelo) {
		return modeloServiceImp.inserir(idMarca, modelo);
	}
	
	@ApiOperation(value = "Endpoint de atualização de Modelo")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna os parâmetros persistidos do Modelo"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum modelo encontrado pelo IdMarca e Id do modelo informado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"ADMIN"})
	public Modelo atualizar(@PathVariable("idMarca") Long idMarca,
						  @Valid @RequestBody Modelo modelo) {
		return modeloServiceImp.atualizar(idMarca, modelo);
	}
	
}
