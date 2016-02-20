package dao.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.beans.TemaDTO;
import dao.interfaces.TemaDAO;
import utils.MySQLConexion;

public class MySQLTemaDAO implements TemaDAO{

	@Override
	public TemaDTO temaSeleccionado(Connection con) throws Exception {
		TemaDTO t = null;
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "select * from tb_tema where seleccionado = 1";
		
		try{
			Statement st = cn.createStatement();
			
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				t = TemaDTO.getInstance();
				t.setCod_tema(rs.getString(1));
				t.setNom_tema(rs.getString(2));
				t.setSeleccionado(true);
			}
			
		}catch(Exception e){
			imprimirError("Error al abrir tema seleccionado. Se usará el tema por defecto en el programa.");
			throw e;
		}
		return t;
	}

	@Override
	public int modificarTemaSeleccionado(Connection con) {
		TemaDTO t = TemaDTO.getInstance();
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "update tb_tema "
				+ "set seleccionado = 0";
		int rs = 0;
		
		try{
			
			cn.createStatement().executeUpdate(sql);
			
			sql = "update tb_tema "
					+ "set seleccionado = 1 "
					+ "where nom_tema = "+t.getNom_tema();
			
			rs = cn.createStatement().executeUpdate(sql);
			
		}catch(Exception e){
			imprimirError("Error al modificar el tema seleccionado en la BD.");
		}
		
		return rs;
	}

	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLTemaDAO */";
	}

}
