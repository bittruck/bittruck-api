package br.com.indepdevbr.models;

import java.math.BigDecimal;
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
import br.com.indepdevbr.models.enums.EFaseViagem;

@Entity
public class Viagem extends AuditModel {
	
	private static final long serialVersionUID = -4894541678257479688L;

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
	private Date datInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datFim;
	
	private BigDecimal valViagem;
	
	@Enumerated(EnumType.STRING)
	private EFaseViagem tpoFaseViagem;
	
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
			name = "viagem_carga", 
			joinColumns = {
					@JoinColumn(name = "viagem_id") 
			}, 
			inverseJoinColumns = { 
					@JoinColumn(name = "carga_id")
			}
	)
	private Set<Carga> cargas = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatInicio() {
		return datInicio;
	}

	public void setDatInicio(Date datInicio) {
		this.datInicio = datInicio;
	}

	public Date getDatFim() {
		return datFim;
	}

	public void setDatFim(Date datFim) {
		this.datFim = datFim;
	}

	public BigDecimal getValViagem() {
		return valViagem;
	}

	public void setValViagem(BigDecimal valViagem) {
		this.valViagem = valViagem;
	}

	public EFaseViagem getTpoFaseViagem() {
		return tpoFaseViagem;
	}

	public void setTpoFaseViagem(EFaseViagem tpoFaseViagem) {
		this.tpoFaseViagem = tpoFaseViagem;
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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Set<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(Set<Carga> cargas) {
		this.cargas = cargas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargas == null) ? 0 : cargas.hashCode());
		result = prime * result + ((datFim == null) ? 0 : datFim.hashCode());
		result = prime * result + ((datInicio == null) ? 0 : datInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motorista == null) ? 0 : motorista.hashCode());
		result = prime * result + ((operador == null) ? 0 : operador.hashCode());
		result = prime * result + ((tpoFaseViagem == null) ? 0 : tpoFaseViagem.hashCode());
		result = prime * result + ((transportadora == null) ? 0 : transportadora.hashCode());
		result = prime * result + ((valViagem == null) ? 0 : valViagem.hashCode());
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
		Viagem other = (Viagem) obj;
		if (cargas == null) {
			if (other.cargas != null)
				return false;
		} else if (!cargas.equals(other.cargas))
			return false;
		if (datFim == null) {
			if (other.datFim != null)
				return false;
		} else if (!datFim.equals(other.datFim))
			return false;
		if (datInicio == null) {
			if (other.datInicio != null)
				return false;
		} else if (!datInicio.equals(other.datInicio))
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
		if (tpoFaseViagem != other.tpoFaseViagem)
			return false;
		if (transportadora == null) {
			if (other.transportadora != null)
				return false;
		} else if (!transportadora.equals(other.transportadora))
			return false;
		if (valViagem == null) {
			if (other.valViagem != null)
				return false;
		} else if (!valViagem.equals(other.valViagem))
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
		return "Viagem=["
						+ "id=" + id 
						+ ", datInicio=" + datInicio 
						+ ", datFim=" + datFim 
						+ ", valViagem=" + valViagem
						+ ", tpoFaseViagem=" + tpoFaseViagem 
						+ ", transportadora=" + transportadora 
						+ ", operador=" + operador
						+ ", motorista=" + motorista 
						+ ", veiculo=" + veiculo 
						+ ", cargas=" + cargas 
						+ "]";
	}
	
	
		
}
