package com.javamos.model.enuns;

public enum TiposDeConta {
	ContaBanco("Conta Banco"),ContaCredito("Conta CrÃ©dito");

	private String tipo;    

	TiposDeConta(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}  
	
	  

}

