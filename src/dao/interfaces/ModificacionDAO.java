package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.ModificacionDTO;

public interface ModificacionDAO {
	
	public ArrayList<ModificacionDTO> listarModificaciones(Connection con, int cod_pro) throws Exception;
	public int grabarModificacion(Connection con, ModificacionDTO mod) throws Exception;
	public int modificarModificacion(Connection con, ModificacionDTO mod) throws Exception;
	public int eliminarModificacion(Connection con, ModificacionDTO mod) throws Exception;
	
}
