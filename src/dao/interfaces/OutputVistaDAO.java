package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.OutputVistaDTO;

public interface OutputVistaDAO {
	public ArrayList<OutputVistaDTO> listarOutputs(Connection cn,int cod_pro, int cod_vis) throws Exception;
	public ArrayList<OutputVistaDTO> listarOutputs(Connection cn,int cod_pro) throws Exception;
	public int grabarOutput(Connection cn,OutputVistaDTO output) throws Exception;
	public int eliminarOutput(Connection cn,OutputVistaDTO output) throws Exception;
}
