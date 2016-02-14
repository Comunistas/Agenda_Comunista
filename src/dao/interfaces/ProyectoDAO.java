package dao.interfaces;

import java.sql.Connection;
import java.util.TreeMap;

import dao.beans.CamaradaDTO;
import dao.beans.ProyectoDTO;

public interface ProyectoDAO {
	
	public TreeMap<Integer, ProyectoDTO> listarProyectos(Connection cn) throws Exception;
	public TreeMap<Integer, ProyectoDTO> listarProyectos(Connection cn, CamaradaDTO cam) throws Exception;
	public ProyectoDTO obtenerProyectoPorLlave(Connection cn, String llave) throws Exception;
	public ProyectoDTO obtenerProyecto(Connection cn, int cod_pro) throws Exception;
	public int grabarProyecto(Connection cn,ProyectoDTO pro) throws Exception;
	public int modificarProyecto(Connection cn,ProyectoDTO pro) throws Exception;
	public int eliminarProyecto(Connection cn,ProyectoDTO pro) throws Exception;
}
