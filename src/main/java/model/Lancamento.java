package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeReferencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date vencimento;
	
	@Column(precision = 2)
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "beneficiario",foreignKey = @ForeignKey(name = "fk_lc_beneficiario"))
	private Conta beneficiario;//conta recebedora ou null, caso não seja uma tranferência nem uma receita
	@ManyToOne
	@JoinColumn(name = "pagador",foreignKey = @ForeignKey(name = "fk_lc_pagador"))
	private Conta pagador;//conta pagadora ou null, caso não seja uma transferência nem uma despesa
	@ManyToOne
	@JoinColumn(name = "plano_conta",foreignKey = @ForeignKey(name = "fk_lc_plano_conta"))
	private PlanoDeConta planoDeConta;
	private String descricao;
	@Column(length = 20)
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
	public Conta getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Conta conta) {
		this.beneficiario = conta;
	}
	public Conta getPagador() {
		return pagador;
	}
	public void setPagador(Conta conta) {
		this.pagador = conta;
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

	public void setPlanoDeConta(PlanoDeConta planoDeConta) {
		this.planoDeConta = planoDeConta;
	}
	
	

}
