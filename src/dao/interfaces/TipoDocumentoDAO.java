package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.TipoDocumentoDTO;

public interface TipoDocumentoDAO {
	public ArrayList<TipoDocumentoDTO> listarTipoDocumento(Connection con) throws Exception;
	public TipoDocumentoDTO obtenerTipoDocumento(Connection con, int codigo) throws Exception;
}
