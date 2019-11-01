package br.com.indepdevbr.models.dto.autenticacao;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((transportadora_id == null) ? 0 : transportadora_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioAutenticadoOperador other = (UsuarioAutenticadoOperador) obj;
		if (transportadora_id == null) {
			if (other.transportadora_id != null)
				return false;
		} else if (!transportadora_id.equals(other.transportadora_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioAutenticadoOperador=["					
					+ "codLogin=" + getCodLogin()
					+ ", tpoPermissao=" + getTpoPermissao() 
					+ ", srTokenJWT=" + getStrTokenJWT()
					+ ", transportadora_id=" + transportadora_id
					+ "]";
	}			
	
}
