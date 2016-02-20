package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.beans.InputVistaDTO;
import dao.beans.TipoDatoDTO;
import dao.interfaces.InputVistaDAO;
import utils.MySQLConexion;

public class MySQLInputVistaDAO implements InputVistaDAO{

	@Override
	public ArrayList<InputVistaDTO> listarInputs(Connection con, int cod_pro, int cod_vis) throws Exception {
		
		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<InputVistaDTO> lista = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select i.*, td.des_td from tb_input i inner join tb_tipo_dato td on i.cod_td = td.cod_td where i.cod_pro = ? and i.cod_vis = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			pst.setInt(2, cod_vis);
			
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<InputVistaDTO>();
			InputVistaDTO o = null;
			
			while(rs.next()){
				o = new InputVistaDTO(cod_pro, cod_vis, rs.getInt(3), rs.getString(4), new TipoDatoDTO(cod_pro, rs.getInt(5), rs.getString(6))); //se ha omitido el cod_pro, que es uncampo de tb_input
				lista.add(o);
			}
		}catch(Exception e){
			
			imprimirError("Error al listar inputs.");
			throw e;
		}
		return lista;
	}
	
	@Override
	public ArrayList<InputVistaDTO> listarInputs(Connection con, int cod_pro)
			throws Exception {
		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<InputVistaDTO> lista = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select i.*, td.des_td from tb_input i inner join tb_tipo_dato td on i.cod_td = td.cod_td where i.cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<InputVistaDTO>();
			InputVistaDTO o = null;
			
			while(rs.next()){
				o = new InputVistaDTO(cod_pro, rs.getInt(2), rs.getInt(3), rs.getString(4), new TipoDatoDTO(cod_pro, rs.getInt(5), rs.getString(6))); 
				lista.add(o);
			}
		}catch(Exception e){
			
			imprimirError("Error al listar inputs.");
			throw e;
		}
		return lista;
	}

	@Override
	public int grabarInput(Connection con, InputVistaDTO input) throws Exception {
		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "insert tb_input values (?,?,0,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, input.getCod_pro());
			pst.setInt(2, input.getCod_vis());
			pst.setString(3, input.getNom_input());
			pst.setInt(4, input.getTipoDato().getCod_td());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al grabar input.");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarInput(Connection con, InputVistaDTO input) throws Exception {


		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "delete from tb_input where cod_pro = ? and cod_vis = ? and cod_input = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, input.getCod_pro());
			pst.setInt(2, input.getCod_vis());
			pst.setString(3, input.getNom_input());
			pst.setInt(4, input.getTipoDato().getCod_td());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al eliminar input.");
			throw e;
		}
		
		return rs;
		
	}


	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLInputVistaDAO */";
	}


}
