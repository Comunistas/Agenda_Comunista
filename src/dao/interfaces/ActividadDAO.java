package dao.interfaces;

import java.sql.Connection;
import java.util.HashMap;

import dao.beans.ActividadDTO;

public interface ActividadDAO {
	
	//primer integer de proyecto, segundo de actividad
	public HashMap<Integer, ActividadDTO> listarActividades(Connection cn,int cod_pro) throws Exception;
	public int grabarActividad(Connection cn, ActividadDTO act) throws Exception;
	public int modificarActividad(Connection cn, ActividadDTO act) throws Exception;
	public int eliminarActividad(Connection cn, ActividadDTO act) throws Exception;
	
}
