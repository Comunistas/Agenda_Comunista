package mvc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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
	
	ModeloProyecto m;
	
	@ModelAttribute("modelo")
	public ModeloProyecto instanciarModelo(){
		m=new ModeloProyecto();
		return m;
	}
	
	@RequestMapping("/cargarProyectos")
	public ModelAndView servicio(HttpSession sesion, Model modelo, @ModelAttribute("modelo") ModeloProyecto modeloProyecto) throws Exception {
		
		
		ModelAndView mav = new ModelAndView("/proyectos");
		int ok = cargarProyectos(sesion, modelo,modeloProyecto);

		if(ok==0){
			mav.addObject("msjCargarProyectos", "Error al cargar proyectos.");
		}
		
		return mav;
		
	}
	
	private int cargarProyectos(HttpSession sesion, Model modelo, ModeloProyecto m){
		int ok = 0;
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");

		
		if(cam==null) return 0;
		
		ok = m.cargarProyectos(cam);
		
		ArrayList<PerfilDTO> listaPerfiles = m.getListaPerfiles();

		sesion.setAttribute("listaPerfiles", listaPerfiles);
		
		modelo.addAttribute("m", m);
		
		
		return ok;
	}

}
