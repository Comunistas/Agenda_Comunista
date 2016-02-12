package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.Proyecto_IntegranteDTO;

public interface Proyecto_IntegranteDAO {

	public ArrayList<Proyecto_IntegranteDTO> listarIntegrantes(Connection cn,int cod_pro) throws Exception;
	public int grabarIntegrante(Connection cn,Proyecto_IntegranteDTO pi) throws Exception;
	public int eliminarIntegrante(Connection cn,Proyecto_IntegranteDTO pi) throws Exception;
}
