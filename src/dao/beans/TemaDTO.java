package dao.beans;

public class TemaDTO {
	
	
	private static TemaDTO temaDTO = new TemaDTO();
	private String cod_tema, nom_tema;
	private boolean seleccionado;
	
	private TemaDTO(){
	}

	public String getCod_tema() {
		return cod_tema;
	}

	public void setCod_tema(String cod_tema) {
		this.cod_tema = cod_tema;
	}

	public String getNom_tema() {
		return nom_tema;
	}

	public void setNom_tema(String nom_tema) {
		this.nom_tema = nom_tema;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public static TemaDTO getInstance(){
		return temaDTO;
	}
	
	
}
