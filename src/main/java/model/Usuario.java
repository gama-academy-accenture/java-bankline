package model;

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

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@Column(length = 20)
	private String login;
	
	@Column(name = "senha")  
	private String senhaEncriptada;
	private String nome;
	private String cpf;

	@OneToOne(mappedBy = "numero", cascade = CascadeType.REMOVE)
	@JoinColumn(name = "credito",foreignKey = @ForeignKey(name = "fk_us_credito"))
	private Conta credito;
	@OneToOne(mappedBy = "numero", cascade = CascadeType.REMOVE)
	@JoinColumn(name = "banco",foreignKey = @ForeignKey(name = "fk_us_banco"))
	private Conta banco;
	
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
	
	
}
