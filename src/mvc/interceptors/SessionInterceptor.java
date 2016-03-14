package mvc.interceptors;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.models.ModeloLogueo;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dao.beans.CamaradaDTO;

import java.util.Optional;

public class SessionInterceptor extends HandlerInterceptorAdapter{
	
	ModeloLogueo mL = new ModeloLogueo();
	
	@Override
	public boolean preHandle(HttpServletRequest rq, HttpServletResponse res, Object handler){
		
		HttpSession sesion = rq.getSession();
		
		System.out.println("Hola, soy el interceptor de sesión : "+rq.getRequestURI());

		if(sesion.getAttribute("camaradaLogueado")==null){
			Cookie[] todosLosCookies = rq.getCookies();
			String logueado = null;
			Optional<Cookie> o;
			
			if((o = Arrays.stream(todosLosCookies).filter(x->x.getName().equals("logueado")).findAny()).isPresent()){
				logueado = o.get().getValue();
			}
			
			if(logueado!=null){
				
				CamaradaDTO cam;
				String[] logPwd = logueado.split(" - ");
				
				if(mL.pwdValido(logPwd[0], logPwd[1], false)){
					
					cam = mL.getCamarada();

					sesion.setAttribute("camaradaLogueado", cam);
					res.addCookie(mL.getCookieLogueado());
					System.out.println("Hola, soy el interceptor, y he logueado al camarada de nuevo.");
				}
					
			}
		}
		
		return true;
	}
}
