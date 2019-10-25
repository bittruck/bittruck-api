package br.com.indepdevbr.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.indepdevbr.models.audit.AuditModel;

@Entity
public class Administrador extends AuditModel {
	
	private static final long serialVersionUID = -4002331755114948111L;

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
	private String nomAdministrador;
	
	@Email
	@NotNull
	private String desEmail;
	
	
	@NotNull
	private String codCpf;
	
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
	
	public Administrador() {
		
	}
	
	public Administrador(String nomAdministrador, String desEmail, String codCpf, Usuario usuario) {
		this.nomAdministrador = nomAdministrador;
		this.desEmail = desEmail;
		this.codCpf = codCpf;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomAdministrador() {
		return nomAdministrador;
	}

	public void setNomAdministrador(String nomAdministrador) {
		this.nomAdministrador = nomAdministrador;
	}

	public String getDesEmail() {
		return desEmail;
	}

	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}

	public String getCodCpf() {
		return codCpf;
	}

	public void setCodCpf(String codCpf) {
		this.codCpf = codCpf;
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
		int result = super.hashCode();
		result = prime * result + ((codCpf == null) ? 0 : codCpf.hashCode());
		result = prime * result + ((desEmail == null) ? 0 : desEmail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomAdministrador == null) ? 0 : nomAdministrador.hashCode());
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
		Administrador other = (Administrador) obj;
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
		if (nomAdministrador == null) {
			if (other.nomAdministrador != null)
				return false;
		} else if (!nomAdministrador.equals(other.nomAdministrador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrador=["
					+ "id=" + id 
					+ ", nomAdministrador=" + nomAdministrador 
					+ ", desEmail=" + desEmail
					+ ", codCpf=" + codCpf
					+ ", criadoEm=" + getCriadoEm()
					+ ", atualizadoEm=" + getAtualizadoEm() 
					+ "]";
	}
	
	
	
}
