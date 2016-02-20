package dao.beans;

public class TipoDocumentoDTO {
	
	private int cod_tipo_doc;
	private String des_tipo_doc;
	
	public TipoDocumentoDTO(int cod_tipo_doc, String des_tipo_doc) {
		this.cod_tipo_doc = cod_tipo_doc;
		this.des_tipo_doc = des_tipo_doc;
	}

	public int getCod_tipo_doc() {
		return cod_tipo_doc;
	}

	public void setCod_tipo_doc(int cod_tipo_doc) {
		this.cod_tipo_doc = cod_tipo_doc;
	}

	public String getDes_tipo_doc() {
		return des_tipo_doc;
	}

	public void setDes_tipo_doc(String des_tipo_doc) {
		this.des_tipo_doc = des_tipo_doc;
	}
	

	
	
}
