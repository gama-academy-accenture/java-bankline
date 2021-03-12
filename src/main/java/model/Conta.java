package model;

import java.util.List;
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
import javax.persistence.Table;

import model.enumeracoes.TiposDeConta;

@Entity
@Table(name = "tb_conta")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	private String numero; //composto pelo login do usuario e o tipo da conta
	
	@Enumerated(EnumType.STRING)
	private TiposDeConta tipoDeConta;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")  
	private Usuario usuarioId;     
	
	private Double saldo; //consolidado porque o saldo total vem do balanço entre receitas e despesas  

	@OneToMany(mappedBy = "banco")  
	private List<Lancamento> lancamentos;
	
	public Conta(TiposDeConta tipoDeConta, Usuario usuarioId) {
		this.tipoDeConta = tipoDeConta;
		this.usuarioId = usuarioId; 
	}

	public void addDebito(Lancamento lancamento) {
		lancamento.setBanco(this);   

		//lancamentos.add(lancamento);
	}

	public void addCredito(Lancamento lancamento) {
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
	public Usuario getUsuarioId() {
		return usuarioId;  
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
