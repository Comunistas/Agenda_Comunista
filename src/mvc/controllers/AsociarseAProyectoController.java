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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.beans.CamaradaDTO;
import dao.interfaces.Mapping;


@Controller
public class AsociarseAProyectoController {
	
	final String ASOCIARSE = Mapping.ASOCIARSE;
	final String ACCION = Mapping.ACCION;
	
	@ModelAttribute("modelo")
	ModeloProyecto modeloProyecto(){
		
		return new ModeloProyecto();
		
	}
	
	@RequestMapping(value=ASOCIARSE)
	public String cargarPagina(){
		return "/asociacion_a_proyecto";
	}
	
	@RequestMapping(value=ASOCIARSE+ACCION, method=RequestMethod.POST)
	public ModelAndView asociarse(HttpSession sesion, @RequestParam("llave")String llave, @ModelAttribute("modelo")ModeloProyecto modeloProyecto,
			HttpServletResponse response, RedirectAttributes ra){
		ModelAndView mav;
		int ok = 0;
		
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");
		
		ok=modeloProyecto.integrarseAProyecto(llave, cam);

		if(ok==0){
			mav = new ModelAndView("redirect:/cargarProyectos");
			ra.addFlashAttribute("msjAsociarseAProyecto", "Error al asociarse al proyecto. Verifique la concordancia de la llave, por favor.");
		}else{
			mav = new ModelAndView("redirect:/inicio");
			ra.addFlashAttribute("msjAsociarseAProyecto", "Usted se ha asociado con éxito.");
			response.addCookie(modeloProyecto.getCookieProyecto());
		}
		return mav;
	}
}
