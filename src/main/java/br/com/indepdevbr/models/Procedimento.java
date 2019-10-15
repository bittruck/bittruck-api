package br.com.indepdevbr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.indepdevbr.models.audit.AuditModel;

@Entity
public class Procedimento extends AuditModel {
	
	private static final long serialVersionUID = -5876046122237076951L;

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
	private String desProcedimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesProcedimento() {
		return desProcedimento;
	}

	public void setDesProcedimento(String desProcedimento) {
		this.desProcedimento = desProcedimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desProcedimento == null) ? 0 : desProcedimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Procedimento other = (Procedimento) obj;
		if (desProcedimento == null) {
			if (other.desProcedimento != null)
				return false;
		} else if (!desProcedimento.equals(other.desProcedimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procedimento=[id=" 
				+ id + ", desProcedimento=" 
				+ desProcedimento 
				+ "]";
	}
	
	
	
}
