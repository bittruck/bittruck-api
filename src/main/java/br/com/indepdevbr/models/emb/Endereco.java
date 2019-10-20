package br.com.indepdevbr.models.emb;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco {
	
	@NotNull
	private String codCep;
	
	@NotNull
	private String desLogradouro;
	
	@NotNull
	private String numLogradouro;
	
	private String desCompletemento;
	
	@NotNull
	private String nomBairro;
	
	@NotNull
	private String nomCidade;
	
	@NotNull
	private String nomEstado;

	public String getCodCep() {
		return codCep;
	}

	public void setCodCep(String codCep) {
		this.codCep = codCep;
	}

	public String getDesLogradouro() {
		return desLogradouro;
	}

	public void setDesLogradouro(String desLogradouro) {
		this.desLogradouro = desLogradouro;
	}

	public String getNumLogradouro() {
		return numLogradouro;
	}

	public void setNumLogradouro(String numLogradouro) {
		this.numLogradouro = numLogradouro;
	}

	public String getDesCompletemento() {
		return desCompletemento;
	}

	public void setDesCompletemento(String desCompletemento) {
		this.desCompletemento = desCompletemento;
	}

	public String getNomBairro() {
		return nomBairro;
	}

	public void setNomBairro(String nomBairro) {
		this.nomBairro = nomBairro;
	}

	public String getNomCidade() {
		return nomCidade;
	}

	public void setNomCidade(String nomCidade) {
		this.nomCidade = nomCidade;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCep == null) ? 0 : codCep.hashCode());
		result = prime * result + ((desCompletemento == null) ? 0 : desCompletemento.hashCode());
		result = prime * result + ((desLogradouro == null) ? 0 : desLogradouro.hashCode());
		result = prime * result + ((nomBairro == null) ? 0 : nomBairro.hashCode());
		result = prime * result + ((nomCidade == null) ? 0 : nomCidade.hashCode());
		result = prime * result + ((nomEstado == null) ? 0 : nomEstado.hashCode());
		result = prime * result + ((numLogradouro == null) ? 0 : numLogradouro.hashCode());
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
		Endereco other = (Endereco) obj;
		if (codCep == null) {
			if (other.codCep != null)
				return false;
		} else if (!codCep.equals(other.codCep))
			return false;
		if (desCompletemento == null) {
			if (other.desCompletemento != null)
				return false;
		} else if (!desCompletemento.equals(other.desCompletemento))
			return false;
		if (desLogradouro == null) {
			if (other.desLogradouro != null)
				return false;
		} else if (!desLogradouro.equals(other.desLogradouro))
			return false;
		if (nomBairro == null) {
			if (other.nomBairro != null)
				return false;
		} else if (!nomBairro.equals(other.nomBairro))
			return false;
		if (nomCidade == null) {
			if (other.nomCidade != null)
				return false;
		} else if (!nomCidade.equals(other.nomCidade))
			return false;
		if (nomEstado == null) {
			if (other.nomEstado != null)
				return false;
		} else if (!nomEstado.equals(other.nomEstado))
			return false;
		if (numLogradouro == null) {
			if (other.numLogradouro != null)
				return false;
		} else if (!numLogradouro.equals(other.numLogradouro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco=["
					+ "codCep=" + codCep 
					+ ", desLogradouro=" + desLogradouro 
					+ ", numLogradouro=" + numLogradouro
					+ ", desCompletemento=" + desCompletemento 
					+ ", nomBairro=" + nomBairro 
					+ ", nomCidade=" + nomCidade
					+ ", nomEstado=" + nomEstado 
					+ "]";
	}
	
	
}
