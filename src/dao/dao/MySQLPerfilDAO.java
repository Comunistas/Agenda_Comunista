package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.beans.PerfilDTO;
import dao.interfaces.PerfilDAO;
import utils.MySQLConexion;

public class MySQLPerfilDAO implements PerfilDAO{

	@Override
	public ArrayList<PerfilDTO> listarPerfiles(Connection con) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "";
		ArrayList<PerfilDTO> lista = null;
		
		try{
			sql = "select * from tb_perfil";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			
			rs  = pst.executeQuery();
			
			lista = new ArrayList<PerfilDTO>();
			PerfilDTO p = null;
			
			while(rs.next()){
				p = new PerfilDTO(rs.getInt(1), rs.getString(2));
				lista.add(p);
			}
			
			
		}catch(Exception e){
			System.out.println("Error al listar perfiles. /* MySQLPerfilDAO */");
			throw e;
		}
		
		return lista;
	}

	@Override
	public int grabarPerfil(Connection con, PerfilDTO per) throws Exception {
		Connection cn =MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "insert tb_perfil values (?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, per.getCod_per());
			pst.setString(2, per.getDes_per());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al agregar perfil. /* MySQLPerfilDAO */");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarPerfil(Connection con, PerfilDTO per) throws Exception {
		Connection cn =MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "delete from tb_perfil where cod_per = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, per.getCod_per());
						
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al eliminar perfil. /* MySQLPerfilDAO */");
			throw e;
		}
		
		return rs;
	}



}
