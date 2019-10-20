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

import br.com.indepdevbr.models.Marca;
import br.com.indepdevbr.services.imp.MarcaServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de buscar, inserção e atualização de Marcas de veiculo",
		produces="application/json", consumes="application/json"
)
@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	
	@Autowired
	private MarcaServiceImp marcaServiceImp;
	
	@ApiOperation(value = "Endpoint de busca de marca por id")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna a Marca pelo id informado"),
		@ApiResponse(
				code = 404, 
				message = "Nenhuma marca encontrada pelo id informado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(value = "/{idMarca}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Marca buscarPorId(@PathVariable("idMarca") Long idMarca) {
		return marcaServiceImp.buscarPorId(idMarca);
	}
	
	@ApiOperation(value = "Endpoint de listagem de todas as marcas")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna todas as marcas"),
		@ApiResponse(
				code = 404, 
				message = "Nenhuma marca encontrada"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Marca> listarTodos() {
		return marcaServiceImp.listarTodos();
	}
	
	@ApiOperation(value = "Endpoint de listagem de marcas de forma paginada. "
			+ "É nesserário sempre enviar na url os seguintes parâmetros page, size e  sort."
			+ "Exemplo /marca?page=0&size=5&sort=criadoEm,Asc")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "retornar a pagina com informações correntes e a lista de marcas"),
		@ApiResponse(
				code = 404, 
				message = "Nenhuma marca encontrada"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(value = "/paginado", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Page<Marca> listarPaginado(Pageable pageable) {
		return marcaServiceImp.listarPaginado(pageable);
	}
	
	
	@ApiOperation(value = "Endpoint de buscar Marca por iniciais compativeis. Para isso, é necessário enviar o parametro nomMarca na URL."
			+ " Exemplo: /marca/contem?nomMarca=VOL. Retornará todas as marcas que começam com VOL no nome")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna a lista de marcas compativeis com o parametro"),
		@ApiResponse(
				code = 404, 
				message = "Nenhuma marca encontrada"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@GetMapping(value = "/comeca_com", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public List<Marca> buscarPorNomMarcaComecaCom(
			@RequestParam("nomMarca") String nomMarca) {
		return marcaServiceImp.buscarPorNomMarcaComecaCom(nomMarca);
	}
	
	
	@ApiOperation(value = "Endpoint de inserção de Marca")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna os parâmetros persistidos da Marca"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"ADMIN"})
	public Marca inserir(@Valid @RequestBody Marca marca) {
		return marcaServiceImp.inserir(marca);
	}
	
	@ApiOperation(value = "Endpoint de atualização de Marca")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna os parâmetros persistidos da Marca"),
		@ApiResponse(
				code = 404, 
				message = "Nenhuma marca encontrada pelo id informado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"ADMIN"})
	public Marca atualizar(@Valid @RequestBody Marca marca) {
		return marcaServiceImp.atualizar(marca);
	}
	
}
