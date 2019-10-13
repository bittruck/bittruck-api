package br.com.indepdevbr.models.enums;

public enum EFaseViagem {
	
	ABERTA("ABERTA"), FECHADA("FECHADA"), ENVIADA("ENVIADA"),
	INICIADA("INICIADA"), FINALIZADA("FINALIZADA");
	
	private final String value;
	
	private EFaseViagem(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
}