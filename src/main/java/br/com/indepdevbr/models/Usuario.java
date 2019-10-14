package br.com.indepdevbr.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.indepdevbr.models.audit.AuditModel;
import br.com.indepdevbr.models.enums.ENivelPermissao;
import br.com.indepdevbr.models.enums.ESimNao;

@Entity
public class Usuario extends AuditModel {

	private static final long serialVersionUID = 6326335733423269521L;

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
            cascade =  CascadeType.ALL,
            mappedBy = "usuario"
    )
	@JsonManagedReference
	private Motorista motorista;
	
	@OneToOne(
			fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "usuario"
    )
	@JsonManagedReference
	private Operador operador;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private ESimNao mcaAtivo = ESimNao.NAO;
	
	@NotNull
	@Column(unique = true)
	private String codLogin;
	
	@NotNull
	private String desSenha;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private ENivelPermissao tpoPermissao = ENivelPermissao.DEFAULT;

	
	public Usuario() {}
	
	public Usuario(String codLogin, String desSenha, ESimNao mcaAtivo, ENivelPermissao tpoPermissao) {
		this.codLogin = codLogin;
		this.desSenha = desSenha;
		this.mcaAtivo = mcaAtivo;
		this.tpoPermissao = tpoPermissao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public ESimNao getMcaAtivo() {
		return mcaAtivo;
	}

	public void setMcaAtivo(ESimNao mcaAtivo) {
		this.mcaAtivo = mcaAtivo;
	}

	public String getCodLogin() {
		return codLogin;
	}

	public void setCodLogin(String codLogin) {
		this.codLogin = codLogin;
	}

	public String getDesSenha() {
		return desSenha;
	}

	public void setDesSenha(String desSenha) {
		this.desSenha = desSenha;
	}

	public ENivelPermissao getTpoPermissao() {
		return tpoPermissao;
	}

	public void setTpoPermissao(ENivelPermissao tpoPermissao) {
		this.tpoPermissao = tpoPermissao;
	}
	
}
