package mvc.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import dao.beans.ActividadDTO;
import dao.beans.CamaradaDTO;
import dao.beans.ComentarioDTO;
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
	ProyectoDTO proyecto;
	
	
	
	public int crearNuevoProyecto(ProyectoDTO p){
		
		int ok = 0;
		
		try{
			
			p.generarLlave();
			ok = sMantenimiento.grabarProyecto(null, p);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return ok;
	}
	
	public int cargarProyectos(CamaradaDTO cam){
		int ok = 0;
		try {
						
			listaProyectos = sMantenimiento.listarProyectos(null, cam);
			
			ok=1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return ok;
	}
	
	public int cargarDatosPaginaInicio(ProyectoDTO p){
		
		int ok = 0;
		int cod_pro = p.getCod_pro();
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd);

		try{
			
			proyecto = p;
			listaCamaradas = sMantenimiento.listarCamaradas(cn, p.getCod_pro());
			listaActividades = sMantenimiento.listarActividades(cn, cod_pro);
			listaIntegrantes = sMantenimiento.listarIntegrantes(cn, cod_pro);
			listaComentarios = sMantenimiento.listarComentarios(cn, cod_pro);
			
			ok = 1;
		}catch(Exception e){
			e.printStackTrace();
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
	
	public int integrarseAProyecto(String llave){
		
		int ok = 0;
		ProyectoDTO pro;
		
		try{
						
			if((pro = sMantenimiento.obtenerProyecto(null, llave))!=null){
				ok = 1;
				
				ok = cargarDatosPaginaInicio(pro);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
		return ok;
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
	
	
	
}
