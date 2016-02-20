package dao.beans;

public class OutputVistaDTO {
	
	private int cod_pro,cod_vis, cod_output;
	private String nom_output;
	private TipoDatoDTO tipoDato;
	


	public OutputVistaDTO(int cod_pro, int cod_vis, int cod_output,
			String nom_output, TipoDatoDTO tipoDato) {
		this.cod_pro = cod_pro;
		this.cod_vis = cod_vis;
		this.cod_output = cod_output;
		this.nom_output = nom_output;
		this.tipoDato = tipoDato;
	}
	public int getCod_vis() {
		return cod_vis;
	}
	public void setCod_vis(int cod_vis) {
		this.cod_vis = cod_vis;
	}
	public int getCod_output() {
		return cod_output;
	}
	public void setCod_output(int cod_output) {
		this.cod_output = cod_output;
	}
	public String getNom_output() {
		return nom_output;
	}
	public void setNom_output(String nom_output) {
		this.nom_output = nom_output;
	}
	public TipoDatoDTO getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(TipoDatoDTO tipoDato) {
		this.tipoDato = tipoDato;
	}
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	
	
}
