package dao.interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import dao.beans.TipoDatoDTO;

public interface TipoDatoDAO {

	public ArrayList<TipoDatoDTO> listaTiposDato(Connection cn, int cod_pro) throws Exception;
	public int grabarTipoDato(Connection cn,TipoDatoDTO td) throws Exception;
	public int eliminarTipoDato(Connection cn,TipoDatoDTO td) throws Exception;
	
}
