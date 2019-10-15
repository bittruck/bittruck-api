package br.com.indepdevbr.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class SolicitacaoVinculoMotoristaVeiculo extends AuditModel {

	private static final long serialVersionUID = -5661124385268128225L;


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
    @JoinColumn(name = "motorista_solicitante_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("motorista_solicitante_id")
	private Motorista motoristaSolicitante;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "motorista_solicitado_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("motorista_solicitado_id")
	private Motorista motoristaSolicitado;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("veiculo_id")
	private Veiculo veiculo;
	
	@ManyToMany(
			fetch = FetchType.LAZY, 
			cascade = { 
					CascadeType.PERSIST, 
					CascadeType.MERGE 
					}
	)
	@JoinTable(
			name = "solicitacao_vinculo_motorista_veiculo_vinculo_motorista_veiculo", 
			joinColumns = {
					@JoinColumn(name = "solicitacao_vinculo_motorista_veiculo_id") 
			}, 
			inverseJoinColumns = { 
					@JoinColumn(name = "vinculo_motorista_veiculo_id")
			}
	)
	private Set<VinculoMotoristaVeiculo> vinculoMotoristaVeiculos = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
	private EStatusSolicitacao desStatusSolicitacao;

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

	public Motorista getMotoristaSolicitante() {
		return motoristaSolicitante;
	}

	public void setMotoristaSolicitante(Motorista motoristaSolicitante) {
		this.motoristaSolicitante = motoristaSolicitante;
	}

	public Motorista getMotoristaSolicitado() {
		return motoristaSolicitado;
	}

	public void setMotoristaSolicitado(Motorista motoristaSolicitado) {
		this.motoristaSolicitado = motoristaSolicitado;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Set<VinculoMotoristaVeiculo> getVinculoMotoristaVeiculos() {
		return vinculoMotoristaVeiculos;
	}

	public void setVinculoMotoristaVeiculos(Set<VinculoMotoristaVeiculo> vinculoMotoristaVeiculos) {
		this.vinculoMotoristaVeiculos = vinculoMotoristaVeiculos;
	}

	public EStatusSolicitacao getDesStatusSolicitacao() {
		return desStatusSolicitacao;
	}

	public void setDesStatusSolicitacao(EStatusSolicitacao desStatusSolicitacao) {
		this.desStatusSolicitacao = desStatusSolicitacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datResposta == null) ? 0 : datResposta.hashCode());
		result = prime * result + ((datSolicitacao == null) ? 0 : datSolicitacao.hashCode());
		result = prime * result + ((desStatusSolicitacao == null) ? 0 : desStatusSolicitacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motoristaSolicitado == null) ? 0 : motoristaSolicitado.hashCode());
		result = prime * result + ((motoristaSolicitante == null) ? 0 : motoristaSolicitante.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		SolicitacaoVinculoMotoristaVeiculo other = (SolicitacaoVinculoMotoristaVeiculo) obj;
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
		if (desStatusSolicitacao != other.desStatusSolicitacao)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motoristaSolicitado == null) {
			if (other.motoristaSolicitado != null)
				return false;
		} else if (!motoristaSolicitado.equals(other.motoristaSolicitado))
			return false;
		if (motoristaSolicitante == null) {
			if (other.motoristaSolicitante != null)
				return false;
		} else if (!motoristaSolicitante.equals(other.motoristaSolicitante))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolicitacaoVinculoMotoristaVeiculo=["
						+ "id=" + id 
						+ ", datSolicitacao=" + datSolicitacao 
						+ ", datResposta=" + datResposta 
						+ ", motoristaSolicitante=" + motoristaSolicitante 
						+ ", motoristaSolicitado=" + motoristaSolicitado 
						+ ", veiculo=" + veiculo 
						+ ", desStatusSolicitacao=" 
						+ desStatusSolicitacao 
						+ "]";
	}
	
	
	
}
