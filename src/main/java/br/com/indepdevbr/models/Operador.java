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
	
	@NotNull
	private String nomOperador;
	
	@NotNull
	@Column(unique = true)
	private String codCpf;
	
	@NotNull
	@Column(unique = true)
	private String desEmail;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCpf == null) ? 0 : codCpf.hashCode());
		result = prime * result + ((desEmail == null) ? 0 : desEmail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomOperador == null) ? 0 : nomOperador.hashCode());
		result = prime * result + ((transportadora == null) ? 0 : transportadora.hashCode());
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
		Operador other = (Operador) obj;
		if (codCpf == null) {
			if (other.codCpf != null)
				return false;
		} else if (!codCpf.equals(other.codCpf))
			return false;
		if (desEmail == null) {
			if (other.desEmail != null)
				return false;
		} else if (!desEmail.equals(other.desEmail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomOperador == null) {
			if (other.nomOperador != null)
				return false;
		} else if (!nomOperador.equals(other.nomOperador))
			return false;
		if (transportadora == null) {
			if (other.transportadora != null)
				return false;
		} else if (!transportadora.equals(other.transportadora))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operador=["
					+ "id=" + id 
					+ ", nomOperador=" + nomOperador 
					+ ", codCpf=" + codCpf 
					+ ", desEmail=" + desEmail
					+ ", transportadora=" + transportadora 
					+ "]";
	}		

}
