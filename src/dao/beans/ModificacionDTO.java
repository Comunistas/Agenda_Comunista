package dao.beans;

public class ModificacionDTO {

	private int cod_pro, cod_mod;
	private String cod_cam;
	private int cod_act, atendido;
	private String com_mod;
	
	
	public ModificacionDTO(int cod_pro, int cod_mod, String cod_cam,
			int cod_act, int atendido, String com_mod) {
		this.cod_pro = cod_pro;
		this.cod_mod = cod_mod;
		this.cod_cam = cod_cam;
		this.cod_act = cod_act;
		setAtendido(atendido);
		this.com_mod = com_mod;
	}
	
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	public int getCod_mod() {
		return cod_mod;
	}
	public void setCod_mod(int cod_mod) {
		this.cod_mod = cod_mod;
	}
	public String getCod_cam() {
		return cod_cam;
	}
	public void setCod_cam(String cod_cam) {
		this.cod_cam = cod_cam;
	}
	public int getCod_act() {
		return cod_act;
	}
	public void setCod_act(int cod_act) {
		this.cod_act = cod_act;
	}
	public int getAtendido() {
		return atendido;
	}
	public void setAtendido(int atendido) {
		if(atendido==1||atendido==0)
			this.atendido = atendido;
		else
			this.atendido = 0;
	}
	public String getCom_mod() {
		return com_mod;
	}
	public void setCom_mod(String com_mod) {
		this.com_mod = com_mod;
	}
	

}
