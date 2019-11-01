package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.services.imp.UsuarioServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de modificações nos dados dos usuarios",
		produces="application/json", consumes="application/json"
)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@ApiOperation(value = "Endpoint de de modificações nos dados dos usuarios")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna confirmação de alteração dos dados"),
		@ApiResponse(
				code = 404, 
				message = "Nenhum usuário encontrado pelo codLogin informado"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"MOTORISTA", "OPERADOR", "OPERADOR_ADMIN", "ADMIN"})
	public ResponseEntity<?> atualizar(@Valid @RequestBody Usuario usuario) {
		usuarioServiceImp.atualizar(usuario);
		return ResponseEntity.ok().build();
	}
}
