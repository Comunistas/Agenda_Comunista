package dao.beans;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class DocumentoDTO {
	
	private int cod_doc, cod_pro;
	private String nom_doc, des_doc;
	private TipoDocumentoDTO tipoDocumento;
	private InputStream adjunto;
	
	public DocumentoDTO(int cod_doc, int cod_pro, String nom_doc,
			String des_doc, TipoDocumentoDTO tipoDocumento, Blob adjunto) {
		this.cod_doc = cod_doc;
		this.cod_pro = cod_pro;
		this.nom_doc = nom_doc;
		this.des_doc = des_doc;
		this.tipoDocumento = tipoDocumento;
		setAdjunto(adjunto);
	}
	public DocumentoDTO(int cod_doc, int cod_pro, String nom_doc,
			String des_doc, InputStream adjunto, TipoDocumentoDTO tipoDocumento) {
		this.cod_doc = cod_doc;
		this.cod_pro = cod_pro;
		this.nom_doc = nom_doc;
		this.des_doc = des_doc;
		this.tipoDocumento = tipoDocumento;
		setAdjunto(adjunto);
	}

	public int getCod_doc() {
		return cod_doc;
	}

	public void setCod_doc(int cod_doc) {
		this.cod_doc = cod_doc;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public String getNom_doc() {
		return nom_doc;
	}

	public void setNom_doc(String nom_doc) {
		this.nom_doc = nom_doc;
	}

	public String getDes_doc() {
		return des_doc;
	}

	public void setDes_doc(String des_doc) {
		this.des_doc = des_doc;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public InputStream getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(InputStream adjunto) {
		this.adjunto = adjunto;
	}
	
	public void setAdjunto(Blob adjunto){
		if(adjunto != null)
			try {
				this.adjunto = adjunto.getBinaryStream();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else
			this.adjunto = null;
	}
	
}
