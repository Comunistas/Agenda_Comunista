package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.InputVistaDTO;

public interface InputVistaDAO {
	
	public ArrayList<InputVistaDTO> listarInputs(Connection cn,int cod_pro, int cod_vis) throws Exception;
	public ArrayList<InputVistaDTO> listarInputs(Connection cn,int cod_pro) throws Exception;
	public int grabarInput(Connection cn,InputVistaDTO input) throws Exception;
	public int eliminarInput(Connection cn,InputVistaDTO input) throws Exception;

}
