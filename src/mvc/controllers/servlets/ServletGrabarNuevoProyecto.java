package mvc.controllers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.beans.CamaradaDTO;
import dao.beans.PerfilDTO;
import dao.beans.ProyectoDTO;
import mvc.models.ModeloProyecto;


public class ServletGrabarNuevoProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;


	ModeloProyecto m = new ModeloProyecto();


	protected void doPost(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException {
		int ok = grabarProyecto(rq, res);
		
		if(ok==0){
			rq.setAttribute("msjGrabarProyecto", "Error al grabar nuevo proyecto");
		}else{
			rq.setAttribute("msjGrabarProyecto", "¡Nuevo proyecto creado!");
		}
		
		rq.getRequestDispatcher("cargarProyectos").forward(rq, res);;
	}
	
	
	private int grabarProyecto(HttpServletRequest rq, HttpServletResponse res){
		int ok = 0;
		
		HttpSession sesion = rq.getSession();
		
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");
		
		String nom_pro = rq.getParameter("nom_pro");
		String fec_ini_pro = rq.getParameter("fec_ini_pro");
		String fec_lim_pro = rq.getParameter("fec_lim_pro");
		int cod_per = Integer.parseInt(rq.getParameter("perfil") == null ? "0" : rq.getParameter("perfil"));
		
		
		ProyectoDTO pro = new ProyectoDTO(0, nom_pro, fec_ini_pro, fec_lim_pro, null, "");
		PerfilDTO p = new PerfilDTO(cod_per, "");
		
		ok = m.grabarNuevoProyecto(pro, cam, p);
		
		if(ok==0) return ok;
		
		String llave = m.getLlave();
		
		rq.setAttribute("llave", llave);
		
		return ok;
	}

}
