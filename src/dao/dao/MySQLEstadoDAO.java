package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.beans.EstadoDTO;
import dao.interfaces.EstadoDAO;
import utils.MySQLConexion;

public class MySQLEstadoDAO implements EstadoDAO {

	@Override
	public ArrayList<EstadoDTO> listarEstados(Connection con) throws Exception {

		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<EstadoDTO> lista = null;

		try {
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select * from tb_estado";
			PreparedStatement pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<>();
			EstadoDTO e;
			while (rs.next()) {
				e = new EstadoDTO(rs.getInt(1), rs.getString(2));
				lista.add(e);
			}
			

		} catch (Exception e) {
			imprimirError("Error al listar estados.");
			throw e;
		}

		return lista;
	}

	@Override
	public int grabarEstado(Connection con, EstadoDTO est) throws Exception {

		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "insert tb_estado values (0,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, est.getDes_est());
			
		}catch(Exception e){
			imprimirError("Error al agregar estado \""+est.getDes_est()+"\".");
			throw e;
		}
		
		return rs;
		
	}

	@Override
	public int modificarEstado(Connection con, EstadoDTO est) throws Exception {
		
		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "update tb_estado set "
					+ "des_est=? "
					+ "where cod_est=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, est.getDes_est());
			pst.setInt(2, est.getCod_est());
			
		}catch(Exception e){
			imprimirError("Error al modificar estado \""+est.getDes_est()+"\".");
			throw e;
		}
		
		return rs;
	}
	
	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLEstadoDAO */";
	}

}
