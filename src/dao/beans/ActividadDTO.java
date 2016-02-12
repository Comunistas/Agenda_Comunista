package dao.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ActividadDTO {

	private int cod_pro, cod_act;
	private String cod_com, des_act, fec_ini_act, fec_fin_act, tiempo_est_act;
	private EstadoDTO est;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	public ActividadDTO(int cod_pro, int cod_act, String cod_com,
			String des_act, String fec_ini_act, String fec_fin_act,
			String tiempo_est_act, EstadoDTO est) {
		this.cod_pro = cod_pro;
		this.cod_act = cod_act;
		this.cod_com = cod_com;
		this.des_act = des_act;
		setFec_ini_act(fec_ini_act);
		setFec_fin_act(fec_fin_act);
		this.tiempo_est_act = tiempo_est_act;
		this.est = est;
	}

	public ActividadDTO(int cod_pro, int cod_act, String cod_com,
			String des_act, Date fec_ini_act, Date fec_fin_act,
			String tiempo_est_act, EstadoDTO est) {
		this.cod_pro = cod_pro;
		this.cod_act = cod_act;
		this.cod_com = cod_com;
		this.des_act = des_act;
		setFec_ini_act(fec_ini_act);
		setFec_fin_act(fec_fin_act);
		this.tiempo_est_act = tiempo_est_act;
		this.est = est;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public int getCod_act() {
		return cod_act;
	}

	public void setCod_act(int cod_act) {
		this.cod_act = cod_act;
	}

	public String getCod_com() {
		return cod_com;
	}

	public void setCod_com(String cod_com) {
		this.cod_com = cod_com;
	}

	public String getDes_act() {
		return des_act;
	}

	public void setDes_act(String des_act) {
		this.des_act = des_act;
	}

	public String getFec_ini_act() {
		return fec_ini_act;
	}

	public void setFec_ini_act(String fec_ini_act) {
		if (fec_ini_act.equalsIgnoreCase("hoy")) {
			this.fec_ini_act = sdf.format(Calendar.getInstance().getTime());
		} else
			this.fec_ini_act = fec_ini_act;
	}

	public String getFec_fin_act() {
		return fec_fin_act;
	}

	public void setFec_fin_act(String fec_fin_act) {
		if (fec_fin_act.equalsIgnoreCase("hoy")) {
			this.fec_fin_act = sdf.format(Calendar.getInstance().getTime());
		} else
			this.fec_fin_act = fec_fin_act;
	}

	public String getTiempo_est_act() {
		return tiempo_est_act;
	}

	public void setTiempo_est_act(String tiempo_est_act) {
		this.tiempo_est_act = tiempo_est_act;
	}

	public EstadoDTO getEst() {
		return est;
	}

	public void setEst(EstadoDTO est) {
		this.est = est;
	}

	// Metodos de fechas

	public void setFec_ini_act(Date fec_ini_act) {
		this.fec_ini_act = sdf.format(fec_ini_act);
	}

	public void setFec_fin_act(Date fec_fin_act) {
		this.fec_fin_act = sdf.format(fec_fin_act);
	}

}
