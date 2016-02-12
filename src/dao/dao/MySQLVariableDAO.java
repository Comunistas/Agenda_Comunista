package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.beans.TipoDatoDTO;
import dao.beans.VariableDTO;
import dao.interfaces.VariableDAO;
import utils.MySQLConexion;

public class MySQLVariableDAO implements VariableDAO{

	@Override
	public ArrayList<VariableDTO> listarVariables(Connection con, int cod_pro) throws Exception {

		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<VariableDTO> lista = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select v.*, td.des_td from tb_variable v inner join tb_tipo_dato td on v.cod_td = td.cod_td where v.cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<VariableDTO>();
			VariableDTO v = null;
			
			while(rs.next()){
				v = new VariableDTO(cod_pro, rs.getInt(2), rs.getString(3), new TipoDatoDTO(cod_pro, rs.getInt(4), rs.getString(5)));
				lista.add(v);
			}
		}catch(Exception e){
			
			imprimirError("Error al listar variables.");
			throw e;
		}
		return lista;
	}

	@Override
	public int grabarVariable(Connection con, VariableDTO v) throws Exception {

		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "insert tb_variable values (?,0,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, v.getCod_pro());
			pst.setString(2, v.getNom_var());
			pst.setInt(3, v.getTipoDato().getCod_td());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al grabar variable.");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarVariable(Connection con, VariableDTO v) throws Exception {

		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "delete from tb_variable where cod_pro = ? and cod_var = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, v.getCod_pro());
			pst.setInt(2, v.getCod_var());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al eliminar variable.");
			throw e;
		}
		
		return rs;
	}


	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLVariableDAO */";
	}
}
