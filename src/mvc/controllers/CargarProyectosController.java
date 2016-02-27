package mvc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.beans.CamaradaDTO;
import dao.beans.PerfilDTO;
import dao.beans.ProyectoDTO;
import dao.beans.Proyecto_IntegranteDTO;
import mvc.models.ModeloProyecto;

/**
 * Servlet implementation class CargarProyectosController
 */

@Controller
public class CargarProyectosController{
       
	
	ModeloProyecto m = new ModeloProyecto();
	
	@RequestMapping("/cargarProyectos")
	public ModelAndView servicio(HttpServletRequest rq) throws Exception {
		
		
		HttpSession sesion = rq.getSession();
		ModelAndView mav = new ModelAndView("/proyectos");
		int ok = cargarProyectos(sesion, mav);
		
		
		if(ok==0){
			mav.addObject("msjCargarProyectos", "Error al cargar proyectos.");
		}
		
		return mav;
		
	}
	
	private int cargarProyectos(HttpSession sesion, ModelAndView mav){
		int ok = 0;
		
		
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");
		
		if(cam==null) return 0;
		
		ok = m.cargarProyectos(cam);
		
		HashMap<Integer, Proyecto_IntegranteDTO> listaIntegrantesPorCamarada = m.getListaIntegrantesPorCamarada();
		TreeMap<Integer,ProyectoDTO> listaProyectos = m.getListaProyectos();
		ArrayList<PerfilDTO> listaPerfiles = m.getListaPerfiles();
		
		
		mav.addObject("listaProyectosPorCamarada", listaProyectos);
		mav.addObject("integrante", listaIntegrantesPorCamarada);
		sesion.setAttribute("listaPerfiles", listaPerfiles);
		
		return ok;
	}

}
