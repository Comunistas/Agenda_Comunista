package mvc.models;

import dao.beans.CamaradaDTO;
import services.MantenimientoService;

public class ModeloRegistroCamarada {

	MantenimientoService sMantenimiento = new MantenimientoService();
	
	public int grabarNuevoCamarada(CamaradaDTO cam){
		int ok = 0;
		
		
		try{
			
			if(!cam.isPwdEncriptado())
				cam.encriptarPwd();
			
			ok = sMantenimiento.grabarCamarada(null, cam);
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
		return ok;
	}
}
