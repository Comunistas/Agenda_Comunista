package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import dao.beans.ActividadDTO;
import dao.beans.Dependencia_ActividadDTO;
import dao.beans.EstadoDTO;
import dao.interfaces.Dependencia_ActividadDAO;
import utils.MySQLConexion;

public class MySQLDependencia_ActividadDAO implements Dependencia_ActividadDAO{

	@Override
	public HashMap<Integer, ArrayList<Dependencia_ActividadDTO>> listarDependencia_ActividadPorProyecto(
			Connection cn, int cod_pro) {
		
		return null;
		
	}
	
	@Override
	public ArrayList<Dependencia_ActividadDTO> listarDependencia_Actividad(
			Connection con, int cod_pro, int cod_act_dep) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "";
		ArrayList<Dependencia_ActividadDTO> lista = null;
		
		try{
			sql = "select a1.*, a2.cod_act, a2.cod_est from tb_dependencia_actividad a1 inner join tb_actividad a2 on a1.cod_act = a2.cod_act where cod_pro = ? and cod_act_dep = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<Dependencia_ActividadDTO>();
			Dependencia_ActividadDTO pi = null;
			
			while (rs.next()){
				pi = new Dependencia_ActividadDTO(cod_pro, cod_act_dep, new ActividadDTO(cod_pro, rs.getInt(3), "", "", "", "", "", new EstadoDTO(rs.getInt(4), "")));
				lista.add(pi);
			}
			
		}catch(Exception e){
			imprimirError("Error al listar las actividades, de las que depende la actividad "+cod_act_dep+" del proyecto.");
			throw e;
		}
		
		
		return lista;
	}

	@Override
	public int grabarDependencia_Actividad(Connection con, Dependencia_ActividadDTO da) throws Exception {

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "insert tb_dependencia_actividad values (?,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, da.getCod_pro());
			pst.setInt(2, da.getCod_act_dep());
			pst.setInt(3, da.getAct().getCod_act());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al grabar una dependencia de actividad.");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarDependencia_Actividad(Connection con, Dependencia_ActividadDTO da) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "delete from tb_dependencia_actividad where cod_pro = ? and cod_act_dep = ? and cod_act = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, da.getCod_pro());
			pst.setInt(2, da.getCod_act_dep());
			pst.setInt(3, da.getAct().getCod_act());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al eliminar una dependencia de actividad.");
			throw e;
		}
		
		return rs;
	}


	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLDependencia_ActividadDAO */";
	}



}
