package br.com.indepdevbr.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

@Entity
public class VinculoMotoristaVeiculo extends AuditModel {
	
	private static final long serialVersionUID = -7787927561312648834L;

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
    @JoinColumn(name = "motorista_proprietario_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("motorista_proprietario_id")
	private Motorista motoristaPropietario;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "motorista_usuario_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("motorista_usuario_id")
	private Motorista motoristaUsuario;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("veiculo_id")
	private Veiculo veiculo;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "vinculoMotoristaVeiculos")
	private Set<SolicitacaoVinculoMotoristaVeiculo> solicitacaoVinculoMotoristaVeiculos = new HashSet<>();

	
	public VinculoMotoristaVeiculo() {}
	
	public VinculoMotoristaVeiculo(Motorista motoristaProprietario, Motorista motoristaUsuario, Veiculo veiculo) {
		this.motoristaPropietario = motoristaProprietario;
		this.motoristaUsuario = motoristaUsuario;
		this.veiculo = veiculo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Motorista getMotoristaPropietario() {
		return motoristaPropietario;
	}

	public void setMotoristaPropietario(Motorista motoristaPropietario) {
		this.motoristaPropietario = motoristaPropietario;
	}

	public Motorista getMotoristaUsuario() {
		return motoristaUsuario;
	}

	public void setMotoristaUsuario(Motorista motoristaUsuario) {
		this.motoristaUsuario = motoristaUsuario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Set<SolicitacaoVinculoMotoristaVeiculo> getSolicitacaoVinculoMotoristaVeiculos() {
		return solicitacaoVinculoMotoristaVeiculos;
	}

	public void setSolicitacaoVinculoMotoristaVeiculos(
			Set<SolicitacaoVinculoMotoristaVeiculo> solicitacaoVinculoMotoristaVeiculos) {
		this.solicitacaoVinculoMotoristaVeiculos = solicitacaoVinculoMotoristaVeiculos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motoristaPropietario == null) ? 0 : motoristaPropietario.hashCode());
		result = prime * result + ((motoristaUsuario == null) ? 0 : motoristaUsuario.hashCode());
		result = prime * result
				+ ((solicitacaoVinculoMotoristaVeiculos == null) ? 0 : solicitacaoVinculoMotoristaVeiculos.hashCode());
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
		VinculoMotoristaVeiculo other = (VinculoMotoristaVeiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motoristaPropietario == null) {
			if (other.motoristaPropietario != null)
				return false;
		} else if (!motoristaPropietario.equals(other.motoristaPropietario))
			return false;
		if (motoristaUsuario == null) {
			if (other.motoristaUsuario != null)
				return false;
		} else if (!motoristaUsuario.equals(other.motoristaUsuario))
			return false;
		if (solicitacaoVinculoMotoristaVeiculos == null) {
			if (other.solicitacaoVinculoMotoristaVeiculos != null)
				return false;
		} else if (!solicitacaoVinculoMotoristaVeiculos.equals(other.solicitacaoVinculoMotoristaVeiculos))
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
		return "VinculoMotoristaVeiculo=["
						+ "id=" + id 
						+ ", motoristaPropietario=" + motoristaPropietario
						+ ", motoristaUsuario=" + motoristaUsuario 
						+ ", veiculo=" + veiculo
						+ ", solicitacaoVinculoMotoristaVeiculos=" + solicitacaoVinculoMotoristaVeiculos 
						+ "]";
	}
		
}
