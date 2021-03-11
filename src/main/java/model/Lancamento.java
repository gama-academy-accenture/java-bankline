package model;

import java.util.Date;

public class Lancamento {
	private Date dataDeReferencia;
	private Date vencimento;
	private Double valor;
	private Integer beneficiario;//conta recebedora ou null, caso não seja uma tranferência nem uma receita
	private Integer pagador;//conta pagadora ou null, caso não seja uma transferência nem uma despesa
	private PlanoDeConta planoDeConta;
	private String descricao;
	private String status;//em aberto, atrasado, liquidado
	
	public Lancamento() {}
	
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Integer beneficiario) {
		this.beneficiario = beneficiario;
	}
	public Integer getPagador() {
		return pagador;
	}
	public void setPagador(Integer pagador) {
		this.pagador = pagador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataDeReferencia() {
		return dataDeReferencia;
	}
	public PlanoDeConta getPlanoDeConta() {
		return planoDeConta;
	}
	
	

}
