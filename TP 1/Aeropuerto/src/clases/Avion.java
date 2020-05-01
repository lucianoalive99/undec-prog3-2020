package clases;

import java.util.List;

public class Avion {
	
	
	private Integer idAvion;
	private String modelo;
	private String matricula;
	private List<Asiento> listaAsiento;
	private int acumuladorHorasDeVuelo = 0;
	
	
	
	public Integer getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(Integer idAvion) {
		this.idAvion = idAvion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public List<Asiento> getListaAsiento() {
		return listaAsiento;
	}
	public void setListaAsiento(List<Asiento> listaAsiento) {
		this.listaAsiento = listaAsiento;
	}
	
	
	public Avion(Integer idAvion, String modelo, String matricula, List<Asiento> listaAsiento) {
		this.idAvion = idAvion;
		this.modelo = modelo;
		this.matricula = matricula;
		this.listaAsiento = listaAsiento;
	}
	
	public void acumularhorasdevuelo(long horasdevuelo) {
		this.acumuladorHorasDeVuelo += horasdevuelo;
	}
	
	public int devolverHoraDeVuelo() {
		return acumuladorHorasDeVuelo/60;
	}

	
}
