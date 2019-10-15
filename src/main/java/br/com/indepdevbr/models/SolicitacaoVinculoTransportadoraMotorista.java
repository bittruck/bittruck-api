package br.com.indepdevbr.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.indepdevbr.models.audit.AuditModel;
import br.com.indepdevbr.models.enums.EStatusSolicitacao;

@Entity
public class SolicitacaoVinculoTransportadoraMotorista extends AuditModel {
	
	private static final long serialVersionUID = -5648056826410670395L;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datSolicitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datResposta;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transportadora_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("transportadora_id")
	private Transportadora transportadora;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operador_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("operador_id")
	private Operador operador;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "motorista_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("motorista_id")
	private Motorista motorista;
	
	@Enumerated(EnumType.STRING)
	private EStatusSolicitacao desStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatSolicitacao() {
		return datSolicitacao;
	}

	public void setDatSolicitacao(Date datSolicitacao) {
		this.datSolicitacao = datSolicitacao;
	}

	public Date getDatResposta() {
		return datResposta;
	}

	public void setDatResposta(Date datResposta) {
		this.datResposta = datResposta;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public EStatusSolicitacao getDesStatus() {
		return desStatus;
	}

	public void setDesStatus(EStatusSolicitacao desStatus) {
		this.desStatus = desStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datResposta == null) ? 0 : datResposta.hashCode());
		result = prime * result + ((datSolicitacao == null) ? 0 : datSolicitacao.hashCode());
		result = prime * result + ((desStatus == null) ? 0 : desStatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motorista == null) ? 0 : motorista.hashCode());
		result = prime * result + ((operador == null) ? 0 : operador.hashCode());
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
		SolicitacaoVinculoTransportadoraMotorista other = (SolicitacaoVinculoTransportadoraMotorista) obj;
		if (datResposta == null) {
			if (other.datResposta != null)
				return false;
		} else if (!datResposta.equals(other.datResposta))
			return false;
		if (datSolicitacao == null) {
			if (other.datSolicitacao != null)
				return false;
		} else if (!datSolicitacao.equals(other.datSolicitacao))
			return false;
		if (desStatus != other.desStatus)
			return false;
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
		if (operador == null) {
			if (other.operador != null)
				return false;
		} else if (!operador.equals(other.operador))
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
		return "SolicitacaoVinculoTransportadoraMotorista=["
					+ "id=" + id 
					+ ", datSolicitacao=" + datSolicitacao
					+ ", datResposta=" + datResposta 
					+ ", transportadora=" + transportadora 
					+ ", operador=" + operador
					+ ", motorista=" + motorista 
					+ ", desStatus=" + desStatus 
					+ "]";
	}

	

}
