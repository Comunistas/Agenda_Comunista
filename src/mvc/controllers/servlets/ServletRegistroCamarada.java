package mvc.controllers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.models.ModeloRegistroCamarada;
import dao.beans.CamaradaDTO;


public class ServletRegistroCamarada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ModeloRegistroCamarada model = new ModeloRegistroCamarada();

	protected void doPost(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException {
		
		int ok = registrarCamarada(rq, res);
		
		if(ok==0){
			rq.setAttribute("msjRegistro", "Ha ocurrido un error al registrarte. Por favor, intenta de nuevo.");
		}else{
			rq.setAttribute("msjRegistro", "¡Has sido registrado exitosamente!");
		}
		
		rq.getRequestDispatcher("paginas/registro.jsp").forward(rq, res);
	}
	
	private int registrarCamarada(HttpServletRequest rq, HttpServletResponse res){
		int ok = 0;
		
		String codigo = rq.getParameter("codigo");
		String nombre = rq.getParameter("nombre");
		String apellido = rq.getParameter("apellido");
		String telefono = rq.getParameter("telefono");
		String password = rq.getParameter("password");
		
		CamaradaDTO cam = new CamaradaDTO(codigo, nombre, apellido, telefono, password,"hoy", false);
		
		ok = model.grabarNuevoCamarada(cam);
		
		return ok;
	}

}
