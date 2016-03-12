package mvc.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.models.ModeloProyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.beans.ProyectoDTO;
import dao.interfaces.Mapping;

@Controller
public class PaginaInicioController {

	final String INICIO = Mapping.INICIO;
	final String CARGARPROYECTOS = Mapping.CARGARPROYECTOS;
	
	ModeloProyecto mP = new ModeloProyecto();

	
	@RequestMapping(value=INICIO, method=RequestMethod.GET)
	public ModelAndView cargarPagina(HttpServletResponse response, 
			@CookieValue(value="npult", defaultValue="nada") String cookiePro,
			@RequestParam(value="np", defaultValue="0", required=false) int cod_pro){
		
		ModelAndView mav;	
		
		int ok = obtenerProyecto(cookiePro, cod_pro);
		
		if(ok==0){
			mav = new ModelAndView("redirect:"+CARGARPROYECTOS);
		}else{
			mav = new ModelAndView("/inicio");
			mav.addObject("m", mP);
			response.addCookie(mP.getCookieProyecto());
		}
		
		return mav;
	}
	
	private int obtenerProyecto(String cookiePro, int cod_pro) {
		int ok = 0;
		
		if(cod_pro!=0){
			
			
			ok = mP.cargarDatosPaginaInicio(cod_pro);
			
		}else if (!cookiePro.equals("nada")) {
			
			ok = mP.cargarDatosPaginaInicio(Integer.parseInt(cookiePro));
			
		}else{
			ok = 0;
		}

		return ok;
	}
}
