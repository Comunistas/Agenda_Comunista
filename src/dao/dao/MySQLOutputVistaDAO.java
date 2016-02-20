package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.beans.OutputVistaDTO;
import dao.beans.TipoDatoDTO;
import dao.interfaces.OutputVistaDAO;
import utils.MySQLConexion;

public class MySQLOutputVistaDAO implements OutputVistaDAO{

	@Override
	public ArrayList<OutputVistaDTO> listarOutputs(Connection con, int cod_pro,
			int cod_vis) throws Exception {

		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<OutputVistaDTO> lista = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select o.*, td.des_td from tb_output o inner join tb_tipo_dato td on o.cod_td = td.cod_td where o.cod_pro = ? and o.cod_vis = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			pst.setInt(2, cod_vis);
			
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<OutputVistaDTO>();
			OutputVistaDTO o = null;
			
			while(rs.next()){
				o = new OutputVistaDTO(cod_pro, cod_vis, rs.getInt(3), rs.getString(4), new TipoDatoDTO(cod_pro, rs.getInt(5), rs.getString(6))); 
				lista.add(o);
			}
		}catch(Exception e){
			
			imprimirError("Error al listar outputs.");
			throw e;
		}
		return lista;
	}
	
	@Override
	public ArrayList<OutputVistaDTO> listarOutputs(Connection con, int cod_pro)
			throws Exception {
		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<OutputVistaDTO> lista = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select o.*, td.des_td from tb_output o inner join tb_tipo_dato td on o.cod_td = td.cod_td where o.cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, cod_pro);
			
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<OutputVistaDTO>();
			OutputVistaDTO o = null;
			
			while(rs.next()){
				o = new OutputVistaDTO(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4), new TipoDatoDTO(cod_pro, rs.getInt(5), rs.getString(6))); //se ha omitido el cod_pro, que es uncampo de tb_output
				lista.add(o);
			}
		}catch(Exception e){
			imprimirError("Error al listar outputs.");
			throw e;
		}
		return lista;
	}

	@Override
	public int grabarOutput(Connection con, OutputVistaDTO output) throws Exception {


		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "insert tb_output values (?,?,0,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, output.getCod_pro());
			pst.setInt(2, output.getCod_vis());
			pst.setString(3, output.getNom_output());
			pst.setInt(4, output.getTipoDato().getCod_td());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al grabar output.");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarOutput(Connection con, OutputVistaDTO output) throws Exception {

		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "delete from tb_output where cod_pro = ? and cod_vis = ? and cod_output = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, output.getCod_pro());
			pst.setInt(2, output.getCod_vis());
			pst.setInt(3, output.getCod_output());
			
			rs = pst.executeUpdate();

		}catch(Exception e){
			imprimirError("Error al eliminar output.");
			throw e;
		}
		
		return rs;
	}


	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLOutputVistaDAO */";
	}







}
