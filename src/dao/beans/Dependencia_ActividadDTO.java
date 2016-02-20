package dao.beans;

public class Dependencia_ActividadDTO {

	private int cod_pro, cod_act_dep;
	private ActividadDTO act;

	public Dependencia_ActividadDTO(int cod_pro, int cod_act_dep,
			ActividadDTO act) {
		this.cod_pro = cod_pro;
		this.cod_act_dep = cod_act_dep;
		this.act = act;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public int getCod_act_dep() {
		return cod_act_dep;
	}

	public void setCod_act_dep(int cod_act_dep) {
		this.cod_act_dep = cod_act_dep;
	}

	public ActividadDTO getAct() {
		return act;
	}

	public void setAct(ActividadDTO act) {
		this.act = act;
	}

	
}
