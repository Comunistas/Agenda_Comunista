package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utils.MySQLConexion;
import dao.beans.TipoDocumentoDTO;
import dao.interfaces.TipoDocumentoDAO;



public class MySQLTipoDocumentoDAO implements TipoDocumentoDAO {

	public ArrayList<TipoDocumentoDTO> listarTipoDocumento(Connection con) throws Exception {
		// Retorna un ArrayList con todos los tipos de documento.
		ArrayList<TipoDocumentoDTO> lista = new ArrayList<TipoDocumentoDTO>();
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			String sql = "Select * from tb_tipo_documento";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TipoDocumentoDTO td = new TipoDocumentoDTO(rs.getInt(1), rs.getString(2));
				lista.add(td);
			}
			cn.close();
		} catch (Exception ex) {
			imprimirError("Error al listar los tipos de documento.");
			throw ex;
		}
		return lista;
	}

	public TipoDocumentoDTO obtenerTipoDocumento(Connection con, int codigo) throws Exception {
		// Retorna un objecto TipoDocumentoDTO que tenga el código enviado como
		// parámetro.
		TipoDocumentoDTO td = null;
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion.getConexion(DAOFactory.bd, con);
			String sql = "Select * from tb_tipo_documento where cod_tipo_doc = ?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, codigo);
			rs = pst.executeQuery();

			if (rs.next()) {
				td = new TipoDocumentoDTO(rs.getInt(1), rs.getString(2));
			}
			cn.close();
		} catch (Exception ex) {
			imprimirError("Error al obtener el tipo de documento.");
			throw ex;
		}
		return td;
	}


	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLTipoDocumentoDAO */";
	}
}
