package mvc.models;

import dao.beans.CamaradaDTO;
import services.MantenimientoService;

public class ModeloLogueo {

	MantenimientoService sMantenimiento = new MantenimientoService();
	
	CamaradaDTO cam = null;
	
	public boolean pwdValido(String codigo, String password){
		boolean ok = false;
		
		try{
			cam = sMantenimiento.obtenerCamarada(null, codigo);
			
			if(cam.getPwd_cam().equals(password)){
				ok = true;
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return ok;
	}

}
