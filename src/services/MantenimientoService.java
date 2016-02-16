package services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import dao.dao.*;
import dao.beans.*;
import dao.interfaces.*;

public class MantenimientoService {

	
	DAOFactory f = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	ActividadDAO objActividadDAO = f.getActividadDAO();
	CamaradaDAO objCamaradaDAO = f.getCamaradaDAO();
	ComentarioDAO objComentarioDAO = f.getComentarioDAO();
	Dependencia_ActividadDAO objDependencia_ActividadDAO = f.getDependencia_ActividadDAO();
	EstadoDAO objEstadoDAO = f.getEstadoDAO();
	EstandarDAO objEstandarDAO = f.getEstandarDAO();
	InputVistaDAO objInputVistaDAO = f.getInputVistaDAO();
	OutputVistaDAO objOutputVistaDAO = f.getOutputVistaDAO();
	PerfilDAO objPerfilDAO = f.getPerfilDAO();
	Proyecto_IntegranteDAO objProyecto_IntegranteDAO = f.getProyecto_IntegranteDAO();
	ProyectoDAO objProyectoDAO = f.getProyectoDAO();
	TemaDAO objTemaDAO = f.getTemaDAO();
	TipoDatoDAO objTipoDatoDAO = f.getTipoDatoDAO();
	VariableDAO objVariableDAO = f.getVariableDAO();
	VistaDAO objVistaDAO = f.getVistaDAO();
	ModificacionDAO objModificacionDAO = f.getModificacionDAO();
	DocumentoDAO objDocumentoDAO = f.getDocumentoDAO();
	TipoDocumentoDAO objTipoDocumentoDAO = f.getTipoDocumentoDAO();
	
	/*
	 * ActividadDAO
	 */
	public HashMap<Integer, ActividadDTO> listarActividades(Connection cn,int cod_pro) throws Exception{
		return objActividadDAO.listarActividades(cn, cod_pro);
	}
	public int grabarActividad(Connection cn, ActividadDTO act) throws Exception{
		return objActividadDAO.grabarActividad(cn, act);
	}
	public int modificarActividad(Connection cn, ActividadDTO act) throws Exception{
		return objActividadDAO.modificarActividad(cn, act);
	}
	public int eliminarActividad(Connection cn, ActividadDTO act) throws Exception{
		return objActividadDAO.eliminarActividad(cn, act);
	}
	
	/*
	 * CamaradaDAO
	 */
	public HashMap<String, CamaradaDTO> listarCamaradas(Connection cn) throws Exception{
		return objCamaradaDAO.listarCamaradas(cn);
	}
	public HashMap<String, CamaradaDTO> listarCamaradas(Connection cn, int cod_pro) throws Exception {
		return objCamaradaDAO.listarCamaradas(cn, cod_pro);
	}
	public int grabarCamarada(Connection cn,CamaradaDTO cam) throws Exception{
		return objCamaradaDAO.grabarCamarada(cn, cam);
	}
	public int modificarCamarada(Connection cn,CamaradaDTO cam) throws Exception{
		return objCamaradaDAO.modificarCamarada(cn, cam);
	}
	public int eliminarCamarada(Connection cn,CamaradaDTO cam) throws Exception{
		return objCamaradaDAO.eliminarCamarada(cn, cam);
	}
	public CamaradaDTO obtenerCamarada(Connection cn, String codigo) throws Exception {
		return objCamaradaDAO.obtenerCamarada(cn, codigo);
	}

	
	/*
	 * ComentarioDAO
	 */
	public HashMap<Integer, ComentarioDTO> listarComentarios(Connection cn,int cod_pro) throws Exception{
		return objComentarioDAO.listarComentarios(cn, cod_pro);
	}
	public int grabarComentario(Connection cn,ComentarioDTO com) throws Exception{
		return objComentarioDAO.grabarComentario(cn, com);
	}
	public int eliminarComentario(Connection cn,ComentarioDTO com) throws Exception{
		return objComentarioDAO.eliminarComentario(cn, com);
	}
	
	/*
	 * Dependencia_ActividadDAO
	 */
	public HashMap<Integer, ArrayList<Dependencia_ActividadDTO>> listarDependencia_ActividadPorProyecto(Connection cn, int cod_pro){
		return objDependencia_ActividadDAO.listarDependencia_ActividadPorProyecto(cn, cod_pro);
	}
	public ArrayList<Dependencia_ActividadDTO> listarDependencia_Actividad(Connection cn,int cod_pro, int cod_act_dep) throws Exception{
		return objDependencia_ActividadDAO.listarDependencia_Actividad(cn, cod_pro, cod_act_dep);
	}
	public int grabarDependencia_Actividad(Connection cn,Dependencia_ActividadDTO da) throws Exception{
		return objDependencia_ActividadDAO.grabarDependencia_Actividad(cn, da);
	}
	public int eliminarDependencia_Actividad(Connection cn,Dependencia_ActividadDTO da) throws Exception{
		return objDependencia_ActividadDAO.eliminarDependencia_Actividad(cn, da);
	}
	
