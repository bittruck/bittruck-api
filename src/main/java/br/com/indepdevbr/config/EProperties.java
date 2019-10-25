package br.com.indepdevbr.config;

public enum EProperties {
	
	BITTRUCK_FRONT_END_HOST("BITTRUCK_FRONT_END_HOST"), BITTRUCK_API_HOST("BITTRUCK_API_HOST");

	private final String value;
	
	private EProperties(String prop) {
		this.value = prop;
	}
	
	public String toString() {
		return value;
	}
	
}
