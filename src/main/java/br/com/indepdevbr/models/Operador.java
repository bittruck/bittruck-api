package br.com.indepdevbr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.indepdevbr.models.audit.AuditModel;

@Entity
public class Operador extends AuditModel {

	private static final long serialVersionUID = -8232741117056425397L;

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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transportadora_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("transportadora_id")
	private Transportadora transportadora;
	
	@OneToOne(
			fetch = FetchType.LAZY, 
			optional = false
	)
    @JoinColumn(
    		name = "usuario_id", 
    		nullable = false
    )
	@JsonBackReference
	private Usuario usuario;

	@NotNull
	private String nomOperador;
	
	@NotNull
	@Column(unique = true)
	private String codCpf;
	
	@NotNull
	@Column(unique = true)
	private String desEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNomOperador() {
		return nomOperador;
	}

	public void setNomOperador(String nomOperador) {
		this.nomOperador = nomOperador;
	}

	public String getCodCpf() {
		return codCpf;
	}

	public void setCodCpf(String codCpf) {
		this.codCpf = codCpf;
	}

	public String getDesEmail() {
		return desEmail;
	}

	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}

}
