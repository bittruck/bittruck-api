package br.com.indepdevbr.models;

import javax.persistence.Column;
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
public class Transportadora extends AuditModel {

	private static final long serialVersionUID = -6089398433560948862L;


	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO, 
			generator = "native"
	)
	@GenericGenerator(
			name = "native", 
			strategy = "native"
	)
	private Long id;
	
	
	@NotNull
	@Column(unique = true)
	private String codCnpj;
	
	@NotNull
	@Column(unique = true)
	private String desEmailContato;
	
	@NotNull
	private String desRazaoSocial;
	
	@Enumerated(EnumType.STRING)
	private ESimNao mcaAtivo = ESimNao.NAO;
	
	@NotNull
	private String numTelefone;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "endereco_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("endereco_id")
	private Endereco endereco;
			
	public Transportadora() {}
	
	public Transportadora(String desRazaoSocial, String desEmailContato, String codCnpj, String numTelefone, Endereco endereco) {
		this.desRazaoSocial = desRazaoSocial;
		this.desEmailContato = desEmailContato;
		this.codCnpj = codCnpj;
		this.numTelefone = numTelefone;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodCnpj() {
		return codCnpj;
	}

	public void setCodCnpj(String codCnpj) {
		this.codCnpj = codCnpj;
	}

	public String getDesEmailContato() {
		return desEmailContato;
	}

	public void setDesEmailContato(String desEmailContato) {
		this.desEmailContato = desEmailContato;
	}

	public String getDesRazaoSocial() {
		return desRazaoSocial;
	}

	public void setDesRazaoSocial(String desRazaoSocial) {
		this.desRazaoSocial = desRazaoSocial;
	}

	public ESimNao getMcaAtivo() {
		return mcaAtivo;
	}

	public void setMcaAtivo(ESimNao mcaAtivo) {
		this.mcaAtivo = mcaAtivo;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCnpj == null) ? 0 : codCnpj.hashCode());
		result = prime * result + ((desEmailContato == null) ? 0 : desEmailContato.hashCode());
		result = prime * result + ((desRazaoSocial == null) ? 0 : desRazaoSocial.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mcaAtivo == null) ? 0 : mcaAtivo.hashCode());
		result = prime * result + ((numTelefone == null) ? 0 : numTelefone.hashCode());
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
		Transportadora other = (Transportadora) obj;
		if (codCnpj == null) {
			if (other.codCnpj != null)
				return false;
		} else if (!codCnpj.equals(other.codCnpj))
			return false;
		if (desEmailContato == null) {
			if (other.desEmailContato != null)
				return false;
		} else if (!desEmailContato.equals(other.desEmailContato))
			return false;
		if (desRazaoSocial == null) {
			if (other.desRazaoSocial != null)
				return false;
		} else if (!desRazaoSocial.equals(other.desRazaoSocial))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mcaAtivo != other.mcaAtivo)
			return false;
		if (numTelefone == null) {
			if (other.numTelefone != null)
				return false;
		} else if (!numTelefone.equals(other.numTelefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transportadora=["
					+ "id=" + id 
					+ ", codCnpj=" + codCnpj 
					+ ", desEmailContato=" + desEmailContato
					+ ", desRazaoSocial=" + desRazaoSocial 
					+ ", mcaAtivo=" + mcaAtivo 
					+ ", numTelefone=" + numTelefone
					+ ", endereco=" + endereco 
					+ "]";
	}

	

}
