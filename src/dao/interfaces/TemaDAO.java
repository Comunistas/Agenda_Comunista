package dao.interfaces;

import java.sql.Connection;

import dao.beans.TemaDTO;

public interface TemaDAO {
	
	public TemaDTO temaSeleccionado(Connection cn) throws Exception;
	public int modificarTemaSeleccionado(Connection cn) throws Exception;
	
}
