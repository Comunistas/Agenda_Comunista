package mvc.models;

import javax.servlet.http.Cookie;

import dao.beans.CamaradaDTO;
import services.MantenimientoService;

public class ModeloLogueo {

	MantenimientoService sMantenimiento = new MantenimientoService();
	
	private CamaradaDTO cam = null;
	private Cookie cookieLogueado = null, cookiePwd = null, cookieRecordar = null;
	
	public boolean pwdValido(String codigo, String password, boolean recordar){
		boolean ok = false;
		
		try{
			cam = sMantenimiento.obtenerCamarada(null, codigo);
			
			if(cam.getPwd_cam().equals(password)){
				ok = true;
				cam.setFec_ult_ing("hoy");
				sMantenimiento.modificarCamarada(null, cam);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return ok;
	}

	
	
	public void crearCookieLogueado(){
		
		cookieLogueado = new Cookie("logueado", cam.getCod_cam());
		
		
		cookieLogueado.setMaxAge(60*20);
		
		
		cookieLogueado.setPath("/");
		
	}
	
	public void crearCookiePwd(){
		
		cookiePwd = new Cookie("recordarPwd", cam.getPwd_cam());

		cookiePwd.setMaxAge(60*60*24*365);
		
		cookiePwd.setPath("/");
	}
	
	public void crearCookieRecordar(){
		
		cookieRecordar = new Cookie("recordarUsuario", cam.getCod_cam());

		cookieRecordar.setMaxAge(60*60*24*365);
		
		cookieRecordar.setPath("/");
	}
	
	
	
	public Cookie getCookieLogueado(){
		
		crearCookieLogueado();
		return cookieLogueado;
		
	}
	
	public Cookie getCookiePwd(){
		
		crearCookiePwd();
		return cookiePwd;
		
	}
	
	public Cookie getCookieRecordar(){
		
		crearCookieRecordar();
		return cookieRecordar;
		
	}
}
