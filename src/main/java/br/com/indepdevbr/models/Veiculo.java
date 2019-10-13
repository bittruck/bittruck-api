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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "marca_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("marca_id")
	private Marca marca;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modelo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("modelo_id")
	private Modelo modelo;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

}
