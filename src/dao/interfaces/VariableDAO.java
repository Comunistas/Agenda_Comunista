package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.VariableDTO;

public interface VariableDAO {
	
	public ArrayList<VariableDTO> listarVariables(Connection cn,int cod_pro) throws Exception;
	public int grabarVariable(Connection cn,VariableDTO v) throws Exception;
	public int eliminarVariable(Connection cn,VariableDTO v) throws Exception;
	
}
