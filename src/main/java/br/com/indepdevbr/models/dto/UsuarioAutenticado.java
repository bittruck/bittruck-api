package br.com.indepdevbr.models.dto;

import br.com.indepdevbr.models.enums.ENivelPermissao;

public class UsuarioAutenticado {
	
	private String codLogin;
	
	private ENivelPermissao tpoPermissao;
	
	private String strTokenJWT;
	
	public UsuarioAutenticado() {};
	
	public UsuarioAutenticado(String codLogin, ENivelPermissao tpoPermissao, String strTokenJWT) {
		this.codLogin = codLogin;
		this.tpoPermissao = tpoPermissao;
		this.strTokenJWT = strTokenJWT;
	}

	public String getCodLogin() {
		return codLogin;
	}

	public void setCodLogin(String codLogin) {
		this.codLogin = codLogin;
	}

	public ENivelPermissao getTpoPermissao() {
		return tpoPermissao;
	}

	public void setTpoPermissao(ENivelPermissao tpoPermissao) {
		this.tpoPermissao = tpoPermissao;
	}

	public String getStrTokenJWT() {
		return strTokenJWT;
	}

	public void setStrTokenJWT(String strTokenJWT) {
		this.strTokenJWT = strTokenJWT;
	}
	
	
}
