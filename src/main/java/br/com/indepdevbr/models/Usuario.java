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
	
	@OneToOne(
			fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "usuario"
    )
	@JsonManagedReference
	private Administrador administrador;
	
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

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((administrador == null) ? 0 : administrador.hashCode());
		result = prime * result + ((codLogin == null) ? 0 : codLogin.hashCode());
		result = prime * result + ((desSenha == null) ? 0 : desSenha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mcaAtivo == null) ? 0 : mcaAtivo.hashCode());
		result = prime * result + ((motorista == null) ? 0 : motorista.hashCode());
		result = prime * result + ((operador == null) ? 0 : operador.hashCode());
		result = prime * result + ((tpoPermissao == null) ? 0 : tpoPermissao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (administrador == null) {
			if (other.administrador != null)
				return false;
		} else if (!administrador.equals(other.administrador))
			return false;
		if (codLogin == null) {
			if (other.codLogin != null)
				return false;
		} else if (!codLogin.equals(other.codLogin))
			return false;
		if (desSenha == null) {
			if (other.desSenha != null)
				return false;
		} else if (!desSenha.equals(other.desSenha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mcaAtivo != other.mcaAtivo)
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
		if (tpoPermissao != other.tpoPermissao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario=["
					+ "id=" + id 
					+ ", mcaAtivo=" + mcaAtivo 
					+ ", codLogin=" + codLogin 
					+ ", tpoPermissao=" + tpoPermissao 
					+ (motorista != null ? ", motorista=" + motorista : "") 
					+ (operador != null ? ", operador=" + operador : "")
					+ (administrador != null ? ", administrador=" + administrador : "") 
					+ ",criadoEm=" + getCriadoEm() 
					+ ", atualizadoEm=" + getAtualizadoEm() 
					+ "]";
	}
	
	
}
