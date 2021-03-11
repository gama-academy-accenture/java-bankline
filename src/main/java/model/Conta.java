package model;

import model.enumeracoes.TiposDeConta;

public class Conta {
	private TiposDeConta tipoDeConta;
	private String numero; //composto pelo login do usuario e o tipo da conta
	private Integer usuarioId;
	private Double saldoConsolidado; //consolidado porque o saldo total vem do balanço entre receitas e despesas  
	
	public Conta(TiposDeConta tipoDeConta, Integer usuarioId) {
		this.tipoDeConta = tipoDeConta;
		this.usuarioId = usuarioId;
	}
	
	public Double getSaldoConsolidado() {
		return saldoConsolidado;
	}
	public void setSaldoConsolidado(Double saldoConsolidado) {
		this.saldoConsolidado = saldoConsolidado;
	}
	public TiposDeConta getTipoDeConta() {
		return tipoDeConta;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	

}
