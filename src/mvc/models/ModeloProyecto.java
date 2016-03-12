package mvc.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.http.Cookie;

import dao.beans.ActividadDTO;
import dao.beans.CamaradaDTO;
import dao.beans.ComentarioDTO;
import dao.beans.PerfilDTO;
import dao.beans.ProyectoDTO;
import dao.beans.Proyecto_IntegranteDTO;
import dao.dao.DAOFactory;
import services.MantenimientoService;
import utils.MySQLConexion;

public class ModeloProyecto {

	MantenimientoService sMantenimiento = new MantenimientoService();
	
	HashMap<String, CamaradaDTO> listaCamaradas;
	HashMap<Integer,ActividadDTO> listaActividades;
	ArrayList<Proyecto_IntegranteDTO> listaIntegrantes;
	TreeMap<Integer, ProyectoDTO> listaProyectos;
	HashMap<Integer, ComentarioDTO> listaComentarios;
	HashMap<Integer, Proyecto_IntegranteDTO> listaIntegrantesPorCamarada;
	ArrayList<PerfilDTO> listaPerfiles;
	ProyectoDTO proyecto;
	String llave;
	Cookie cookieProyecto;
	
	
	
	public int grabarNuevoProyecto(ProyectoDTO pro, CamaradaDTO cam, PerfilDTO p){
		
		int ok = 0;
		
		try{
			
			
			pro.generarLlave();
			ok = sMantenimiento.grabarProyectoCoordinador(pro, cam, p);
			
			llave = pro.getLlave();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return ok;
	}
	
	public int cargarProyectos(CamaradaDTO cam){
		int ok = 0;
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd);

		try {
			cn.setAutoCommit(false);	
			
			listaProyectos = sMantenimiento.listarProyectos(cn, cam);
			listaIntegrantesPorCamarada = sMantenimiento.listarIntegrantesPorCamarada(cn, cam);
			listaPerfiles = sMantenimiento.listarPerfiles(cn);
			cn.commit();
			cn.setAutoCommit(true);
			ok=1;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 0;
		}
		return ok;
	}
	
	public int cargarDatosPaginaInicio(ProyectoDTO p){
		
		int ok = 0;
		int cod_pro = p.getCod_pro();
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd);

		try{
			cn.setAutoCommit(false);
			proyecto = p;
			listaCamaradas = sMantenimiento.listarCamaradas(cn, cod_pro);
			listaActividades = sMantenimiento.listarActividades(cn, cod_pro);
			listaIntegrantes = sMantenimiento.listarIntegrantes(cn, cod_pro);
			listaComentarios = sMantenimiento.listarComentarios(cn, cod_pro);
			cn.commit();
			cn.setAutoCommit(true);
			ok = 1;
		}catch(Exception e){
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 0;
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ok;
		
	}
	
	public int modificarProyecto(ProyectoDTO p){
		
		int ok = 0;
		
		try{
			
			ok = sMantenimiento.modificarProyecto(null, p);
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return ok;
	}
	
	public int integrarseAProyecto(String llave, CamaradaDTO cam){
		
		int ok = 0;
		ProyectoDTO pro;
		
		try{
						
			if((pro = sMantenimiento.obtenerProyecto(null, llave))!=null){
				ok = 1;
				
				Proyecto_IntegranteDTO pi = new Proyecto_IntegranteDTO(pro.getCod_pro(), cam.getCod_cam(), new PerfilDTO(1, null), 0);
				ok=sMantenimiento.grabarIntegrante(null, pi);
				
				if(ok==0)return ok;
				
				ok = cargarDatosPaginaInicio(pro);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
		return ok;
	}
	
	public void crearCookieProyecto(){
		cookieProyecto = new Cookie("npult", String.valueOf(proyecto.getCod_pro()));
		cookieProyecto.setPath("/");
		cookieProyecto.setMaxAge(60*60*24);
	}
	

	public HashMap<String, CamaradaDTO> getListaCamaradas() {
		return listaCamaradas;
	}

	public HashMap<Integer, ActividadDTO> getListaActividades() {
		return listaActividades;
	}

	public ArrayList<Proyecto_IntegranteDTO> getListaIntegrantes() {
		return listaIntegrantes;
	}

	public TreeMap<Integer, ProyectoDTO> getListaProyectos() {
		return listaProyectos;
	}

	public HashMap<Integer, ComentarioDTO> getListaComentarios() {
		return listaComentarios;
	}

	public ProyectoDTO getProyecto() {
		return proyecto;
	}
	
	public HashMap<Integer, Proyecto_IntegranteDTO> getListaIntegrantesPorCamarada(){
		return listaIntegrantesPorCamarada;
	}
	public String getLlave(){
		return llave;
	}
	public ArrayList<PerfilDTO> getListaPerfiles(){
		return listaPerfiles;
	}
	public Cookie getCookieProyecto(){
		crearCookieProyecto();
		return cookieProyecto;
	}
}
