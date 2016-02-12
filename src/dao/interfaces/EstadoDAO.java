package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.EstadoDTO;

public interface EstadoDAO {
	
	public ArrayList<EstadoDTO> listarEstados(Connection cn) throws Exception;
	public int grabarEstado(Connection cn,EstadoDTO est) throws Exception;
	public int modificarEstado(Connection cn, EstadoDTO est) throws Exception;
}
