package mvc.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import mvc.models.ModeloLogueo;

@Controller
public class LoginController {

	ModeloLogueo m = new ModeloLogueo();
	
	
	@RequestMapping(value="/loginResult", method = RequestMethod.POST)
	protected ModelAndView servicioPOST(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav;
		int ok = loguearse(rq, res);
		
		if(ok==0){
			mav = new ModelAndView("/login");
			mav.addObject("msjLogueo", "No se pudo loguear");

		}else{
			mav= new ModelAndView("redirect:/cargarProyectos");
		}
		
		return mav;
	}
	

	@RequestMapping("/login")
	protected String entrarAlLogueo() throws Exception {		
		return "/login";
	}	
	
	private int loguearse(HttpServletRequest rq, HttpServletResponse res){
		int ok = 0;
		
		HttpSession sesion = rq.getSession();
		
		String codigo = rq.getParameter("cod_cam");
		String password = rq.getParameter("pwd_cam");
		String recordarme = rq.getParameter("recordarme");
		boolean recordar = false;
		
		
		if(recordarme!=null)
			recordar = true;
		
		if(m.pwdValido(codigo, password, recordar)){
			
			res.addCookie(m.getCookieLogueado());
			res.addCookie(m.getCookieRecordar());
			res.addCookie(m.getCookiePwd());
			
			sesion.setAttribute("camaradaLogueado", m.getCamarada());
			
			ok=1;
		}
		
		return ok;
	}

}
