package mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import mvc.models.ModeloProyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.beans.CamaradaDTO;
import dao.beans.ProyectoDTO;
import dao.beans.Proyecto_IntegranteDTO;
import dao.interfaces.Mapping;

@Controller
@RequestMapping(Mapping.INTEGRANTES)
public class IntegrantesController {

	final String ERROR = Mapping.ERROR;
	final String TODOS = "/todos";
	
	
	ModeloProyecto mP = new ModeloProyecto();
	private String MSJERRORINTEGRANTES = "Error al cargar los integrantes del proyecto. Vuelva a intentar.";
	private String MSJERRORINTEGRANTE = "Error al cargar los datos del camarada. Vuelva a intentar.";
	

	@RequestMapping(value = TODOS, method=RequestMethod.GET)
	public ModelAndView cargarIntegrantes(@RequestParam(value="np", defaultValue="0") int cod_pro,
			RedirectAttributes ra, HttpServletRequest rq){
		ModelAndView mav;
				
		int ok = 0;
		if(cod_pro==0){
			mav=new ModelAndView("redirect:/error");
			ra.addFlashAttribute("msjError", MSJERRORINTEGRANTES);
		}else{
			
			ok = mP.cargarDatosPaginaInicio(cod_pro);
			
			if(ok==0){
				mav=new ModelAndView("redirect:/error");
				ra.addFlashAttribute("msjError", MSJERRORINTEGRANTES);
			}else{
				mav = new ModelAndView("/integrantes");
				mav.addObject("m", mP);
			}
		}
		return mav;
	}
	
	
	@RequestMapping(value=TODOS+"/{codIntegrante}")
	public ModelAndView cargarIntegrante(@PathVariable("codIntegrante")String cod_cam,
											@RequestParam("np")int cod_pro,
											RedirectAttributes ra){
		ModelAndView mav;
		
		int ok = 0;
		
		ok = mP.cargarDatosCamaradaPorProyecto(cod_cam, cod_pro);
		
		if(ok==0){
			mav = new ModelAndView("redirect:"+ERROR);
			ra.addFlashAttribute("msjError", MSJERRORINTEGRANTE);
		}else{
			
			CamaradaDTO cam = mP.getCamarada();
			
			Proyecto_IntegranteDTO camInt = mP.getIntegrante();
			
			
			mav = new ModelAndView("/camarada");
			mav.addObject("cam",  cam);
			mav.addObject("camInt", camInt);
			mav.addObject("m", mP);
		}
		
		return mav;
	}
}
