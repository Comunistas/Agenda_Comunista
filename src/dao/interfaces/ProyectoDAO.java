package dao.interfaces;

import java.sql.Connection;
import java.util.TreeMap;

import dao.beans.ProyectoDTO;

public interface ProyectoDAO {
	
	public TreeMap<Integer, ProyectoDTO> listarProyectos(Connection cn) throws Exception;
	public int grabarProyecto(Connection cn,ProyectoDTO pro) throws Exception;
	public int modificarProyecto(Connection cn,ProyectoDTO pro) throws Exception;
	public int eliminarProyecto(Connection cn,ProyectoDTO pro) throws Exception;
}
