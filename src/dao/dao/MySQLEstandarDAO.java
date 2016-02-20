package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.beans.EstandarDTO;
import dao.interfaces.EstandarDAO;
import utils.MySQLConexion;

public class MySQLEstandarDAO implements EstandarDAO{

	@Override
	public ArrayList<EstandarDTO> listarEstandares(Connection con, int cod_pro) throws Exception {

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = null;
		ArrayList<EstandarDTO> lista = null;
		
		try{

			
			sql = "select * from tb_estandar where cod_pro = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			
			lista = new ArrayList<EstandarDTO>();
			EstandarDTO e = null;
			
			while(rs.next()){
				e = new EstandarDTO(cod_pro, rs.getInt(2), rs.getString(3));
				lista.add(e.getCod_est(), e);
			}
			
			
		}catch(Exception e){
			imprimirError("Error al listar comentarios del proyecto "+cod_pro+".");
			throw e;
		}
		
		
		return lista;
	}

	@Override
	public int grabarEstandar(Connection con, EstandarDTO est) {

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "insert tb_estandar values (?,0,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, est.getCod_pro());
			pst.setString(2, est.getDes_est());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al grabar estándar.");
		}
		
		return rs;
		
	}

	@Override
	public int eliminarEstandar(Connection con, EstandarDTO est) {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "delete from tb_estandar where cod_pro = ? and cod_est = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, est.getCod_pro());
			pst.setInt(2, est.getCod_est());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al eliminar estándar.");
		}
		
		return rs;
		
	}

	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLEstandarDAO */";
	}


}
