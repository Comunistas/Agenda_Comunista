package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utils.MySQLConexion;
import dao.beans.ModificacionDTO;
import dao.interfaces.ModificacionDAO;

public class MySQLModificacionDAO implements ModificacionDAO {

	@Override
	public ArrayList<ModificacionDTO> listarModificaciones(Connection con, int cod_pro) throws Exception {

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "";
		ResultSet rs = null;
		ArrayList<ModificacionDTO> lista = null;
		
		try{
			sql = "select * from tb_modificacion where cod_pro = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<ModificacionDTO>();
			ModificacionDTO mod;
			while(rs.next()){
				mod = new ModificacionDTO(cod_pro, rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
				lista.add(mod);
			}
		}catch(Exception e){
			imprimirError("Error al listar las modificaciones del proyecto.");
			throw e;
		}
		return lista;
	}

	@Override
	public int grabarModificacion(Connection con, ModificacionDTO mod) throws Exception {
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "";
		int rs = 0;
		
		try{
			sql = "insert tb_modificacion values (?,0,?,?,0,'')";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, mod.getCod_pro());
			pst.setString(2, mod.getCod_cam());
			pst.setInt(3, mod.getCod_act());
		}catch(Exception e){
			imprimirError("Error al agregar la modificacion.");
			throw e;
		}

		return rs;
	}

	@Override
	public int modificarModificacion(Connection con, ModificacionDTO mod) throws Exception {
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "";
		int rs = 0;
		
		try{
			sql = "update tb_modificacion"
					+ " set atendido = ?,"
					+ "com_mod = ? "
					+ "where cod_pro = ? and "
					+ "cod_mod = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, mod.getAtendido());
			pst.setString(2, mod.getCom_mod());
			pst.setInt(3, mod.getCod_pro());
			pst.setInt(4, mod.getCod_mod());
			
		}catch(Exception e){
			imprimirError("Error al modificar la modificacion.");
			throw e;
		}

		return rs;
	}

	@Override
	public int eliminarModificacion(Connection con, ModificacionDTO mod) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "";
		int rs = 0;
		
		try{
			sql = "delete from tb_modificacion where cod_pro = ? and cod_mod = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, mod.getCod_pro());
			pst.setInt(2, mod.getCod_mod());
			
		}catch(Exception e){
			imprimirError("Error al eliminar la modificacion.");
			throw e;
		}

		return rs;
		
	}

	
	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLModificacionDAO */";
	}
}
