package dao.beans;

public class EstandarDTO {
	
	private int cod_pro, cod_est;
	private String des_est;
	
	public EstandarDTO(int cod_pro, int cod_est, String des_est) {
		this.cod_pro = cod_pro;
		this.cod_est = cod_est;
		this.des_est = des_est;
	}
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	public int getCod_est() {
		return cod_est;
	}
	public void setCod_est(int cod_est) {
		this.cod_est = cod_est;
	}
	public String getDes_est() {
		return des_est;
	}
	public void setDes_est(String des_est) {
		this.des_est = des_est;
	}
	
	
}
