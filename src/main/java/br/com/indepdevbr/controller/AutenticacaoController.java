package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
	
	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@Autowired
	private GerenciadorTokenJWT gerenciadorTokenJWT;
	
	@Autowired
	private OperadorServiceImp operadorServiceImp;
	
	@PostMapping("/login")
	public UsuarioAutenticado logar(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioService = usuarioServiceImp.validarUsuario(usuario);
		String strTokenJWT = gerenciadorTokenJWT.gerarToken(usuarioService);
		UsuarioAutenticado usuarioAutenticado = null;
		if(usuarioService.getTpoPermissao() == ENivelPermissao.OPERADOR 
				|| usuarioService.getTpoPermissao() == ENivelPermissao.OPERADOR_ADMIN) {
			Long idTransportadora = operadorServiceImp.buscarPorCodLogin(
					usuarioService.getCodLogin()).getTransportadora().getId();
			usuarioAutenticado = new UsuarioAutenticadoOperador(usuarioService.getCodLogin(), usuarioService.getTpoPermissao(), strTokenJWT, idTransportadora);							
		} else {
			usuarioAutenticado = new UsuarioAutenticado(usuarioService.getCodLogin(), usuarioService.getTpoPermissao(), strTokenJWT);
		}					
		return usuarioAutenticado;
	}
	
}
