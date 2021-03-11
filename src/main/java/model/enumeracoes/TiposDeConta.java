package model.enumeracoes;

public enum TiposDeConta {
	ContaBanco("Conta Banco"),ContaCredito("Conta Crédito");

	private String tipo;    

	TiposDeConta(String tipo) {
		this.tipo = tipo;
	}  

}
