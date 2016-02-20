package dao.beans;

public class VistaDTO {
	
	private int cod_pro, cod_vis;
	private String des_vis;
			
	public VistaDTO(int cod_pro, int cod_vis, String des_vis) {
		this.cod_pro = cod_pro;
		this.cod_vis = cod_vis;
		this.des_vis = des_vis;
	}
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	public int getCod_vis() {
		return cod_vis;
	}
	public void setCod_vis(int cod_vis) {
		this.cod_vis = cod_vis;
	}
	public String getDes_vis() {
		return des_vis;
	}
	public void setDes_vis(String des_vis) {
		this.des_vis = des_vis;
	}
	
	
}
