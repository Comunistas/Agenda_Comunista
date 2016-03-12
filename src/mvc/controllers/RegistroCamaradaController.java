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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mvc.models.ModeloRegistroCamarada;
import dao.beans.CamaradaDTO;
import dao.interfaces.Mapping;

@Controller
public class RegistroCamaradaController {

	final String REGISTRO = Mapping.REGISTRO;
	final String ACCION = Mapping.ACCION;
	
	private String MSJERROR = "Ha ocurrido un error al registrarte. Por favor, intenta de nuevo.";
	private String MSJEXITO = "¡Has sido registrado exitosamente!";
	
	ModeloRegistroCamarada model = new ModeloRegistroCamarada();
	
	
	@RequestMapping(value = REGISTRO)
	public String mapearAlRegistro() {
		return "/registro";
	}

	
	@RequestMapping(value = REGISTRO+ACCION, method = RequestMethod.POST)
	public ModelAndView registroCamarada(
			@ModelAttribute("NuevoCamarada") CamaradaDTO cam,
			RedirectAttributes ra) throws ServletException, IOException {

		ModelAndView mav = new ModelAndView("redirect:" + REGISTRO);

		cam.setFec_ult_ing("hoy");
		cam.setPwdEncriptado(false);
		int ok = model.grabarNuevoCamarada(cam);
		

		if (ok == 0) {
			ra.addFlashAttribute("msjRegistro",
					MSJERROR);
		} else {
			ra.addFlashAttribute("msjRegistro",
					MSJEXITO);
		}

		return mav;
	}

}
