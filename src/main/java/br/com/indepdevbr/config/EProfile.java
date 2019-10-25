package br.com.indepdevbr.config;

public enum EProfile {
	
	LOCAL("LOCAL"), DEV("DEV");
	
	private final String value;
	
	private EProfile(String profile) {
		this.value = profile;
	}
	
	public String toString() {
		return value;
	}
	
}
