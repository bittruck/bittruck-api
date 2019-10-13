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
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            },
//            mappedBy = "motoristas")
//	private Set<Transportadora> transportadoras = new HashSet<>();
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	
	
}
