package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.PerfilDTO;

public interface PerfilDAO {
	
	public ArrayList<PerfilDTO> listarPerfiles(Connection cn) throws Exception;
	public int grabarPerfil(Connection cn,PerfilDTO per) throws Exception;
	public int eliminarPerfil(Connection cn,PerfilDTO per) throws Exception;
	
}
