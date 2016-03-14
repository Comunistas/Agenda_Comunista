package mvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.models.ModeloProyecto;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dao.beans.CamaradaDTO;
import dao.beans.Proyecto_IntegranteDTO;

public class IntegranteProyectoInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest rq, HttpServletResponse res, Object handler){
		
		ModeloProyecto mP = new ModeloProyecto();
		HttpSession sesion = rq.getSession();
		System.out.println("Hola, soy el interceptor de integrante : "+rq.getRequestURI());

		if(rq.getParameter("np")!=null){
			
			String cod_cam = ((CamaradaDTO)sesion.getAttribute("camaradaLogueado")).getCod_cam();
			int cod_pro = Integer.parseInt(rq.getParameter("np"));
			
			mP.cargarDatosCamaradaPorProyecto(cod_cam, cod_pro);
			mP.cargarProyecto(cod_pro);
						
			Proyecto_IntegranteDTO pi = mP.getIntegrante();
			
			rq.setAttribute("camIntLog", pi);
			res.addCookie(mP.getCookieProyecto());
			return true;
			
		}
		
		return false;
	}
}
