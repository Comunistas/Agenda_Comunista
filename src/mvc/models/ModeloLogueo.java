package mvc.models;

import javax.servlet.http.Cookie;

import dao.beans.CamaradaDTO;
import services.MantenimientoService;

public class ModeloLogueo {

	MantenimientoService sMantenimiento = new MantenimientoService();
	
	private CamaradaDTO cam = null;
	private Cookie cookieLogueado = null, cookiePwd = null, cookieRecordar = null;
	boolean recordar=false;
	
	public boolean pwdValido(String codigo, String password, boolean recordar){
		boolean ok = false;
		this.recordar = recordar;
		
		try{
			cam = sMantenimiento.obtenerCamarada(null, codigo);
			
			if(cam.getPwd_cam().equals(password)){
				ok = true;
				
				
				cam.setFec_ult_ing("hoy");
				int hola = sMantenimiento.modificarCamarada(null, cam);
				
				
				if(hola==0)
					ok = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return ok;
	}

	
	
	private void crearCookieLogueado(){
		
		cookieLogueado = new Cookie("logueado", cam.getCod_cam());
		
		
		cookieLogueado.setMaxAge(60*20);
		
		
		cookieLogueado.setPath("/");
		
	}
	
	private void crearCookiePwd(){
		
		cookiePwd = new Cookie("recordarPwd", cam.getPwd_cam());

		if(recordar) cookiePwd.setMaxAge(60*60*24*365);
		else cookiePwd.setMaxAge(0);
		
		cookiePwd.setPath("/");
	}
	
	private void crearCookieRecordar(){
		
		cookieRecordar = new Cookie("recordarUsuario", cam.getCod_cam());

		if(recordar) cookieRecordar.setMaxAge(60*60*24*365);
		else cookieRecordar.setMaxAge(0);
		
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

	public CamaradaDTO getCamarada() {
		return cam;
	}

	
}
