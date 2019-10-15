package br.com.indepdevbr.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.indepdevbr.models.audit.AuditModel;

@Entity
public class VinculoTransportadoraMotorista extends AuditModel {

	private static final long serialVersionUID = 4260731877331937652L;

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
	
	@OneToOne(
			fetch = FetchType.LAZY, 
			optional = false
	)
    @JoinColumn(
    		name = "solicitacao_vinculo_transportadora_motorista_id", 
    		nullable = false
    )
	private SolicitacaoVinculoTransportadoraMotorista solicitacaoVinculoTransportadoraMotorista;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "motorista_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("motorista_id")
	private Motorista motorista;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transportadora_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("transportadora_id")
	private Transportadora transportadora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoVinculoTransportadoraMotorista getSolicitacaoVinculoTransportadoraMotorista() {
		return solicitacaoVinculoTransportadoraMotorista;
	}

	public void setSolicitacaoVinculoTransportadoraMotorista(
			SolicitacaoVinculoTransportadoraMotorista solicitacaoVinculoTransportadoraMotorista) {
		this.solicitacaoVinculoTransportadoraMotorista = solicitacaoVinculoTransportadoraMotorista;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motorista == null) ? 0 : motorista.hashCode());
		result = prime * result + ((solicitacaoVinculoTransportadoraMotorista == null) ? 0
				: solicitacaoVinculoTransportadoraMotorista.hashCode());
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
		VinculoTransportadoraMotorista other = (VinculoTransportadoraMotorista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motorista == null) {
			if (other.motorista != null)
				return false;
		} else if (!motorista.equals(other.motorista))
			return false;
		if (solicitacaoVinculoTransportadoraMotorista == null) {
			if (other.solicitacaoVinculoTransportadoraMotorista != null)
				return false;
		} else if (!solicitacaoVinculoTransportadoraMotorista.equals(other.solicitacaoVinculoTransportadoraMotorista))
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
		return "VinculoTransportadoraMotorista=["
					+ "id=" + id 
					+ ", solicitacaoVinculoTransportadoraMotorista=" + solicitacaoVinculoTransportadoraMotorista 
					+ ", motorista=" + motorista 
					+ ", transportadora=" + transportadora 
					+ "]";
	}
				
}
