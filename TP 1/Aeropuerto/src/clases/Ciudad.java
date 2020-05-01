package clases;

public class Ciudad {
	
	
	Integer idCiudad;
	String nombre;
	String codigoPostal;
	
	
	public Integer getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
	public Ciudad(Integer idCiudad, String nombre, String codigoPostal) {
		super();
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
	}
	
	public Ciudad() {
		// TODO Apéndice de constructor generado automáticamente
	}
	public String devolverCiudad() {
		return getNombre();
	}

}
