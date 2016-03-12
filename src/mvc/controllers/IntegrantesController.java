package mvc.controllers;

import mvc.models.ModeloProyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.beans.ProyectoDTO;
import dao.interfaces.Mapping;

@Controller
@RequestMapping(Mapping.INTEGRANTES)
public class IntegrantesController {

	final String TODOS = "/todos";
	
	ModeloProyecto mP = new ModeloProyecto();
	private String MSJERROR = "Error al cargar los integrantes del proyecto. Vuelva a intentar.";
	

	@RequestMapping(value = TODOS, method=RequestMethod.GET)
	public ModelAndView cargarIntegrantes(@RequestParam(value="np", defaultValue="0") int cod_pro,
			RedirectAttributes ra){
		ModelAndView mav;
		
		int ok = 0;
		if(cod_pro==0){
			mav=new ModelAndView("redirect:/error");
			ra.addFlashAttribute("msjError", MSJERROR);
		}else{
			ProyectoDTO p = new ProyectoDTO();
			p.setCod_pro(cod_pro);
			
			ok = mP.cargarDatosPaginaInicio(p);
			
			if(ok==0){
				mav=new ModelAndView("redirect:/error");
				ra.addFlashAttribute("msjError", MSJERROR);
			}else{
				mav = new ModelAndView("/integrantes");
				mav.addObject("m", mP);
			}
		}
		return mav;
	}
}
