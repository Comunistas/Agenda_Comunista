package mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.interfaces.Mapping;

@Controller
public class ErrorController {
	
	
	@RequestMapping(Mapping.ERROR)
	public ModelAndView cargarPaginaError(){
		ModelAndView mav = new ModelAndView("/error");
		return mav;
	}
}
