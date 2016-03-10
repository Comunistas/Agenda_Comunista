package mvc.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.models.ModeloProyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.beans.CamaradaDTO;


@Controller
public class AsociarseAProyectoController {
	
	@ModelAttribute("modelo")
	ModeloProyecto modeloProyecto(){
		
		return new ModeloProyecto();
		
	}
	
	@RequestMapping(value="/asociarse")
	public String cargarPagina(){
		return "/asociacion_a_proyecto";
	}
	
	@RequestMapping(value="/asociarse.accion", method=RequestMethod.POST)
	public ModelAndView asociarse(HttpSession sesion, @RequestParam("llave")String llave, @ModelAttribute("modelo")ModeloProyecto modeloProyecto,
			HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/cargarProyectos");
		int ok = 0;
		
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");
		
		ok=modeloProyecto.integrarseAProyecto(llave, cam);

		if(ok==0){
			mav.addObject("msjAsociarseAProyecto", "Error al asociarse al proyecto. Verifique la concordancia de la llave, por favor.");
		}else{
			mav.addObject("msjAsociarseAProyecto", "Usted se ha asociado con éxito.");
			sesion.setAttribute("m", modeloProyecto);
			response.addCookie(modeloProyecto.getCookieProyecto());
		}
		return mav;
	}
}
