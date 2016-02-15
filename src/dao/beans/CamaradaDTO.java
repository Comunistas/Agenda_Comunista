package dao.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CamaradaDTO {

	private String cod_cam, nom_cam, ape_cam, tel_cam, pwd_cam, fec_ult_ing;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public CamaradaDTO(String cod_cam, String nom_cam, String ape_cam,
			String tel_cam, String pwd_cam, String fec_ult_ing) {
		this.cod_cam = cod_cam;
		this.nom_cam = nom_cam;
		this.ape_cam = ape_cam;
		this.tel_cam = tel_cam;
		this.pwd_cam = pwd_cam;
		setFec_ult_ing(fec_ult_ing);
	}
	
	public CamaradaDTO(String cod_cam, String nom_cam, String ape_cam,
			String tel_cam, String pwd_cam, Date fec_ult_ing) {
		this.cod_cam = cod_cam;
		this.nom_cam = nom_cam;
		this.ape_cam = ape_cam;
		this.tel_cam = tel_cam;
		this.pwd_cam = pwd_cam;
		setFec_ult_ing(fec_ult_ing);
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

	public String getFec_ult_ing() {
		return fec_ult_ing;
	}

	public void setFec_ult_ing(String fec_ult_ing) {
		if(fec_ult_ing.equalsIgnoreCase("hoy")){
			this.fec_ult_ing = sdf.format(Calendar.getInstance().getTime());
		}else
			this.fec_ult_ing = fec_ult_ing;
	}
	
	public void setFec_ult_ing(Date fec_ult_ing) {
		this.fec_ult_ing = sdf.format(fec_ult_ing);
	}
	
	
}
