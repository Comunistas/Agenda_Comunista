package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.DocumentoDTO;

public interface DocumentoDAO {

	public ArrayList<DocumentoDTO> listarDocumentos(Connection con, int cod_pro) throws Exception;
	public int grabarDocumento(Connection con, DocumentoDTO doc) throws Exception;
	public int eliminarDocumento(Connection con, DocumentoDTO doc) throws Exception;
}
