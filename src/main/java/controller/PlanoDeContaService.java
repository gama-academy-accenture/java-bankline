package controller;

import model.PlanoDeConta;

public class PlanoDeContaService {
	
	public PlanoDeContaService() {}
	
	public PlanoDeConta setTipo(PlanoDeConta plano) {
		if(plano != null){
			switch (plano.getTipo()) {
			case "R":
				plano.setPlanoPadrao(true);
				break;
			case "D":
				plano.setPlanoPadrao(true);
				break;
			case "TC":
				plano.setPlanoPadrao(true);
				break;
			case "TU":
				plano.setPlanoPadrao(true);
				break;
			default:
				plano.setPlanoPadrao(false);
			}
		}
		return plano;
	}
}
