package dao.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class ProyectoDTO {

	private int cod_pro;
	private String nom_pro, fec_ini_pro, fec_lim_pro, fec_fin_pro, llave;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	public ProyectoDTO(){}
	
	public ProyectoDTO(int cod_pro, String nom_pro, String fec_ini_pro,
			String fec_lim_pro, String fec_fin_pro, String llave) {
		this.cod_pro = cod_pro;
		this.nom_pro = nom_pro;
		setFec_ini_pro(fec_ini_pro);
		setFec_lim_pro(fec_lim_pro);
		setFec_fin_pro(fec_fin_pro);
		this.llave = llave;
	}

	public ProyectoDTO(int cod_pro, String nom_pro, Date fec_ini_pro,
			Date fec_lim_pro, Date fec_fin_pro, String llave) {
		this.cod_pro = cod_pro;
		this.nom_pro = nom_pro;
		setFec_ini_pro(fec_ini_pro);
		setFec_lim_pro(fec_lim_pro);
		setFec_fin_pro(fec_fin_pro);
		this.llave = llave;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public String getNom_pro() {
		return nom_pro;
	}

	public void setNom_pro(String nom_pro) {
		this.nom_pro = nom_pro;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public String getFec_ini_pro() {
		return fec_ini_pro;
	}

	public void setFec_ini_pro(String fec_ini_pro) {
		this.fec_ini_pro = validarFecha(fec_ini_pro);
	}

	public String getFec_lim_pro() {
		return fec_lim_pro;
	}

	public void setFec_lim_pro(String fec_lim_pro) {
		this.fec_lim_pro = validarFecha(fec_lim_pro);
	}

	public String getFec_fin_pro() {

		return fec_fin_pro;
	}

	public void setFec_fin_pro(String fec_fin_pro) {
		this.fec_fin_pro = validarFecha(fec_fin_pro);
	}

	// Metodos de fechas
	public void setFec_ini_pro(Date fec_ini_pro) {
		if (fec_ini_pro == null)
			this.fec_ini_pro = null;
		this.fec_ini_pro = sdf.format(fec_ini_pro);
	}

	public void setFec_lim_pro(Date fec_lim_pro) {
		if (fec_lim_pro == null)
			this.fec_lim_pro = null;
		this.fec_lim_pro = sdf.format(fec_lim_pro);
	}

	public void setFec_fin_pro(Date fec_fin_pro) {
		if (fec_fin_pro == null)
			this.fec_fin_pro = null;
		this.fec_fin_pro = sdf.format(fec_fin_pro);
	}
	
	public String validarFecha(String fecha){
		if(fecha == null || fecha.equals(""))
			return null;
		else if(fecha.equalsIgnoreCase("hoy")) 
			return sdf.format(Calendar.getInstance().getTime());
		else 
			return fecha;
	}
	

	public void generarLlave() {
		StringBuffer text = new StringBuffer();

		int nl = 0;
		int i = 0;

		do {
			if (nl == 0) {
				text.append((char) generarCaracterDeLetra());
			} else {
				text.append(generarNumero());
			}

			nl = (int) (Math.random() * 2 + 0);

			i++;
		} while (i < 50);

		llave = text.toString();
	}

	private int generarCaracterDeLetra() {
		int numero = 0;
		Random r = new Random();

		do {
			numero = r.nextInt(123 - 65) + 65;
		} while (numero > 90 && numero < 97);
		return numero;
	}

	private int generarNumero() {
		return (int) (Math.random() * 9 + 0);
	}
}
