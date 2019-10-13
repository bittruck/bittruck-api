package br.com.indepdevbr.models.enums;

public enum EStatusCarga {
	
	NAO_ALOCADA("NÃO ALOCADA"), 
	ALOCADA("ALOCADA"), 
	RETIRADA("RETIRADA"), 
	EM_VIAGEM("EM VIAGEM"), 
	ENTREGUE("ENTREGUE");
	
	private final String status;
	
	private EStatusCarga(String status) {
		this.status = status;
	}
	
	public String toString() {
		return this.status;
	}
	
}
