package dao.beans;

public class TipoDatoDTO {

	private int cod_pro, cod_td;
	private String des_td;
	
	public TipoDatoDTO(int cod_pro, int cod_td, String des_td) {
		this.cod_pro = cod_pro;
		this.cod_td = cod_td;
		this.des_td = des_td;
	}
	public int getCod_td() {
		return cod_td;
	}
	public void setCod_td(int cod_td) {
		this.cod_td = cod_td;
	}
	public String getDes_td() {
		return des_td;
	}
	public void setDes_td(String des_td) {
		this.des_td = des_td;
	}
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	
	
	
}
