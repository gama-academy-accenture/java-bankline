package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_plano_conta")
public class PlanoDeConta {
	@Id
	@Column(length = 20)
	private String tipo; // R / D / TU / TC
	@ManyToOne
	@JoinColumn(name = "usuario",foreignKey = @ForeignKey(name = "fk_pc_usuario"))
	private Usuario usuario;
	private boolean ehPlanoPadrao;

	@OneToMany(mappedBy = "plano_conta", cascade = CascadeType.PERSIST)
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	public PlanoDeConta(Usuario usuario, String tipo) {
		this.usuario = usuario;
		this.tipo = tipo;
	}

	public void add(Lancamento lancamento) {
		lancamento.setPlanoDeConta(this);

		lancamentos.add(lancamento);
	}

	public String getTipo() {
		return tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isEhPlanoPadrao() {
		return ehPlanoPadrao;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setItens(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void setPlanoPadrao(boolean ehPlanoPadrao) {
		this.ehPlanoPadrao = ehPlanoPadrao;
	}
	
	
}
