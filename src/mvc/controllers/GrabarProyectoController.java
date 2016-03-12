package mvc.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.beans.CamaradaDTO;
import dao.beans.PerfilDTO;
import dao.beans.ProyectoDTO;
import dao.interfaces.Mapping;
import mvc.models.ModeloProyecto;

@Controller
public class GrabarProyectoController {

	final String NUEVOPROYECTO = Mapping.NUEVOPROYECTO;
	final String CARGARPROYECTOS = Mapping.CARGARPROYECTOS;
	final String ACCION = Mapping.ACCION;

	ModeloProyecto m = new ModeloProyecto();
	
	@ModelAttribute("pro")
	public ProyectoDTO proyecto(){
		
		ProyectoDTO p = new ProyectoDTO();
		p.setCod_pro(0);
		p.setFec_fin_pro("");
		p.setLlave("");
		
		return p;
	}
	

	@RequestMapping(NUEVOPROYECTO)
	public String mapearAlNuevoProyecto(HttpSession sesion, Model modelo){
		
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");
		m.cargarProyectos(cam);
		modelo.addAttribute("listaPerfiles", m.getListaPerfiles());
		
		return "/nuevo_proyecto";
	}
	
	@RequestMapping(NUEVOPROYECTO+ACCION)
	protected ModelAndView grabarProyecto(@ModelAttribute("pro") ProyectoDTO pro, HttpSession sesion,
							@RequestParam(value="perfil", defaultValue = "0", required = false) int cod_per,
							Model modelo, RedirectAttributes ra) throws Exception{
		
		ModelAndView mav = new ModelAndView("redirect:"+CARGARPROYECTOS);
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");	
		PerfilDTO p = new PerfilDTO(cod_per, "");


		int ok = m.grabarNuevoProyecto(pro, cam, p);

		
		if(ok==0){
			ra.addFlashAttribute("msjGrabarProyecto", "Error al grabar nuevo proyecto");
		}else{
			ra.addFlashAttribute("llave",m.getLlave());
			ra.addFlashAttribute("msjGrabarProyecto", "¡Nuevo proyecto creado!");
		}
		
		return mav;
	}
	
	


}
