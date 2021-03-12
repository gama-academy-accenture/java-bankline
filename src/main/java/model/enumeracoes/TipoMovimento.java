package model.enumeracoes;

public enum TipoMovimento {
	R("Receita"),
	D("Despesas"),
	TC("Transferencia entre Contas"),
	TU("Transferencia entre Usuários");
	
	private String tipoMovimento;     

	TipoMovimento(String tipoMovimento) {
		this.setTipoMovimento(tipoMovimento);    
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}  
}
