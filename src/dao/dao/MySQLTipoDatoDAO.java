package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.beans.TipoDatoDTO;
import dao.interfaces.TipoDatoDAO;
import utils.MySQLConexion;

public class MySQLTipoDatoDAO implements TipoDatoDAO{

	@Override
	public ArrayList<TipoDatoDTO> listaTiposDato(Connection con, int cod_pro) throws Exception {
		
		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<TipoDatoDTO> lista = null;

		try {
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select * from tb_tipo_dato";
			PreparedStatement pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<>();
			TipoDatoDTO td;
			while (rs.next()) {
				td = new TipoDatoDTO(cod_pro, rs.getInt(2), rs.getString(3));
				lista.add(td);
			}
			

		} catch (Exception e) {
			imprimirError("Error al listar tipos de datos.");
			throw e;
		}

		return lista;
		
	}

	@Override
	public int grabarTipoDato(Connection con, TipoDatoDTO td) throws Exception {

		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "insert tb_tipo_dato values (?,0,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, td.getCod_pro());
			pst.setString(1, td.getDes_td());
			
		}catch(Exception e){
			imprimirError("Error al agregar tipo de dato \""+td.getDes_td()+"\".");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarTipoDato(Connection con, TipoDatoDTO td) throws Exception {

		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "delete from tb_tipo_dato where cod_pro = ? and cod_td = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, td.getCod_pro());
			pst.setInt(1,td.getCod_td());
			
		}catch(Exception e){
			imprimirError("Error al Eliminar tipo de dato \""+td.getDes_td()+"\".");
			throw e;
		}
		
		return rs;
		
		
	}

	
	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLTipoDatoDAO */";
	}


}
