package mvc.controllers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.beans.CamaradaDTO;
import dao.beans.PerfilDTO;
import dao.beans.ProyectoDTO;
import dao.beans.Proyecto_IntegranteDTO;
import mvc.models.ModeloProyecto;

/**
 * Servlet implementation class ServletCargarProyectos
 */
public class ServletCargarProyectos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	ModeloProyecto m = new ModeloProyecto();
	
	public void service(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException {
		int ok = cargarProyectos(rq, res);
		
		
		if(ok==0){
			rq.setAttribute("msjCargarProyectos", "Error al cargar proyectos.");
		}
		
		rq.getRequestDispatcher("paginas/proyectos.jsp").forward(rq, res);
		
	}
	
	private int cargarProyectos(HttpServletRequest rq, HttpServletResponse res){
		int ok = 0;
		
		HttpSession sesion = rq.getSession();
		
		CamaradaDTO cam = (CamaradaDTO)sesion.getAttribute("camaradaLogueado");
		
		if(cam==null) return 0;
		
		ok = m.cargarProyectos(cam);
		
		HashMap<Integer, Proyecto_IntegranteDTO> listaIntegrantesPorCamarada = m.getListaIntegrantesPorCamarada();
		TreeMap<Integer,ProyectoDTO> listaProyectos = m.getListaProyectos();
		ArrayList<PerfilDTO> listaPerfiles = m.getListaPerfiles();
		
		rq.setAttribute("listaProyectosPorCamarada", listaProyectos);
		rq.setAttribute("integrante", listaIntegrantesPorCamarada);
		sesion.setAttribute("listaPerfiles", listaPerfiles);
		
		return ok;
	}

}
