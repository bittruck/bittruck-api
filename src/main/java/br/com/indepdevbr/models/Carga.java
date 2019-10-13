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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.indepdevbr.models.audit.AuditModel;
import br.com.indepdevbr.models.enums.EStatusCarga;

@Entity
public class Carga extends AuditModel {
	
	private static final long serialVersionUID = -6405760267687929802L;

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
    @JoinColumn(name = "endereco_retirada_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("endereco_retirada_id")
	private Endereco enderecoRetirada;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "endereco_entrega_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("endereco_entrega_id")
	private Endereco enderecoEntrega;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "procedimento_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("procedimento_id")
	private Procedimento procedimento;

	@ManyToMany(
			fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "cargas"
    )
	private Set<Viagem> viagens = new HashSet<>();
	
	@NotNull
	private String desCarga;
	
	@NotNull
	private String codReferencia;
	
	@NotNull
	private Long codNotaFiscal;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datRetiradaAgendada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datRetiradaReal;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datEntregaAgendada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datEntregaReal;
	
	@Enumerated(EnumType.STRING)
	private EStatusCarga desStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Endereco getEnderecoRetirada() {
		return enderecoRetirada;
	}

	public void setEnderecoRetirada(Endereco enderecoRetirada) {
		this.enderecoRetirada = enderecoRetirada;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Set<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(Set<Viagem> viagens) {
		this.viagens = viagens;
	}

	public String getDesCarga() {
		return desCarga;
	}

	public void setDesCarga(String desCarga) {
		this.desCarga = desCarga;
	}

	public String getCodReferencia() {
		return codReferencia;
	}

	public void setCodReferencia(String codReferencia) {
		this.codReferencia = codReferencia;
	}

	public Long getCodNotaFiscal() {
		return codNotaFiscal;
	}

	public void setCodNotaFiscal(Long codNotaFiscal) {
		this.codNotaFiscal = codNotaFiscal;
	}

	public Date getDatRetiradaAgendada() {
		return datRetiradaAgendada;
	}

	public void setDatRetiradaAgendada(Date datRetiradaAgendada) {
		this.datRetiradaAgendada = datRetiradaAgendada;
	}

	public Date getDatRetiradaReal() {
		return datRetiradaReal;
	}

	public void setDatRetiradaReal(Date datRetiradaReal) {
		this.datRetiradaReal = datRetiradaReal;
	}

	public Date getDatEntregaAgendada() {
		return datEntregaAgendada;
	}

	public void setDatEntregaAgendada(Date datEntregaAgendada) {
		this.datEntregaAgendada = datEntregaAgendada;
	}

	public Date getDatEntregaReal() {
		return datEntregaReal;
	}

	public void setDatEntregaReal(Date datEntregaReal) {
		this.datEntregaReal = datEntregaReal;
	}

	public EStatusCarga getDesStatus() {
		return desStatus;
	}

	public void setDesStatus(EStatusCarga desStatus) {
		this.desStatus = desStatus;
	}
	
}
