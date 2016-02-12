package dao.beans;

public class CamaradaDTO {

	private String cod_cam, nom_cam, ape_cam, tel_cam, pwd_cam;

	public CamaradaDTO(String cod_cam, String nom_cam, String ape_cam,
			String tel_cam, String pwd_cam) {
		this.cod_cam = cod_cam;
		this.nom_cam = nom_cam;
		this.ape_cam = ape_cam;
		this.tel_cam = tel_cam;
		this.pwd_cam = pwd_cam;
	}

	public String getCod_cam() {
		return cod_cam;
	}

	public void setCod_cam(String cod_cam) {
		this.cod_cam = cod_cam;
	}

	public String getNom_cam() {
		return nom_cam;
	}

	public void setNom_cam(String nom_cam) {
		this.nom_cam = nom_cam;
	}

	public String getApe_cam() {
		return ape_cam;
	}

	public void setApe_cam(String ape_cam) {
		this.ape_cam = ape_cam;
	}

	public String getTel_cam() {
		return tel_cam;
	}

	public void setTel_cam(String tel_cam) {
		this.tel_cam = tel_cam;
	}

	public String getPwd_cam() {
		return pwd_cam;
	}

	public void setPwd_cam(String pwd_cam) {
		this.pwd_cam = pwd_cam;
	}
	
	
}
