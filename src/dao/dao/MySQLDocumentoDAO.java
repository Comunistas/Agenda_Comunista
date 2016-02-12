package dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utils.MySQLConexion;
import dao.beans.DocumentoDTO;
import dao.beans.TipoDocumentoDTO;
import dao.interfaces.DocumentoDAO;

public class MySQLDocumentoDAO implements DocumentoDAO{

	@Override
	public ArrayList<DocumentoDTO> listarDocumentos(Connection con,int cod_pro) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "";
		ResultSet rs = null;
		ArrayList<DocumentoDTO> lista = null;
		
		try{
			sql = "select d.*, td.des_tipo_doc from tb_documento d inner join tb_tipo_documento td on d.cod_tipo_doc = td.cod_tipo_doc where cod_pro = ?";
			
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, cod_pro);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<DocumentoDTO>();
			DocumentoDTO doc;
			while(rs.next()){
				doc = new DocumentoDTO(rs.getInt(1), cod_pro, rs.getString(3), rs.getString(4), new TipoDocumentoDTO(rs.getInt(5), rs.getString(7)), null);
				lista.add(doc);
			}
		}catch(Exception e){
			imprimirError("Error al listar los documentos del proyecto.");
			throw e;
		}
		return lista;
	}

	@Override
	public int grabarDocumento(Connection con, DocumentoDTO doc) throws Exception {
		
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "";
		int rs = 0;
		
		try{
			sql = "insert tb_documento values (0,?,?,?,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, doc.getCod_pro());
			pst.setString(2, doc.getNom_doc());
			pst.setString(3, doc.getDes_doc());
			pst.setInt(4, doc.getTipoDocumento().getCod_tipo_doc());
			pst.setBlob(5, doc.getAdjunto()); // puede causar excepción. requiere una prueba (Opción 2: setBinaryStream(5,doc.getAdjunto);)
			
		}catch(Exception e){
			imprimirError("Error al grabar el documento.");
			throw e;
		}

		return rs;
	}

	@Override
	public int eliminarDocumento(Connection con, DocumentoDTO doc) throws Exception {
		Connection cn = MySQLConexion.getConexion(DAOFactory.bd, con);
		String sql = "";
		int rs = 0;
		
		try{
			sql = "delete from tb_documento where cod_doc = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			
			pst.setInt(1, doc.getCod_doc());

			
		}catch(Exception e){
			imprimirError("Error al eliminar el documento.");
			throw e;
		}

		return rs;
	}
	
	private void imprimirError(String error){
		System.out.println(error+" "+nombreClase());
	}
	
	public static String nombreClase(){
		return "/* MySQLDocumentoDAO */";
	}
}
