package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import dao.beans.CamaradaDTO;
import dao.beans.PerfilDTO;
import dao.beans.Proyecto_IntegranteDTO;
import dao.interfaces.Proyecto_IntegranteDAO;
import utils.MySQLConexion;

public class MySQLProyecto_IntegranteDAO implements Proyecto_IntegranteDAO{

	@Override
	public ArrayList<Proyecto_IntegranteDTO> listarIntegrantes(Connection con, int cod_pro) throws Exception {


		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "";
		ArrayList<Proyecto_IntegranteDTO> lista = null;
		
		try{
			sql = "select pi.*, pe.des_per from tb_proyecto_integrante pi inner join tb_perfil pe on pi.cod_per = pe.cod_per where cod_pro = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<Proyecto_IntegranteDTO>();
			Proyecto_IntegranteDTO pi = null;
			
			while (rs.next()){
				pi = new Proyecto_IntegranteDTO(cod_pro, rs.getString(2), new PerfilDTO(rs.getInt(3), rs.getString(5)), rs.getInt(4));
				lista.add(pi);
			}
			
		}catch(Exception e){
			imprimirError("Error al listar integrantes del proyecto "+cod_pro+".");
			throw e;
		}
		
		
		return lista;
		
	}

	@Override
	public int grabarIntegrante(Connection con, Proyecto_IntegranteDTO pi) throws Exception {

		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "insert tb_proyecto_integrante values (?,?,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, pi.getCod_pro());
			pst.setString(2, pi.getCod_cam());
			pst.setInt(3, pi.getPerfil().getCod_per());
			pst.setInt(4, pi.getCoordinador());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al grabar integrante "+pi.getCod_cam()+" de proyecto.");
			throw e;
		}
		
		return rs;
	}

	@Override
	public int eliminarIntegrante(Connection con, Proyecto_IntegranteDTO pi) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		int rs = 0;
		String sql = "";
		
		try{
			sql = "delete from tb_proyecto_integrante where cod_pro = ? and cod_cam = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, pi.getCod_pro());
			pst.setString(2, pi.getCod_cam());
			
			rs = pst.executeUpdate();
			
		}catch(Exception e){
			imprimirError("Error al eliminar al integrante "+pi.getCod_cam()+" de proyecto.");
			throw e;
		}
		
		return rs;
	}

	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLProyecto_IntegranteDAO */";
	}

	@Override
	public HashMap<Integer, Proyecto_IntegranteDTO> listarIntegrantesPorCamarada(Connection con, CamaradaDTO cam) throws Exception {

		Connection cn = null;
		ResultSet rs = null;
		String sql = "";
		HashMap<Integer,Proyecto_IntegranteDTO> lista = null;
		
		try{
			
			cn = MySQLConexion.getConexion(DAOFactory.bd,con);
			sql = "select pi.*, p.des_per from tb_proyecto_integrante pi inner join tb_perfil p "
					+ "on pi.cod_per = p.cod_per"
					+ " where cod_cam = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, cam.getCod_cam());
			
			rs = pst.executeQuery();
			
			lista = new HashMap<Integer, Proyecto_IntegranteDTO>();
			Proyecto_IntegranteDTO pi;
			while(rs.next()){
				pi = new Proyecto_IntegranteDTO(rs.getInt(1), rs.getString(2), new PerfilDTO(rs.getInt(3), rs.getString(5)), rs.getInt(4));
				lista.put(pi.getCod_pro(), pi);
			}
			
			
		}catch(Exception e){
			imprimirError("Error al listar proyecto_integrante, por camarada");
			throw e;
		}
		return lista;
	}

	@Override
	public Proyecto_IntegranteDTO obtenerIntegrante(Connection con,
			String cod_cam) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		ResultSet rs = null;
		String sql = "";
		Proyecto_IntegranteDTO pi = null;
		
		try{
			sql = "select * from tb_proyecto_integrante where cod_cam = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setString(1, cod_cam);
			
			rs = pst.executeQuery();

			
			if (rs.next()){
				pi = new Proyecto_IntegranteDTO(rs.getInt(1), rs.getString(2), new PerfilDTO(rs.getInt(3), rs.getString(5)), rs.getInt(4));
			}
			
		}catch(Exception e){
			imprimirError("Error al obtener detalle del camarada para el proyecto seleccionado.");
			throw e;
		}
		
		
		return pi;
		
	}

}
