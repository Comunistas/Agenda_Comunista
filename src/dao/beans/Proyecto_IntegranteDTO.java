package dao.beans;

public class Proyecto_IntegranteDTO {

	private int cod_pro;
	private String cod_cam;
	private PerfilDTO perfil;
	private int coordinador;
	
	public Proyecto_IntegranteDTO(int cod_pro, String cod_cam, PerfilDTO perfil, int coordinador) {
		this.cod_pro = cod_pro;
		this.cod_cam = cod_cam;
		this.perfil = perfil;
		setCoordinador(coordinador);
	}
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	public String getCod_cam() {
		return cod_cam;
	}
	public void setCod_cam(String cod_cam) {
		this.cod_cam = cod_cam;
	}
	public PerfilDTO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
	public int getCoordinador() {
		return coordinador;
	}
	
	public void setCoordinador(int coordinador) {
		if(coordinador==1||coordinador==0)
			this.coordinador = coordinador;
		else
			this.coordinador = 0;
	}

	
	
}
