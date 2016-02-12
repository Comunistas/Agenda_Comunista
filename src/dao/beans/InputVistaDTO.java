package dao.beans;

public class InputVistaDTO {
	
	private int cod_pro, cod_vis, cod_input;
	private String nom_input;
	private TipoDatoDTO tipoDato;
	
	public InputVistaDTO(int cod_pro, int cod_vis, int cod_input,
			String nom_input, TipoDatoDTO tipoDato) {
		this.cod_pro = cod_pro;
		this.cod_vis = cod_vis;
		this.cod_input = cod_input;
		this.nom_input = nom_input;
		this.tipoDato = tipoDato;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public int getCod_vis() {
		return cod_vis;
	}

	public void setCod_vis(int cod_vis) {
		this.cod_vis = cod_vis;
	}

	public int getCod_input() {
		return cod_input;
	}

	public void setCod_input(int cod_input) {
		this.cod_input = cod_input;
	}

	public String getNom_input() {
		return nom_input;
	}

	public void setNom_input(String nom_input) {
		this.nom_input = nom_input;
	}

	public TipoDatoDTO getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(TipoDatoDTO tipoDato) {
		this.tipoDato = tipoDato;
	}
	
	
	
	
	
			
}
