package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import dao.beans.VistaDTO;
import dao.interfaces.VistaDAO;
import utils.MySQLConexion;

public class MySQLVistaDAO implements VistaDAO{

	@Override
	public HashMap<Integer, VistaDTO> listarVistas(Connection con, int cod_pro) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = null;
		HashMap<Integer, VistaDTO> lista = null;
		int tamano = 0;
		
		try{
		
			sql = "select count(*) from tb_vista where cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			if(rs.next()){
				tamano = rs.getInt(1);
			}
			
			sql = "select * from tb_vista where cod_pro = ?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			
			lista = new HashMap<Integer, VistaDTO>((int)(tamano*1.5), (float)0.9);
			VistaDTO v = null;
			while(rs.next()){
				v = new VistaDTO(cod_pro, rs.getInt(1), rs.getString(2));
				lista.put(v.getCod_vis(), v);
			}
			
			
		}catch(Exception e){
			imprimirError("Error al listar las vistas del proyecto "+cod_pro+".");
			throw e;
		}
		
		
		return lista;
		
	}

	@Override
	public int grabarVista(Connection con, VistaDTO v) throws Exception {
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = null;
		try{
			
			sql = "insert tb_vista values (?,0,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, v.getCod_pro());
			pst.setString(2, v.getDes_vis());
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al insertar la vista ("+v.getDes_vis()+").");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int modificarVista(Connection con, VistaDTO v) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = null;
		try{
			
			sql = "update tb_vista "
					+ "set des_vis = ? "
					+ "where cod_pro = ? and "
					+ "cod_vis = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, v.getDes_vis());
			pst.setInt(2, v.getCod_pro());
			pst.setInt(3, v.getCod_vis());
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al modificar la vista ("+v.getDes_vis()+").");
			throw e;
		}
		
		return rs;
		
	}

	@Override
	public int eliminarVista(Connection con, VistaDTO v) throws Exception {
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = null;
		try{
			
			sql = "delete from tb_vista "
					+ "where cod_pro = ? and "
					+ "cod_vis = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, v.getCod_pro());
			pst.setInt(2, v.getCod_vis());
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al eliminar la vista ("+v.getDes_vis()+").");
			throw e;
		}
		
		return rs;
	}


	
	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLVistaDAO */";
	}
}
