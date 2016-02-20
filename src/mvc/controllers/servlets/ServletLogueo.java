package mvc.controllers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.models.ModeloLogueo;


public class ServletLogueo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ModeloLogueo m = new ModeloLogueo();
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException {
		int ok = loguearse(rq, res);
		
		if(ok==0){
			rq.setAttribute("msjLogueo", "No se pudo loguear");
			rq.getRequestDispatcher("paginas/login.jsp").forward(rq, res);

		}else{
			rq.setAttribute("msjLogueo", "¡Logueado!");
			rq.getRequestDispatcher("cargarProyectos").forward(rq, res);
		}
		
	}
	
	private int loguearse(HttpServletRequest rq, HttpServletResponse res){
		int ok = 0;
		
		HttpSession sesion = rq.getSession();
		
		String codigo = rq.getParameter("codigo");
		String password = rq.getParameter("password");
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
