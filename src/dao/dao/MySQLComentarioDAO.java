package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import dao.beans.ComentarioDTO;
import dao.interfaces.ComentarioDAO;
import utils.MySQLConexion;

public class MySQLComentarioDAO implements ComentarioDAO{

	@Override
	public HashMap<Integer, ComentarioDTO> listarComentarios(Connection con, int cod_pro) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = null;
		HashMap<Integer, ComentarioDTO> lista = null;
		int tamano = 0;
		
		try{
		
			sql = "select count(*) from tb_comentario where cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			if(rs.next()){
				tamano = rs.getInt(1);
			}
			
			sql = "select * from tb_comentario where cod_pro = ?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			
			lista = new HashMap<Integer, ComentarioDTO>((int)(tamano*1.5), (float)0.9);
			ComentarioDTO c = null;
			while(rs.next()){
				c = new ComentarioDTO(cod_pro, rs.getInt(2), rs.getString(3));
				lista.put(c.getCod_com(), c);
			}
			
			
		}catch(Exception e){
			imprimirError("Error al listar comentarios del proyecto "+cod_pro+".");
			throw e;
		}
		
		
		return lista;
		
	}

	@Override
	public int grabarComentario(Connection con, ComentarioDTO com) {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "insert tb_comentario values (?,0,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, com.getCod_pro());
			pst.setString(2, com.getDes_com());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al grabar comentario.");
		}
		
		return rs;
	}

	@Override
	public int eliminarComentario(Connection con, ComentarioDTO com) {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "delete from tb_comentario where cod_pro = ? and cod_com = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, com.getCod_pro());
			pst.setInt(2, com.getCod_com());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al eliminar comentario.");
		}
		
		return rs;
		
	}

	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLComentarioDAO */";
	}


}
