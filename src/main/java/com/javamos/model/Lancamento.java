package com.javamos.model;

import java.util.Date;

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

import com.sun.istack.NotNull;

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

	@OneToOne
	@NotNull
	//@JoinColumn(name = "conta_destino_id")
	private Conta contaDestinatario;//conta recebedora ou null, caso nÃ£o seja uma tranferÃªncia nem uma receita

	@OneToOne
	@NotNull
	//@JoinColumn(name = "conta_origem_id")  
	private Conta contaOrigem;//conta pagadora ou null, caso nÃ£o seja uma transferÃªncia nem uma despesa
	
	@ManyToOne
	@JoinColumn(name = "plano_conta",foreignKey = @ForeignKey(name = "fk_lc_plano_conta"))
	private PlanoDeConta planoDeConta;
	
	private String descricao;
	
	@Column(length = 20)
	private String status;//em aberto, atrasado, liquidado
	
	public Lancamento() {}
	
	public Lancamento(Integer id) {
		this.id = id;
	}
	
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
	
	public Conta getContaDestinatario() {
		return contaDestinatario;
	}

	public void setContaDestinatario(Conta contaDestinatario) {
		this.contaDestinatario = contaDestinatario;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDataDeReferencia(Date dataDeReferencia) {
		this.dataDeReferencia = dataDeReferencia;
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

