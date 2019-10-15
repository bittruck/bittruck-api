package br.com.indepdevbr.models.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"criadoEm", "atualizadoEm"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable  {
	
	private static final long serialVersionUID = 5792572642022720231L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "criado_em", nullable = false, updatable = false)
	@CreatedDate
	private Date criadoEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "atualizado_em", nullable = false)
	@LastModifiedDate
	private Date atualizadoEm;

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atualizadoEm == null) ? 0 : atualizadoEm.hashCode());
		result = prime * result + ((criadoEm == null) ? 0 : criadoEm.hashCode());
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
		AuditModel other = (AuditModel) obj;
		if (atualizadoEm == null) {
			if (other.atualizadoEm != null)
				return false;
		} else if (!atualizadoEm.equals(other.atualizadoEm))
			return false;
		if (criadoEm == null) {
			if (other.criadoEm != null)
				return false;
		} else if (!criadoEm.equals(other.criadoEm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuditModel=["
					+ "criadoEm=" + criadoEm 
					+ ", atualizadoEm=" + atualizadoEm 
					+ "]";
	}		
		
}