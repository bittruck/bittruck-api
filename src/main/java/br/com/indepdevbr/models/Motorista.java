package br.com.indepdevbr.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.indepdevbr.models.audit.AuditModel;
import br.com.indepdevbr.models.enums.EDocumento;
import br.com.indepdevbr.models.enums.ESimNao;

@Entity
public class Motorista extends AuditModel {
	
	private static final long serialVersionUID = 345790500355259634L;

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
	private String nomMotorista;
	
	@NotNull
	@Column(unique = true)
	private String codDocumento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EDocumento tpoDocumento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date datNascimento;
	
	@NotNull
	@Column(unique = true)
	private String codCnh;
	
	@NotNull
	@Column(unique = true)
	private String desEmail;
	
	@Enumerated(EnumType.STRING)
	private ESimNao mcaDisponivel = ESimNao.NAO;
	
	@OneToOne(
			fetch = FetchType.LAZY, 
			optional = false
	)
    @JoinColumn(
    		name = "usuario_id", 
    		nullable = false
    )
	@JsonBackReference
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomMotorista() {
		return nomMotorista;
	}

	public void setNomMotorista(String nomMotorista) {
		this.nomMotorista = nomMotorista;
	}

	public String getCodDocumento() {
		return codDocumento;
	}

	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}

	public EDocumento getTpoDocumento() {
		return tpoDocumento;
	}

	public void setTpoDocumento(EDocumento tpoDocumento) {
		this.tpoDocumento = tpoDocumento;
	}

	public Date getDatNascimento() {
		return datNascimento;
	}

	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}

	public String getCodCnh() {
		return codCnh;
	}

	public void setCodCnh(String codCnh) {
		this.codCnh = codCnh;
	}

	public String getDesEmail() {
		return desEmail;
	}

	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}

	public ESimNao getMcaDisponivel() {
		return mcaDisponivel;
	}

	public void setMcaDisponivel(ESimNao mcaDisponivel) {
		this.mcaDisponivel = mcaDisponivel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCnh == null) ? 0 : codCnh.hashCode());
		result = prime * result + ((codDocumento == null) ? 0 : codDocumento.hashCode());
		result = prime * result + ((datNascimento == null) ? 0 : datNascimento.hashCode());
		result = prime * result + ((desEmail == null) ? 0 : desEmail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mcaDisponivel == null) ? 0 : mcaDisponivel.hashCode());
		result = prime * result + ((nomMotorista == null) ? 0 : nomMotorista.hashCode());
		result = prime * result + ((tpoDocumento == null) ? 0 : tpoDocumento.hashCode());
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
		Motorista other = (Motorista) obj;
		if (codCnh == null) {
			if (other.codCnh != null)
				return false;
		} else if (!codCnh.equals(other.codCnh))
			return false;
		if (codDocumento == null) {
			if (other.codDocumento != null)
				return false;
		} else if (!codDocumento.equals(other.codDocumento))
			return false;
		if (datNascimento == null) {
			if (other.datNascimento != null)
				return false;
		} else if (!datNascimento.equals(other.datNascimento))
			return false;
		if (desEmail == null) {
			if (other.desEmail != null)
				return false;
		} else if (!desEmail.equals(other.desEmail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mcaDisponivel != other.mcaDisponivel)
			return false;
		if (nomMotorista == null) {
			if (other.nomMotorista != null)
				return false;
		} else if (!nomMotorista.equals(other.nomMotorista))
			return false;
		if (tpoDocumento != other.tpoDocumento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Motorista=["
					+ "id=" + id 
					+ ", nomMotorista=" + nomMotorista 
					+ ", codDocumento=" + codDocumento
					+ ", tpoDocumento=" + tpoDocumento 
					+ ", datNascimento=" + datNascimento 
					+ ", codCnh=" + codCnh
					+ ", desEmail=" + desEmail 
					+ ", mcaDisponivel=" + mcaDisponivel 
					+ "]";
	}
	
	
	
}
