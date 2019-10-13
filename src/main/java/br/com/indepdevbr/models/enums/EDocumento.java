package br.com.indepdevbr.models.enums;

public enum EDocumento {
	
	CPF("CPF"), RG("RG");
	
	private final String value;
	
	private EDocumento(String in) {
		this.value = in;
	}
	
	public String toString() {
		return this.value;
	}
}

