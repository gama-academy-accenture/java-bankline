package com.javamos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.javamos.model.enuns.TiposDeConta;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_conta")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, length = 50)
	@NotNull
	private String numero; //composto pelo login do usuario e o tipo da conta
	
	@Enumerated(EnumType.STRING)
	private TiposDeConta tipoDeConta;  
	
	@OneToOne
	@NotNull
	//@JoinColumn(name = "usuario_id")  
	private Usuario usuario;     
	
	private Double saldo; //consolidado porque o saldo total vem do balanÃ§o entre receitas e despesas  

	@OneToMany(mappedBy = "contaOrigem", cascade = CascadeType.REMOVE)  
	private List<Lancamento> lancamentosEviados = new ArrayList<Lancamento>();

	@OneToMany(mappedBy = "contaDestinatario", cascade = CascadeType.REMOVE)  
	private List<Lancamento> lancamentosRecebidos = new ArrayList<Lancamento>();
	
	public Conta(TiposDeConta tipoDeConta, Usuario usuario) {
		this.tipoDeConta = tipoDeConta;
		this.usuario = usuario; 
	}

	public void addDebito(Lancamento lancamento) {
		lancamento.setContaOrigem(this);   
		lancamentosEviados.add(lancamento);

		//lancamentos.add(lancamento);
	}

	public void addCredito(Lancamento lancamento) {
		lancamento.setContaDestinatario(this);   
		lancamentosRecebidos.add(lancamento);
		//lancamento.setBeneficiario(this);

		//lancamentos.add(lancamento);
	}
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldoConsolidado) {
		this.saldo = saldoConsolidado;
	}
	public TiposDeConta getTipoDeConta() {
		return tipoDeConta;
	}
	public Usuario getUsuario() {
		return usuario;  
	}

	/*
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setItens(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	*/
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}

