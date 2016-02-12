package dao.dao;

import dao.interfaces.ActividadDAO;
import dao.interfaces.CamaradaDAO;
import dao.interfaces.ComentarioDAO;
import dao.interfaces.Dependencia_ActividadDAO;
import dao.interfaces.DocumentoDAO;
import dao.interfaces.EstadoDAO;
import dao.interfaces.EstandarDAO;
import dao.interfaces.InputVistaDAO;
import dao.interfaces.ModificacionDAO;
import dao.interfaces.OutputVistaDAO;
import dao.interfaces.PerfilDAO;
import dao.interfaces.ProyectoDAO;
import dao.interfaces.Proyecto_IntegranteDAO;
import dao.interfaces.TemaDAO;
import dao.interfaces.TipoDatoDAO;
import dao.interfaces.TipoDocumentoDAO;
import dao.interfaces.VariableDAO;
import dao.interfaces.VistaDAO;

public abstract class DAOFactory {
	public static final int MYSQL=1;
	public static String bd = "bd_agenda_comunista";
	
	public static DAOFactory getDAOFactory(int whichfactory){
		
		switch(whichfactory){
		case MYSQL: return new MySQLDAOFactory();
		default: return null;
		}
	}
	
	public abstract ActividadDAO getActividadDAO();
	public abstract CamaradaDAO getCamaradaDAO();
	public abstract ComentarioDAO getComentarioDAO();
	public abstract Dependencia_ActividadDAO getDependencia_ActividadDAO();
	public abstract EstadoDAO getEstadoDAO();
	public abstract EstandarDAO getEstandarDAO();
	public abstract InputVistaDAO getInputVistaDAO();
	public abstract OutputVistaDAO getOutputVistaDAO();
	public abstract PerfilDAO getPerfilDAO();
	public abstract Proyecto_IntegranteDAO getProyecto_IntegranteDAO();
	public abstract ProyectoDAO getProyectoDAO();
	public abstract TemaDAO getTemaDAO();
	public abstract TipoDatoDAO getTipoDatoDAO();
	public abstract VariableDAO getVariableDAO();
	public abstract VistaDAO getVistaDAO();
	public abstract ModificacionDAO getModificacionDAO();
	public abstract DocumentoDAO getDocumentoDAO();
	public abstract TipoDocumentoDAO getTipoDocumentoDAO();
	
}
