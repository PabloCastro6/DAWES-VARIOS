package dtos;

public class EstadoFacturacionDTO {
	
	private Integer ID;
	private String estado;
	
	
	public EstadoFacturacionDTO(String iD, String estado) {
		super();
		this.ID = ID;
		this.estado = estado;
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	
}
