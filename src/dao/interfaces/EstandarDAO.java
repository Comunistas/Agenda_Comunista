package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.EstandarDTO;

public interface EstandarDAO {
	
	public ArrayList<EstandarDTO> listarEstandares(Connection cn,int cod_pro) throws Exception;
	public int grabarEstandar(Connection cn,EstandarDTO est) throws Exception;
	public int eliminarEstandar(Connection cn,EstandarDTO est) throws Exception;

}
