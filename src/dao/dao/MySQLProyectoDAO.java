package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;

import dao.beans.CamaradaDTO;
import dao.beans.ProyectoDTO;
import dao.interfaces.ProyectoDAO;
import utils.MySQLConexion;

public class MySQLProyectoDAO implements ProyectoDAO{

	@Override
	public TreeMap<Integer, ProyectoDTO> listarProyectos(Connection con) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "";
		
		TreeMap<Integer, ProyectoDTO> lista = null;
		
		try{
			
			sql = "select * from tb_proyecto";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			lista = new TreeMap<Integer, ProyectoDTO>();
			ProyectoDTO p=null;
			
			while(rs.next()){
				p = new ProyectoDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				lista.put(p.getCod_pro(), p);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al listar los proyectos. /* MySQLProyectoDAO */");
			throw e;
		}
		
		return lista;
	}

	@Override
	public TreeMap<Integer, ProyectoDTO> listarProyectos(Connection con, CamaradaDTO cam) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "";
		
		TreeMap<Integer, ProyectoDTO> lista = null;
		
		try{
			
			sql = "select p.* from tb_proyecto p inner join tb_proyecto_integrante pi on p.cod_pro = pi.cod_pro "
					+ "where pi.cod_cam = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, cam.getCod_cam());
			
			rs = pst.executeQuery();
			
			lista = new TreeMap<Integer, ProyectoDTO>();
			ProyectoDTO p=null;
			
			while(rs.next()){
				p = new ProyectoDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				lista.put(p.getCod_pro(), p);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al listar los proyectos por camarada. /* MySQLProyectoDAO */");
			throw e;
		}
		
		return lista;
	}
	
	@Override
	public int grabarProyecto(Connection con, ProyectoDTO pro) throws Exception {
		Connection cn =MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "insert tb_proyecto values (0,?,?,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, pro.getNom_pro());
			pst.setString(2, pro.getFec_ini_pro());
			pst.setString(3, pro.getFec_lim_pro());
			pst.setString(4, pro.getFec_fin_pro());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al grabar el proyecto ("+pro.getNom_pro()+"). /* MySQLProyectoDAO */");
			throw e;
		}
		return rs;
	}

	@Override
	public int modificarProyecto(Connection con, ProyectoDTO pro) throws Exception {
		
		Connection cn =MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "update tb_proyecto set "
					+ "nom_pro = ?,"
					+ "fec_ini_pro = ?,"
					+ "fec_lim_pro = ?,"
					+ "fec_fin_pro = ? "
					+ "where cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, pro.getNom_pro());
			pst.setString(2, pro.getFec_ini_pro());
			pst.setString(3, pro.getFec_lim_pro());
			pst.setString(4, pro.getFec_fin_pro());
			
			
			pst.setInt(5, pro.getCod_pro());

			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al modificar el proyecto "+pro.getCod_pro()+" - ("+pro.getNom_pro()+"). /* MySQLProyectoDAO */");
			throw e;
		}
		return rs;
	}

	@Override
	public int eliminarProyecto(Connection con, ProyectoDTO pro) throws Exception {
		Connection cn =MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "delete from tb_proyecto where cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, pro.getCod_pro());
			
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			System.out.println("Error al eliminar el proyecto "+pro.getCod_pro()+" - ("+pro.getNom_pro()+"). /* MySQLProyectoDAO */");
			throw e;
		}
		return rs;
	}



	@Override
	public ProyectoDTO obtenerProyectoPorLlave(Connection con, String llave) throws Exception {
		
		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ProyectoDTO p = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			
			sql = "select * from tb_proyecto where llave = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, llave);
			
			rs = pst.executeQuery();
			
			if(rs.next())
				p = new ProyectoDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
			
			if(p==null)
				throw new Exception("No se encontró el proyecto");
			
			
		}catch(Exception e){
			imprimirError("Error al obtener proyecto por llave.");
			throw e;
		}
		
		return p;
	}

	@Override
	public ProyectoDTO obtenerProyecto(Connection con, int cod_pro) throws Exception {
		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		ProyectoDTO p = null;
		
		try{
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			
			sql = "select * from tb_proyecto where cod_pro = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			if(rs.next())
				p = new ProyectoDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
			
			if(p==null)
				throw new Exception("No se encontró el proyecto");
			
			
		}catch(Exception e){
			imprimirError("Error al obtener proyecto por código.");
			throw e;
		}
		
		return p;
	}

	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLProyectoDAO */";
	}

}
