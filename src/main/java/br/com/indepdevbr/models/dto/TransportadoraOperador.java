package br.com.indepdevbr.models.dto;

import java.util.Date;

import br.com.indepdevbr.models.Endereco;
import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.enums.ESimNao;

public class TransportadoraOperador extends Transportadora {

	private static final long serialVersionUID = -363773068396960989L;
	
	private Endereco endereco;
	
	private Operador operador;
	
	public TransportadoraOperador() {}
	
	public TransportadoraOperador(
			Long id, Date criadoEm, Date atualizadoEm,
			String codCnpj, String desEmailContato, 
			String desRazaoSocial, ESimNao mcaAtivo, String numTelefone,
			Endereco endereco,
			Operador operador) {
		this.setId(id);
		this.setCriadoEm(criadoEm);
		this.setAtualizadoEm(atualizadoEm);
		this.setCodCnpj(codCnpj);
		this.setDesEmailContato(desEmailContato);
		this.setDesRazaoSocial(desRazaoSocial);
		this.setNumTelefone(numTelefone);
		this.setMcaAtivo(mcaAtivo);
		this.endereco = endereco;
		this.operador = operador;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
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
		int result = super.hashCode();
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((operador == null) ? 0 : operador.hashCode());
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
		TransportadoraOperador other = (TransportadoraOperador) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (operador == null) {
			if (other.operador != null)
				return false;
		} else if (!operador.equals(other.operador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransportadoraOperador=["					
					+ "id=" + getId()
					+ ", codCnpj=" + getCodCnpj() 
					+ ", desEmailContato=" + getDesEmailContato()
					+ ", desRazaoSocial=" + getDesRazaoSocial() 
					+ ", mcaAtivo=" + getMcaAtivo()
					+ ", numTelefone=" + getNumTelefone() 
					+ ", criadoEm=" + getCriadoEm() 
					+ ", atualizadoEm=" + getAtualizadoEm()
					+ ", endereco=" + endereco 
					+ ", operador=" + operador
					+ "]";
	}
	

}
