package dao.interfaces;

import java.sql.Connection;
import java.util.HashMap;

import dao.beans.CamaradaDTO;

public interface CamaradaDAO {
	
	public HashMap<String, CamaradaDTO> listarCamaradas(Connection cn) throws Exception;
	public int grabarCamarada(Connection cn,CamaradaDTO cam) throws Exception;
	public CamaradaDTO obtenerCamarada(Connection cn, String codigo) throws Exception;
	public int modificarCamarada(Connection cn,CamaradaDTO cam) throws Exception;
	public int eliminarCamarada(Connection cn,CamaradaDTO cam) throws Exception;
	
	
}
