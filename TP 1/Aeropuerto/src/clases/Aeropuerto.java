package clases;

public class Aeropuerto {
	private Integer idAeropuerto;
	private String nombre;
	private Ciudad ciudad;
	private String codigo;
	
	
	public Integer getIdAeropuerto() {
		return idAeropuerto;
	}
	public void setIdAeropuerto(Integer idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public Aeropuerto(Integer idAeropuerto, String nombre, String codigo, Ciudad ciudad) {
		this.idAeropuerto = idAeropuerto;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.codigo = codigo;
	}
	
	public String mostrarAeropuertos() {
		return getNombre() + " - " + ciudad.devolverCiudad() + " - " + getCodigo();
	}
	
	public String mostrarCodigoAeropuerto() {
		return getCodigo();
	}
	
	public String mostrarNombreAeropuerto() {
		return getNombre();
	}
	
	public Ciudad mostrarCiudadAeropuerto() {
		return getCiudad();
	}
	public String showDenomination() {
		// TODO Apéndice de método generado automáticamente
		return getNombre() + " - " + ciudad.devolverCiudad() + " - " + getCodigo();
	}

}
