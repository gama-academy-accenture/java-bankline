package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	
	@Column(name = "senha")  
	private String senhaEncriptada;
	private String nome;
	private String cpf;
	
	public Usuario() {}

	public Usuario(Integer id, String login, String senhaEncriptada, String nome, String cpf) {
		super();
		this.id = id;
		this.login = login;
		this.senhaEncriptada = senhaEncriptada;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	
}
