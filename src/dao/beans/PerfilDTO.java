package dao.beans;

public class PerfilDTO {

	private int cod_per;
	private String des_per;
	
	public PerfilDTO(int cod_per, String des_per) {
		this.cod_per = cod_per;
		this.des_per = des_per;
	}
	public int getCod_per() {
		return cod_per;
	}
	public void setCod_per(int cod_per) {
		this.cod_per = cod_per;
	}
	public String getDes_per() {
		return des_per;
	}
	public void setDes_per(String des_per) {
		this.des_per = des_per;
	}
	
	
}
