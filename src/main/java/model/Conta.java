package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.enumeracoes.TiposDeConta;

@Entity
@Table(name = "tb_conta")
public class Conta {
	@Id
	@Column(length = 20)
	private String numero; //composto pelo login do usuario e o tipo da conta
	
	@Enumerated(EnumType.STRING)
	private TiposDeConta tipoDeConta;
	
	@Column(name = "usuario_id")
	private Integer usuarioId;
	
	/*
	 * @ManyToOne
	 * private Usuario usuarioId;
	 * */
	
	private Double saldo; //consolidado porque o saldo total vem do balanço entre receitas e despesas  

	@OneToMany(mappedBy = "conta", cascade = CascadeType.PERSIST)
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	public Conta(TiposDeConta tipoDeConta, Integer usuarioId) {
		this.tipoDeConta = tipoDeConta;
		this.usuarioId = usuarioId;
	}

	public void addDebito(Lancamento lancamento) {
		lancamento.setPagador(this);

		lancamentos.add(lancamento);
	}

	public void addCredito(Lancamento lancamento) {
		lancamento.setBeneficiario(this);

		lancamentos.add(lancamento);
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
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setItens(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
}
