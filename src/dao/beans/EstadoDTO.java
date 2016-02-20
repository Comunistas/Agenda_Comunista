package dao.beans;

public class EstadoDTO {

	private int cod_est;
	private String des_est;
	
	public EstadoDTO(int cod_est, String des_est) {
		this.cod_est = cod_est;
		this.des_est = des_est;
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
