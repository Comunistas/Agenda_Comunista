package dao.interfaces;

import java.sql.Connection;
import java.util.HashMap;

import dao.beans.VistaDTO;

public interface VistaDAO {

	public HashMap<Integer, VistaDTO> listarVistas(Connection cn,int cod_pro) throws Exception;
	public int grabarVista(Connection cn,VistaDTO v) throws Exception;
	public int modificarVista(Connection cn,VistaDTO v) throws Exception;
	public int eliminarVista(Connection cn,VistaDTO v) throws Exception;
}
