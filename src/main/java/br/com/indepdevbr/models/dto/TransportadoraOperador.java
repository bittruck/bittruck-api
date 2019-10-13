package br.com.indepdevbr.models.dto;

import br.com.indepdevbr.models.Endereco;
import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.Transportadora;

public class TransportadoraOperador extends Transportadora {

	private static final long serialVersionUID = -363773068396960989L;
	
	private Endereco endereco;
	
	private Operador operador;
	
	public TransportadoraOperador() {}

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
