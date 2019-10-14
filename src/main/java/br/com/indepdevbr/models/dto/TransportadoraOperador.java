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

}
