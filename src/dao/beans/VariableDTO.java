package dao.beans;

public class VariableDTO {

	private int cod_pro, cod_var;
	private String nom_var;
	private TipoDatoDTO tipoDato;
	

	
	public VariableDTO(int cod_pro, int cod_var, String nom_var,
			TipoDatoDTO tipoDato) {
		this.cod_pro = cod_pro;
		this.cod_var = cod_var;
		this.nom_var = nom_var;
		this.tipoDato = tipoDato;
	}
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	public int getCod_var() {
		return cod_var;
	}
	public void setCod_var(int cod_var) {
		this.cod_var = cod_var;
	}
	public String getNom_var() {
		return nom_var;
	}
	public void setNom_var(String nom_var) {
		this.nom_var = nom_var;
	}
	public TipoDatoDTO getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(TipoDatoDTO tipoDato) {
		this.tipoDato = tipoDato;
	}


	

	

	
}
