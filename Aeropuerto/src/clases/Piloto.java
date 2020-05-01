package clases;

import java.time.LocalDate;
import java.time.Period;

public class Piloto {
	
	private Integer idPiloto;
	private String apellido;
	private String nombres;
	private String documento;
	private LocalDate fechaNacimiento;
	private int acumuladorHoras = 0;
	
	
	public Integer getIdPiloto() {
		return idPiloto;
	}
	public void setIdPiloto(Integer idPiloto) {
		this.idPiloto = idPiloto;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void acumularHorasDeVueloDelPiloto (int hvPiloto) {
		this.acumuladorHoras+= hvPiloto;
		
	}
	
	public int getHoraVueloPiloto() {
		return acumuladorHoras / 60;
	}
	
	public Piloto(Integer idPiloto, String apellido, String nombres, String documento, LocalDate fechaNacimiento) {
		super();
		this.idPiloto = idPiloto;
		this.apellido = apellido;
		this.nombres = nombres;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSurnameAndName() {
		// TODO Apéndice de método generado automáticamente
		return getApellido() + ", " + getNombres();
	}
	public int getAge(LocalDate of) {
		// TODO Apéndice de método generado automáticamente
		
		Period periodo = Period.between(getFechaNacimiento(), of);
		return periodo.getYears();
	}
	
	
	
}
	
	