	/*
	 * DocumentoDAO
	 */
	public ArrayList<DocumentoDTO> listarDocumentos(Connection con, int cod_pro) throws Exception{
		return objDocumentoDAO.listarDocumentos(con, cod_pro);
	}
	public int grabarDocumento(Connection con, DocumentoDTO doc) throws Exception{
		return objDocumentoDAO.grabarDocumento(con, doc);
	}
	public int eliminarDocumento(Connection con, DocumentoDTO doc) throws Exception{
		return objDocumentoDAO.eliminarDocumento(con, doc);
	}
	
	/*
	 * EstadoDAO
	 */
	public ArrayList<EstadoDTO> listarEstados(Connection cn) throws Exception{
		return objEstadoDAO.listarEstados(cn);
	}
	public int grabarEstado(Connection cn,EstadoDTO est) throws Exception{
		return objEstadoDAO.grabarEstado(cn, est);
	}
	public int modificarEstado(Connection cn, EstadoDTO est) throws Exception{
		return objEstadoDAO.modificarEstado(cn, est);
	}
	
	/*
	 * EstandarDAO
	 */
	public ArrayList<EstandarDTO> listarEstandares(Connection cn,int cod_pro) throws Exception{
		return objEstandarDAO.listarEstandares(cn, cod_pro);
	}
	public int grabarEstandar(Connection cn,EstandarDTO est) throws Exception{
		return objEstandarDAO.grabarEstandar(cn, est);
	}
	public int eliminarEstandar(Connection cn,EstandarDTO est) throws Exception{
		return objEstandarDAO.eliminarEstandar(cn, est);
	}
	
	/*
	 * InputVistaDAO
	 */
	public ArrayList<InputVistaDTO> listarInputs(Connection cn,int cod_pro, int cod_vis) throws Exception{
		return objInputVistaDAO.listarInputs(cn, cod_pro, cod_vis);
	}
	public ArrayList<InputVistaDTO> listarInputs(Connection cn,int cod_pro) throws Exception{
		return objInputVistaDAO.listarInputs(cn, cod_pro);
	}
	public int grabarInput(Connection cn,InputVistaDTO input) throws Exception{
		return objInputVistaDAO.grabarInput(cn, input);
	}
	public int eliminarInput(Connection cn,InputVistaDTO input) throws Exception{
		return objInputVistaDAO.eliminarInput(cn, input);
	}
	
	/*
	 * ModificacionDAO
	 */
	public ArrayList<ModificacionDTO> listarModificaciones(Connection con, int cod_pro) throws Exception{
		return objModificacionDAO.listarModificaciones(con, cod_pro);
	}
	public int grabarModificacion(Connection con, ModificacionDTO mod) throws Exception{
		return objModificacionDAO.grabarModificacion(con, mod);
	}
	public int modificarModificacion(Connection con, ModificacionDTO mod) throws Exception{
		return objModificacionDAO.modificarModificacion(con, mod);
	}
	public int eliminarModificacion(Connection con, ModificacionDTO mod) throws Exception{
		return objModificacionDAO.eliminarModificacion(con, mod);
	}
	
	/*
	 * OutputVistaDAO
	 */
	public ArrayList<OutputVistaDTO> listarOutputs(Connection cn,int cod_pro, int cod_vis) throws Exception{
		return objOutputVistaDAO.listarOutputs(cn, cod_pro, cod_vis);
	}
	public ArrayList<OutputVistaDTO> listarOutputs(Connection cn,int cod_pro) throws Exception{
		return objOutputVistaDAO.listarOutputs(cn, cod_pro);
	}
	public int grabarOutput(Connection cn,OutputVistaDTO output) throws Exception{
		return objOutputVistaDAO.grabarOutput(cn, output);
	}
	public int eliminarOutput(Connection cn,OutputVistaDTO output) throws Exception{
		return objOutputVistaDAO.eliminarOutput(cn, output);
	}
	
	/*
	 * PerfilDAO
	 */
	public ArrayList<PerfilDTO> listarPerfiles(Connection cn) throws Exception{
		return objPerfilDAO.listarPerfiles(cn);
	}
	public int grabarPerfil(Connection cn,PerfilDTO per) throws Exception{
		return objPerfilDAO.grabarPerfil(cn, per);
	}
	public int eliminarPerfil(Connection cn,PerfilDTO per) throws Exception{
		return objPerfilDAO.eliminarPerfil(cn, per);
	}
	
