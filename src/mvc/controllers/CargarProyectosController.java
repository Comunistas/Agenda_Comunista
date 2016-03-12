package mvc.controllers;



import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.beans.CamaradaDTO;
import dao.interfaces.Mapping;
import mvc.models.ModeloProyecto;

/**
 * Servlet implementation class CargarProyectosController
 */

@Controller
public class CargarProyectosController{
	
	ModeloProyecto m;
	final String CARGARPROYECTOS = Mapping.CARGARPROYECTOS;
	
	@ModelAttribute("modelo")
	public ModeloProyecto instanciarModelo(){
		m=new ModeloProyecto();
		return m;
	}
	
	@RequestMapping(CARGARPROYECTOS)
	public ModelAndView servicio(HttpSession sesion, Model modelo, @ModelAttribute("modelo") ModeloProyecto modeloProyecto,
			HttpServletResponse response) throws Exception {
		
		
		ModelAndView mav = new ModelAndView("/proyectos");
		int ok = cargarProyectos(sesion, modelo,modeloProyecto, response);

		if(ok==0){
			mav.addObject("msjCargarProyectos", "Error al cargar proyectos.");
		}
		
		
		return mav;
		
	}
	
	private int cargarProyectos(HttpSession sesion, Model modelo, ModeloProyecto m, HttpServletResponse response){
		int ok = 0;
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");

		
		if(cam==null) return 0;
		
		ok = m.cargarProyectos(cam);
		
		modelo.addAttribute("m", m);
		
		return ok;
	}

}
