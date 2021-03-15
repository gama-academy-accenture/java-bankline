package com.javamos.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.javamos.model.enuns.TipoMovimento;

@Entity
@Table(name = "tb_plano_conta")
public class PlanoDeConta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimento tipo; // R / D / TU / TC
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")  
	private Usuario usuario;  
	
	private boolean ehPlanoPadrao;

	//@OneToMany(mappedBy = "plano_conta", cascade = CascadeType.PERSIST)
	//private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	public PlanoDeConta(Usuario usuario, TipoMovimento tipo) {
		this.usuario = usuario;
		this.tipo = tipo;
	}

	public void add(Lancamento lancamento) {
		lancamento.setPlanoDeConta(this);

		//lancamentos.add(lancamento);
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public Usuario getUsuarioId() {
		return usuario;
	}

	public boolean isEhPlanoPadrao() {
		return ehPlanoPadrao;
	}

	public void setPlanoPadrao(boolean ehPlanoPadrao) {
		this.ehPlanoPadrao = ehPlanoPadrao;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
}