	/*
	 * Proyecto_IntegranteDAO
	 */
	public ArrayList<Proyecto_IntegranteDTO> listarIntegrantes(Connection cn,int cod_pro) throws Exception{
		return objProyecto_IntegranteDAO.listarIntegrantes(cn, cod_pro);
	}
	public HashMap<Integer, Proyecto_IntegranteDTO> listarIntegrantesPorCamarada(Connection cn, CamaradaDTO cam) throws Exception {
		return objProyecto_IntegranteDAO.listarIntegrantesPorCamarada(cn, cam);
	}
	public int grabarIntegrante(Connection cn,Proyecto_IntegranteDTO pi) throws Exception{
		return objProyecto_IntegranteDAO.grabarIntegrante(cn, pi);
	}
	public int eliminarIntegrante(Connection cn,Proyecto_IntegranteDTO pi) throws Exception{
		return objProyecto_IntegranteDAO.eliminarIntegrante(cn, pi);
	}

	/*
	 * ProyectoDAO
	 */
	public TreeMap<Integer, ProyectoDTO> listarProyectos(Connection cn) throws Exception{
		return objProyectoDAO.listarProyectos(cn);
	}
	public TreeMap<Integer, ProyectoDTO> listarProyectos(Connection cn, CamaradaDTO cam) throws Exception{
		return objProyectoDAO.listarProyectos(cn, cam);
	}
	public int grabarProyecto(Connection cn,ProyectoDTO pro) throws Exception{
		return objProyectoDAO.grabarProyecto(cn, pro);
	}
	public int modificarProyecto(Connection cn,ProyectoDTO pro) throws Exception{
		return objProyectoDAO.modificarProyecto(cn, pro);
	}
	public int eliminarProyecto(Connection cn,ProyectoDTO pro) throws Exception{
		return objProyectoDAO.eliminarProyecto(cn, pro);
	}
	public ProyectoDTO obtenerProyecto(Connection cn, int cod_pro) throws Exception{
		return objProyectoDAO.obtenerProyecto(cn, cod_pro);
	}
	public ProyectoDTO obtenerProyecto(Connection cn, String llave) throws Exception{
		return objProyectoDAO.obtenerProyectoPorLlave(cn, llave);
	}
	
	/*
	 * TemaDAO
	 */
	public TemaDTO temaSeleccionado(Connection cn) throws Exception{
		return objTemaDAO.temaSeleccionado(cn);
	}
	public int modificarTemaSeleccionado(Connection cn) throws Exception{
		return objTemaDAO.modificarTemaSeleccionado(cn);
	}
	
	/*
	 * TipoDatoDAO
	 */
	public ArrayList<TipoDatoDTO> listaTiposDato(Connection cn, int cod_pro) throws Exception{
		return objTipoDatoDAO.listaTiposDato(cn, cod_pro);
	}
	public int grabarTipoDato(Connection cn,TipoDatoDTO td) throws Exception{
		return objTipoDatoDAO.grabarTipoDato(cn, td);
	}
	public int eliminarTipoDato(Connection cn,TipoDatoDTO td) throws Exception{
		return objTipoDatoDAO.eliminarTipoDato(cn, td);
	}
	
	/*
	 * TipoDocumentoDAO
	 */
	public ArrayList<TipoDocumentoDTO> listarTipoDocumento(Connection con) throws Exception{
		return objTipoDocumentoDAO.listarTipoDocumento(con);
	}
	public TipoDocumentoDTO obtenerTipoDocumento(Connection con, int codigo) throws Exception{
		return objTipoDocumentoDAO.obtenerTipoDocumento(con, codigo);
	}
	
	/*
	 * VariableDAO
	 */
	public ArrayList<VariableDTO> listarVariables(Connection cn,int cod_pro) throws Exception{
		return objVariableDAO.listarVariables(cn, cod_pro);
	}
	public int grabarVariable(Connection cn,VariableDTO v) throws Exception{
		return objVariableDAO.grabarVariable(cn, v);
	}
	public int eliminarVariable(Connection cn,VariableDTO v) throws Exception{
		return objVariableDAO.eliminarVariable(cn, v);
	}
	
	/*
	 * VistaDAO
	 */
	public HashMap<Integer, VistaDTO> listarVistas(Connection cn,int cod_pro) throws Exception{
		return objVistaDAO.listarVistas(cn, cod_pro);
	}
	public int grabarVista(Connection cn,VistaDTO v) throws Exception{
		return objVistaDAO.grabarVista(cn, v);
	}
	public int modificarVista(Connection cn,VistaDTO v) throws Exception{
		return objVistaDAO.modificarVista(cn, v);
	}
	public int eliminarVista(Connection cn,VistaDTO v) throws Exception{
		return objVistaDAO.eliminarVista(cn, v);
	}
	
}
