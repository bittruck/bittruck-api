package br.com.indepdevbr.models.enums;

public enum ESimNao {
	SIM("SIM"), NAO("NAO");
	
	private final String value;
	
	private ESimNao(String in) {
		this.value = in;
	}
	
	public String toString() {
		return value;
	}
	
}
