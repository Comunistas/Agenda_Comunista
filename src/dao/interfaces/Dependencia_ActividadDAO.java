package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import dao.beans.Dependencia_ActividadDTO;

public interface Dependencia_ActividadDAO {
	
	public HashMap<Integer, ArrayList<Dependencia_ActividadDTO>> listarDependencia_ActividadPorProyecto(Connection cn, int cod_pro);
	public ArrayList<Dependencia_ActividadDTO> listarDependencia_Actividad(Connection cn,int cod_pro, int cod_act_dep) throws Exception;
	public int grabarDependencia_Actividad(Connection cn,Dependencia_ActividadDTO da) throws Exception;
	public int eliminarDependencia_Actividad(Connection cn,Dependencia_ActividadDTO da) throws Exception;
}
