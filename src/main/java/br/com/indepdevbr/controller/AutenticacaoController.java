package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.dto.UsuarioAutenticado;
import br.com.indepdevbr.models.dto.UsuarioAutenticadoOperador;
import br.com.indepdevbr.models.enums.ENivelPermissao;
import br.com.indepdevbr.sec.GerenciadorTokenJWT;
import br.com.indepdevbr.services.imp.OperadorServiceImp;
import br.com.indepdevbr.services.imp.UsuarioServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		value = "Endpoint de autenticação para operadores, motoristas e admins",
		produces="application/json", consumes="application/json"
)
@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
	
	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@Autowired
	private GerenciadorTokenJWT gerenciadorTokenJWT;
	
	@Autowired
	private OperadorServiceImp operadorServiceImp;
	
	@ApiOperation(value = "Endpoint de autenticação")
	@ApiResponses({
		@ApiResponse(
				code = 200, 
				message = "Retorna permissão, token e quando for operador retorna o id da transportadora"),
		@ApiResponse(
				code = 400, 
				message = "A combinação de usuário e senha é inválida"),
		@ApiResponse(
				code = 500, 
				message = "Ocorreu um erro ao processar a requisição"), }
	)
	@PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UsuarioAutenticado logar(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioService = usuarioServiceImp.validarUsuario(usuario);
		String strTokenJWT = gerenciadorTokenJWT.gerarToken(usuarioService);
		if(usuarioService.getTpoPermissao() == ENivelPermissao.OPERADOR 
				|| usuarioService.getTpoPermissao() == ENivelPermissao.OPERADOR_ADMIN) {
			Long idTransportadora = operadorServiceImp.buscarPorCodLogin(
					usuarioService.getCodLogin()).getTransportadora().getId();
			return new UsuarioAutenticadoOperador(usuarioService.getCodLogin(), usuarioService.getTpoPermissao(), strTokenJWT, idTransportadora);							
		} else {
			return new UsuarioAutenticado(usuarioService.getCodLogin(), usuarioService.getTpoPermissao(), strTokenJWT);
		}					
	}
	
}
