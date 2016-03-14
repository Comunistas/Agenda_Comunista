package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import mvc.controllers.IntegrantesController;
import dao.beans.CamaradaDTO;
import dao.beans.Proyecto_IntegranteDTO;

public interface Proyecto_IntegranteDAO {

	public ArrayList<Proyecto_IntegranteDTO> listarIntegrantes(Connection cn,int cod_pro) throws Exception;
	public Proyecto_IntegranteDTO obtenerIntegrante(Connection cn, String cod_cam, int cod_pro) throws Exception;
	public HashMap<Integer, Proyecto_IntegranteDTO> listarIntegrantesPorCamarada(Connection cn, CamaradaDTO cam) throws Exception;
	public int grabarIntegrante(Connection cn,Proyecto_IntegranteDTO pi) throws Exception;
	public int eliminarIntegrante(Connection cn,Proyecto_IntegranteDTO pi) throws Exception;
}
