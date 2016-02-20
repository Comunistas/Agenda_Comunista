package dao.beans;

public class ComentarioDTO {

	private int cod_pro, cod_com;
	
	private String des_com;

	public ComentarioDTO(int cod_pro, int cod_com, String des_com) {
		this.cod_pro = cod_pro;
		this.cod_com = cod_com;
		this.des_com = des_com;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public int getCod_com() {
		return cod_com;
	}

	public void setCod_com(int cod_com) {
		this.cod_com = cod_com;
	}

	public String getDes_com() {
		return des_com;
	}

	public void setDes_com(String des_com) {
		this.des_com = des_com;
	}
	
	
}
