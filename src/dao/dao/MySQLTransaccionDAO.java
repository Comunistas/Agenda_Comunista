package dao.dao;

import java.sql.Connection;

import services.MantenimientoService;
import utils.MySQLConexion;
import dao.beans.CamaradaDTO;
import dao.beans.PerfilDTO;
import dao.beans.ProyectoDTO;
import dao.beans.Proyecto_IntegranteDTO;
import dao.interfaces.TransaccionDAO;

public class MySQLTransaccionDAO implements TransaccionDAO{

	@Override
	public int grabarProyectoCoordinador(ProyectoDTO pro, CamaradaDTO cam, PerfilDTO perfil) throws Exception {
		MantenimientoService sMantenimiento = new MantenimientoService();
		
		int ok = 0;
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd);
		try{
			
			cn.setAutoCommit(false);
			
			ok=sMantenimiento.grabarProyecto(cn, pro);
			if(ok==0) return ok;
			
			ProyectoDTO proy = sMantenimiento.obtenerProyecto(cn, pro.getLlave());
			
			Proyecto_IntegranteDTO pi = new Proyecto_IntegranteDTO(proy.getCod_pro(), cam.getCod_cam(), perfil, 1);
			
			ok = sMantenimiento.grabarIntegrante(cn, pi);
			
			cn.commit();
			cn.setAutoCommit(true);
		}catch(Exception e){
			throw e;
		}
		return ok;
	}

}
