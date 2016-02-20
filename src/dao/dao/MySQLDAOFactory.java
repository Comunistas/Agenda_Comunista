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
import dao.interfaces.TransaccionDAO;
import dao.interfaces.VariableDAO;
import dao.interfaces.VistaDAO;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public ModificacionDAO getModificacionDAO(){
		return new MySQLModificacionDAO();
	}
	
	@Override
	public ActividadDAO getActividadDAO() {
		return new MySQLActividadDAO();
	}

	@Override
	public CamaradaDAO getCamaradaDAO() {
		return new MySQLCamaradaDAO();
	}

	@Override
	public ComentarioDAO getComentarioDAO() {
		return new MySQLComentarioDAO();
	}

	@Override
	public Dependencia_ActividadDAO getDependencia_ActividadDAO() {
		return new MySQLDependencia_ActividadDAO();
	}

	@Override
	public EstadoDAO getEstadoDAO() {
		return new MySQLEstadoDAO();
	}

	@Override
	public EstandarDAO getEstandarDAO() {
		return new MySQLEstandarDAO();
	}
//
	@Override
	public InputVistaDAO getInputVistaDAO() {
		return new MySQLInputVistaDAO();
	}

	@Override
	public OutputVistaDAO getOutputVistaDAO() {
		return new MySQLOutputVistaDAO();
	}

	@Override
	public PerfilDAO getPerfilDAO() {
		return new MySQLPerfilDAO();
	}

	@Override
	public Proyecto_IntegranteDAO getProyecto_IntegranteDAO() {
		return new MySQLProyecto_IntegranteDAO();
	}

	@Override
	public ProyectoDAO getProyectoDAO() {
		return new MySQLProyectoDAO();
	}

	@Override
	public TemaDAO getTemaDAO() {
		return new MySQLTemaDAO();
	}

	@Override
	public TipoDatoDAO getTipoDatoDAO() {
		return new MySQLTipoDatoDAO();
	}

	@Override
	public VariableDAO getVariableDAO() {
		return new MySQLVariableDAO();
	}

	@Override
	public VistaDAO getVistaDAO() {
		return new MySQLVistaDAO();
	}

	@Override
	public DocumentoDAO getDocumentoDAO() {
		return new MySQLDocumentoDAO();
	}

	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		return new MySQLTipoDocumentoDAO();
	}

	@Override
	public TransaccionDAO getTransaccionDAO() {
		
		return new MySQLTransaccionDAO();
	}

}
