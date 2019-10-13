package br.com.indepdevbr.models.enums;

public enum EStatusSolicitacao {
	
	SOLICITADA("SOLICITADA"), PENDENTE("PENDENTE"),
	APROVADA("APROVADA"), REPROVADA("REPROVADA");
	
	private final String solicitacao;
	
	private EStatusSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	@Override
	public String toString() {
		return this.solicitacao;
	}
	
}
