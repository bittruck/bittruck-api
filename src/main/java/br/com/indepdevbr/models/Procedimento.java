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
	
}
