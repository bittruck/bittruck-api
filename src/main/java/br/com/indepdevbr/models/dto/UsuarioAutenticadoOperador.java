package br.com.indepdevbr.models.dto;

import br.com.indepdevbr.models.enums.ENivelPermissao;

public class UsuarioAutenticadoOperador extends UsuarioAutenticado {
	
	private Long transportadora_id;
	
	public UsuarioAutenticadoOperador() {};
	
	public UsuarioAutenticadoOperador(String codLogin, ENivelPermissao tpoPermissao, String strJWT, Long transportador_id) {
		super(codLogin, tpoPermissao, strJWT);
		this.transportadora_id = transportador_id;
	}

	public Long getTransportadora_id() {
		return transportadora_id;
	}

	public void setTransportadora_id(Long transportadora_id) {
		this.transportadora_id = transportadora_id;
	}
	
}
