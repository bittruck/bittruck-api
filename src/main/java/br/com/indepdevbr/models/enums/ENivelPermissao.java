package br.com.indepdevbr.models.enums;

public enum ENivelPermissao {

	OPERADOR("OPERADOR"), MOTORISTA("MOTORISTA"), ADMIN("ADMIN"), 
	OPERADOR_ADMIN("OPERADOR_ADMIN"), DEFAULT("DEFAULT");

	private final String nivelPermissao;

	private ENivelPermissao(String nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}

	@Override
	public String toString() {
		return this.nivelPermissao;
	}

}
