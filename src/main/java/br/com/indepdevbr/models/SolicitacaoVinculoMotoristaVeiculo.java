package br.com.indepdevbr.models;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
}
