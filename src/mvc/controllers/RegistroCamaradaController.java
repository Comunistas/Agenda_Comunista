package mvc.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.models.ModeloRegistroCamarada;
import dao.beans.CamaradaDTO;

@Controller
public class RegistroCamaradaController {

       
	ModeloRegistroCamarada model = new ModeloRegistroCamarada();

	@RequestMapping(value="/registro")
	public String mapearAlRegistro(){
		return "/registro";
	}
	
	@RequestMapping(value="/nuevoCamarada", method = RequestMethod.POST)
	public ModelAndView registroCamarada(@ModelAttribute("NuevoCamarada") CamaradaDTO cam) throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView("/registro");
		
		cam.setFec_ult_ing("hoy");
		cam.setPwdEncriptado(false);
		int ok = model.grabarNuevoCamarada(cam);;
		
		if(ok==0){
			mav.addObject("msjRegistro", "Ha ocurrido un error al registrarte. Por favor, intenta de nuevo.");
		}else{
			mav.addObject("msjRegistro", "¡Has sido registrado exitosamente!");
		}
		
		return mav;
	}
	
}
