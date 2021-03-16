package com.javamos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, length = 20)  
	@NotNull
	//@Size(min = 3, max = 20)
	private String login;
	
	@Column(name = "senha")  
	@NotNull
	private String senhaEncriptada;
	
	@NotNull
	private String nome;
	
	@Column(unique = true, length = 11)  
	//@CPF(message = "CPF InvÃ¡lido")  
	private String cpf;

	/*
	@OneToOne(mappedBy = "numero", cascade = CascadeType.REMOVE)
	@JoinColumn(name = "credito",foreignKey = @ForeignKey(name = "fk_us_credito"))
	private Conta credito;
	
	@OneToOne(mappedBy = "numero", cascade = CascadeType.PERSIST)
	@JoinColumn(name = "banco",foreignKey = @ForeignKey(name = "fk_us_banco"))
	private Conta banco;
	*/
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	private List<Conta> contas = new ArrayList<Conta>(); 
	  
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)  
	private List<PlanoDeConta> planosConta = new ArrayList<PlanoDeConta>();
	
	public Usuario() {}

	public Usuario(String login, String senhaEncriptada, String nome, String cpf) {
		super();
		this.login = login;
		this.senhaEncriptada = senhaEncriptada;
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenhaEncriptada() {
		return senhaEncriptada;
	}

	public void setSenhaEncriptada(String senhaEncriptada) {
		this.senhaEncriptada = senhaEncriptada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public void setPlanosConta(List<PlanoDeConta> planoConta) {
		this.planosConta = planoConta;
	}
	
	public List<PlanoDeConta> getPlanosConta() {
		return planosConta;
	}
}

