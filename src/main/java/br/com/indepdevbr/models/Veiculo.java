package br.com.indepdevbr.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.indepdevbr.models.audit.AuditModel;
import br.com.indepdevbr.models.enums.ESimNao;

@Entity
public class Veiculo extends AuditModel {
	
	private static final long serialVersionUID = 92943297865370270L;

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
	private String codPlaca;
	
	@NotNull
	private String codAntt;
	
	@NotNull
	private String tpoAntt;
	
	@NotNull
	private Long numAnoFabricacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ESimNao mcaCompartilhavel;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "marca_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//    @JsonIdentityReference(alwaysAsId=true)
//    @JsonProperty("marca_id")
	private Marca marca;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modelo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//    @JsonIdentityReference(alwaysAsId=true)
//    @JsonProperty("modelo_id")
	private Modelo modelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodPlaca() {
		return codPlaca;
	}

	public void setCodPlaca(String codPlaca) {
		this.codPlaca = codPlaca;
	}

	public String getCodAntt() {
		return codAntt;
	}

	public void setCodAntt(String codAntt) {
		this.codAntt = codAntt;
	}

	public String getTpoAntt() {
		return tpoAntt;
	}

	public void setTpoAntt(String tpoAntt) {
		this.tpoAntt = tpoAntt;
	}

	public Long getNumAnoFabricacao() {
		return numAnoFabricacao;
	}

	public void setNumAnoFabricacao(Long numAnoFabricacao) {
		this.numAnoFabricacao = numAnoFabricacao;
	}

	public ESimNao getMcaCompartilhavel() {
		return mcaCompartilhavel;
	}

	public void setMcaCompartilhavel(ESimNao mcaCompartilhavel) {
		this.mcaCompartilhavel = mcaCompartilhavel;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAntt == null) ? 0 : codAntt.hashCode());
		result = prime * result + ((codPlaca == null) ? 0 : codPlaca.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((mcaCompartilhavel == null) ? 0 : mcaCompartilhavel.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((numAnoFabricacao == null) ? 0 : numAnoFabricacao.hashCode());
		result = prime * result + ((tpoAntt == null) ? 0 : tpoAntt.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (codAntt == null) {
			if (other.codAntt != null)
				return false;
		} else if (!codAntt.equals(other.codAntt))
			return false;
		if (codPlaca == null) {
			if (other.codPlaca != null)
				return false;
		} else if (!codPlaca.equals(other.codPlaca))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (mcaCompartilhavel != other.mcaCompartilhavel)
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (numAnoFabricacao == null) {
			if (other.numAnoFabricacao != null)
				return false;
		} else if (!numAnoFabricacao.equals(other.numAnoFabricacao))
			return false;
		if (tpoAntt == null) {
			if (other.tpoAntt != null)
				return false;
		} else if (!tpoAntt.equals(other.tpoAntt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo=["
					+ "id=" + id 
					+ ", codPlaca=" + codPlaca 
					+ ", codAntt=" + codAntt 
					+ ", tpoAntt=" + tpoAntt
					+ ", numAnoFabricacao=" + numAnoFabricacao 
					+ ", mcaCompartilhavel=" + mcaCompartilhavel 
					+ ", marca=" + marca 
					+ ", modelo=" + modelo 
					+ "]";
	}
	
	

}
