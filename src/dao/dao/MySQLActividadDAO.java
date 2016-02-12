package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import dao.beans.ActividadDTO;
import dao.beans.EstadoDTO;
import dao.interfaces.ActividadDAO;
import utils.MySQLConexion;

public class MySQLActividadDAO implements ActividadDAO{

	@Override
	public HashMap<Integer, ActividadDTO> listarActividades(Connection con,int cod_pro) throws Exception{

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = null;
		HashMap<Integer, ActividadDTO> lista = null;
		int tamano = 0;
		
		try{
		
			sql = "select count(*) from tb_actividad where cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			if(rs.next()){
				tamano = rs.getInt(1);
			}
			
			sql = "select a.*, e.des_est from tb_actividad a inner join tb_estado e on a.cod_est = e.cod_est where cod_pro = ?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			
			lista = new HashMap<Integer, ActividadDTO>((int)(tamano*1.5), (float)0.9);
			ActividadDTO a = null;
			while(rs.next()){
				a = new ActividadDTO(cod_pro, rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),
						new EstadoDTO(rs.getInt(8),rs.getString(9)));
				lista.put(a.getCod_act(), a);
			}
			
			
		}catch(Exception e){
			System.out.println("Error al listar las actividades del proyecto "+cod_pro+". /* MySQLActividadDAO */");
			throw e;
		}
		
		
		return lista;
	}



	@Override
	public int grabarActividad(Connection con, ActividadDTO act) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = null;
		try{
			
			sql = "insert into tb_actividad values (?,0,?,?,?,?,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, act.getCod_pro());
			pst.setString(2, act.getCod_com());
			pst.setString(3, act.getDes_act());
			pst.setString(4, act.getFec_ini_act());
			pst.setString(5,act.getFec_fin_act());
			pst.setString(6, act.getTiempo_est_act());
			pst.setInt(7, act.getEst().getCod_est());

			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al insertar la actividad ("+act.getDes_act()+"). /* MySQLActividadDAO */");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int modificarActividad(Connection con, ActividadDTO act) throws Exception {

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = null;
		try{
			
			sql = "update tb_actividad set "
					+ "cod_cam = ?,"
					+ "des_act = ?,"
					+ "fec_ini_act = ?,"
					+ "fec_fin_act=?,"
					+ "tiempo_est_act=?"
					+ "cod_est = ? "
					+ "where cod_pro = ? and cod_act = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			//set
			pst.setString(1, act.getCod_com());
			pst.setString(2, act.getDes_act());
			pst.setString(3, act.getFec_ini_act());
			pst.setString(4,act.getFec_fin_act());
			pst.setString(5, act.getTiempo_est_act());
			pst.setInt(6, act.getEst().getCod_est());
			//where
			pst.setInt(7, act.getCod_pro());
			pst.setInt(8, act.getCod_act());

			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al modificar la actividad "+act.getCod_act()+". /* MySQLActividadDAO */");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarActividad(Connection con, ActividadDTO act) throws Exception {

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = null;
		try{
			
			sql = "delete from tb_actividad where cod_pro = ? and cod_act = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			//where
			pst.setInt(1, act.getCod_pro());
			pst.setInt(2, act.getCod_act());

			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al eliminar la actividad "+act.getCod_act()+". /* MySQLActividadDAO */");
			throw e;
		}
		
		return rs;
	}

}
