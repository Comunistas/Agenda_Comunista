package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import dao.beans.CamaradaDTO;
import dao.interfaces.CamaradaDAO;
import utils.MySQLConexion;

public class MySQLCamaradaDAO implements CamaradaDAO{

	@Override
	public HashMap<String, CamaradaDTO> listarCamaradas(Connection con) throws Exception {
		
		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		HashMap<String, CamaradaDTO> lista = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "select count(*) from tb_camarada";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			if(rs.next()){
				num = rs.getInt(1);
			}
			
			sql = "select * from tb_camarada";
			pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			
			lista = new HashMap<String, CamaradaDTO>((int)(num*1.5), (float)0.9);
			CamaradaDTO c;
			
			while(rs.next()){
				c = new CamaradaDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lista.put(c.getCod_cam(), c);
			}
			
		}catch(Exception e){
			System.out.println("Error al listar camaradas. /* MySQLCamaradaDAO */");
			throw e;
		}
		
		return lista;
	}

	@Override
	public int grabarCamarada(Connection con, CamaradaDTO cam) throws Exception {
		
		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		
		try{
			
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "insert tb_camarada values(?,?,?,?,?)";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, cam.getCod_cam());
			pst.setString(2, cam.getNom_cam());
			pst.setString(3, cam.getApe_cam());
			pst.setString(4, cam.getTel_cam());
			pst.setString(5, cam.getPwd_cam());
			
			rs = pst.executeUpdate();
			
			
		}catch(Exception e){
			
			System.out.println("Error al grabar camarada "+cam.getCod_cam()+". /* MySQLCamaradaDAO */");
			throw e;
		}
		return rs;
	}

	@Override
	public int modificarCamarada(Connection con, CamaradaDTO cam) throws Exception {
		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		
		try{
			
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "update tb_camarada set nom_cam = ?,"
					+ "ape_cam = ?,"
					+ "tel_cam = ?,"
					+ "pwd_cam = ? "
					+ "where cod_cam = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, cam.getNom_cam());
			pst.setString(2, cam.getApe_cam());
			pst.setString(3, cam.getTel_cam());
			pst.setString(4, cam.getPwd_cam());
			pst.setString(5, cam.getCod_cam());
			
			rs = pst.executeUpdate();
			
			
		}catch(Exception e){
			
			System.out.println("Error al modificar camarada "+cam.getCod_cam()+". /* MySQLCamaradaDAO */");
			throw e;
		}
		return rs;
	}

	@Override
	public int eliminarCamarada(Connection con, CamaradaDTO cam) throws Exception {
		Connection cn = null;
		int rs = 0;
		String sql = "";
		
		
		try{
			
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			sql = "delete from tb_camarada where cod_cam = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(4, cam.getCod_cam());
			
			rs = pst.executeUpdate();
			
			
		}catch(Exception e){
			
			System.out.println("Error al eliminar camarada "+cam.getCod_cam()+". /* MySQLCamaradaDAO */");
			throw e;
		}
		return rs;
	}

	@Override
	public CamaradaDTO obtenerCamarada(Connection con, String codigo)
			throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "";
		CamaradaDTO cam = null;
		
		try{
			
			sql = "select * from tb_camarada where cod_cam = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeQuery();
			
			if(rs.next()){
				cam = new CamaradaDTO(codigo, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
			if(cam==null)
				throw new Exception("No se ha encontrado a ese camarada");
		}catch(Exception e){
			imprimirError("Error al obtener camarada.");
			throw e;
		}
		
		return cam;
	}

	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLEstadoDAO */";
	}
	
}
