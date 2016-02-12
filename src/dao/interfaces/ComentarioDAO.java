package dao.interfaces;

import java.sql.Connection;
import java.util.HashMap;

import dao.beans.ComentarioDTO;

public interface ComentarioDAO {

	public HashMap<Integer, ComentarioDTO> listarComentarios(Connection cn,int cod_pro) throws Exception;
	public int grabarComentario(Connection cn,ComentarioDTO com) throws Exception;
	public int eliminarComentario(Connection cn,ComentarioDTO com) throws Exception;
}
