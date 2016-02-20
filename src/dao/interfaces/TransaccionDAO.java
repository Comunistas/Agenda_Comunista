package dao.interfaces;

import dao.beans.CamaradaDTO;
import dao.beans.PerfilDTO;
import dao.beans.ProyectoDTO;

public interface TransaccionDAO {

	public int grabarProyectoCoordinador(ProyectoDTO pro, CamaradaDTO cam, PerfilDTO p) throws Exception;
}
