package br.com.indepdevbr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.indepdevbr.models.audit.AuditModel;

@Entity
public class Endereco extends AuditModel {
	
	private static final long serialVersionUID = -2723442361863352916L;

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
	private String codCep;
	
	@NotNull
	private String desLogradouro;
	
	@NotNull
	private String numLogradouro;
	
	@NotNull
	private String desCompletemento;
	
	@NotNull
	private String nomBairro;
	
	@NotNull
	private String nomCidade;
	
	@NotNull
	private String nomEstado;
	
	public Endereco() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
