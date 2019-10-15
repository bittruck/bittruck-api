package br.com.indepdevbr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.indepdevbr.models.audit.AuditModel;

@Entity
public class Marca extends AuditModel {
	
	private static final long serialVersionUID = -789178367366866240L;

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
	@NotBlank
	@Column(unique = true)
	private String nomMarca;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomMarca() {
		return nomMarca;
	}

	public void setNomMarca(String nomMarca) {
		this.nomMarca = nomMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomMarca == null) ? 0 : nomMarca.hashCode());
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
		Marca other = (Marca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomMarca == null) {
			if (other.nomMarca != null)
				return false;
		} else if (!nomMarca.equals(other.nomMarca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Marca=["
					+ "id=" + id 
					+ ", nomMarca=" 
					+ nomMarca + ""
					+ "]";
	}
	
	

}
