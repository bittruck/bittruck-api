package br.com.indepdevbr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.indepdevbr.models.audit.AuditModel;

@Entity
public class EnderecoComplementar extends AuditModel {
	
	private static final long serialVersionUID = 764094983729820923L;

	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private Long id;
	
	@NotNull
	private String numLogradouro;
	
	private String desCompletemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((desCompletemento == null) ? 0 : desCompletemento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numLogradouro == null) ? 0 : numLogradouro.hashCode());
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
		EnderecoComplementar other = (EnderecoComplementar) obj;
		if (desCompletemento == null) {
			if (other.desCompletemento != null)
				return false;
		} else if (!desCompletemento.equals(other.desCompletemento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "EnderecoComplementar["
						+ "id=" + id 
						+ ", numLogradouro=" + numLogradouro 
						+ ", desCompletemento=" + desCompletemento 
						+ "]";
	}
	
	
	
}
