package dao.beans;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CamaradaDTO {

	private String cod_cam, nom_cam, ape_cam, tel_cam, pwd_cam, fec_ult_ing;
	private boolean pwdEncriptado;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	public CamaradaDTO(String cod_cam, String nom_cam, String ape_cam,
			String tel_cam, String pwd_cam, String fec_ult_ing, boolean encriptado) {
		this.cod_cam = cod_cam;
		this.nom_cam = nom_cam;
		this.ape_cam = ape_cam;
		this.tel_cam = tel_cam;
		this.pwd_cam = pwd_cam;
		setFec_ult_ing(fec_ult_ing);
		pwdEncriptado = encriptado;
	}

	public CamaradaDTO(String cod_cam, String nom_cam, String ape_cam,
			String tel_cam, String pwd_cam, Date fec_ult_ing, boolean encriptado) {
		this.cod_cam = cod_cam;
		this.nom_cam = nom_cam;
		this.ape_cam = ape_cam;
		this.tel_cam = tel_cam;
		this.pwd_cam = pwd_cam;
		setFec_ult_ing(fec_ult_ing);
		pwdEncriptado = encriptado;
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
		if (fec_ult_ing.equalsIgnoreCase("hoy")) {
			this.fec_ult_ing = sdf.format(Calendar.getInstance().getTime());
		} else
			this.fec_ult_ing = fec_ult_ing;
	}

	public void setFec_ult_ing(Date fec_ult_ing) {
		this.fec_ult_ing = sdf.format(fec_ult_ing);
	}
	
	
	
	//Encriptamiento de contraseña

	public boolean isPwdEncriptado() {
		return pwdEncriptado;
	}

	public void setPwdEncriptado(boolean pwdEncriptado) {
		this.pwdEncriptado = pwdEncriptado;
	}



	public static final String DEFAULT_ENCODING = "UTF-8";
	static BASE64Encoder enc = new BASE64Encoder();
	static BASE64Decoder dec = new BASE64Decoder();

	private static String base64encode(String text) {
		try {
			String rez = enc.encode(text.getBytes(DEFAULT_ENCODING));
			return rez;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}// base64encode

	private static String base64decode(String text) {

		try {
			return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
		} catch (IOException e) {
			return null;
		}

	}// base64decode

	private static String xorMessage(String message, String key) {
		try {
			if (message == null || key == null)
				return null;

			char[] keys = key.toCharArray();
			char[] mesg = message.toCharArray();

			int ml = mesg.length;
			int kl = keys.length;
			char[] newmsg = new char[ml];

			for (int i = 0; i < ml; i++) {
				newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
			}// for i
			mesg = null;
			keys = null;
			return new String(newmsg);
		} catch (Exception e) {
			return null;
		}
	}// xorMessage
	
	public void encriptarPwd(){
		
		pwd_cam = base64encode(xorMessage(pwd_cam, "MICULO"));
		setPwdEncriptado(true);
		
	}
	
	public void desencriptarPwd(){
		
		pwd_cam = base64decode(xorMessage(pwd_cam, "MICULO"));
		setPwdEncriptado(false);

		
	}

}
