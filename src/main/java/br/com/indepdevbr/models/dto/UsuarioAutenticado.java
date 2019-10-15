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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLogin == null) ? 0 : codLogin.hashCode());
		result = prime * result + ((strTokenJWT == null) ? 0 : strTokenJWT.hashCode());
		result = prime * result + ((tpoPermissao == null) ? 0 : tpoPermissao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioAutenticado other = (UsuarioAutenticado) obj;
		if (codLogin == null) {
			if (other.codLogin != null)
				return false;
		} else if (!codLogin.equals(other.codLogin))
			return false;
		if (strTokenJWT == null) {
			if (other.strTokenJWT != null)
				return false;
		} else if (!strTokenJWT.equals(other.strTokenJWT))
			return false;
		if (tpoPermissao != other.tpoPermissao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioAutenticado=["
					+ "codLogin=" + codLogin 
					+ ", tpoPermissao=" + tpoPermissao 
					+ ", strTokenJWT=" + strTokenJWT 
					+ "]";
	}
	
	
}
