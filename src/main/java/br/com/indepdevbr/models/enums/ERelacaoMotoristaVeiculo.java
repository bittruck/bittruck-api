package br.com.indepdevbr.models.enums;

public enum ERelacaoMotoristaVeiculo {
	
	PROPRIETARIO("PROPRIETARIO"), COMPARTILHADO("COMPARTILHADO");
	
	private final String value;
	
	private ERelacaoMotoristaVeiculo(String in) {
		this.value = in;
	}
	
	public String toString() {
		return this.value;
	}
	
}

