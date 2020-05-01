package clases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Vuelo {
	
	
	private String codigoVuelo;
	private Aeropuerto salida;
	private LocalDateTime fechaHoraSalida;
	private Aeropuerto arribo;
	private LocalDateTime fechaHoraArribo;
	private Aerolinea aerolinea;
	private List<Piloto> pilotos;
	private Avion avion;
	private List<Asignacion> pasajeros;
	
	
	
	public String getCodigoVuelo() {
		return codigoVuelo;
	}
	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}
	public Aeropuerto getSalida() {
		return salida;
	}
	public void setSalida(Aeropuerto salida) {
		this.salida = salida;
	}
	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}
	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
	public Aeropuerto getArribo() {
		return arribo;
	}
	public void setArribo(Aeropuerto arribo) {
		this.arribo = arribo;
	}
	public LocalDateTime getFechaHoraArribo() {
		return fechaHoraArribo;
	}
	public void setFechaHoraArribo(LocalDateTime fechaHoraArribo) {
		this.fechaHoraArribo = fechaHoraArribo;
	}
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	public List<Piloto> getPilotos() {
		return pilotos;
	}
	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public List<Asignacion> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(List<Asignacion> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	
	
	public Vuelo(String codigoVuelo, Aeropuerto salida, LocalDateTime fechaHoraSalida, Aeropuerto arribo,
			LocalDateTime fechaHoraArribo, Aerolinea aerolinea, List<Piloto> pilotos, Avion avion,
			List<Asignacion> pasajeros) {
		this.codigoVuelo = codigoVuelo;
		this.salida = salida;
		this.fechaHoraSalida = fechaHoraSalida;
		this.arribo = arribo;
		this.fechaHoraArribo = fechaHoraArribo;
		this.aerolinea = aerolinea;
		this.pilotos = pilotos;
		this.avion = avion;
		this.pasajeros = pasajeros;
	}
	
	public long duracionDeVueloHoras() {
		
		
    
		LocalDateTime d1 = LocalDateTime.of(fechaHoraSalida.getYear(), fechaHoraSalida.getMonth(), fechaHoraSalida.getDayOfMonth(), fechaHoraSalida.getHour(), fechaHoraSalida.getMinute());
		LocalDateTime d2 = LocalDateTime.of(fechaHoraArribo.getYear(), fechaHoraArribo.getMonth(), fechaHoraArribo.getDayOfMonth(), fechaHoraArribo.getHour(), fechaHoraArribo.getMinute());

		long horas = ChronoUnit.HOURS.between(d1, d2);
		//long minutos = ChronoUnit.MINUTES.between(d1, d2);
		return horas;
	}
	
	public String duracionDeVueloMinutos() {
		
		String formato = "%02dh:%02dm";
		LocalDateTime d1 = LocalDateTime.of(fechaHoraSalida.getYear(), fechaHoraSalida.getMonth(), fechaHoraSalida.getDayOfMonth(), fechaHoraSalida.getHour(), fechaHoraSalida.getMinute());
		LocalDateTime d2 = LocalDateTime.of(fechaHoraArribo.getYear(), fechaHoraArribo.getMonth(), fechaHoraArribo.getDayOfMonth(), fechaHoraArribo.getHour(), fechaHoraArribo.getMinute());

		//long horas = ChronoUnit.HOURS.between(d1, d2);
		long minutos = ChronoUnit.MINUTES.between(d1, d2);
		
		long horasReales = TimeUnit.MINUTES.toHours(minutos);
	    long minutosReales = TimeUnit.MINUTES.toMinutes(minutos) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(minutos));
	    avion.acumularhorasdevuelo(horasReales*60);
	    avion.acumularhorasdevuelo(minutosReales);
	    
	    
	    
	    
	    return String.format(formato, horasReales, minutosReales);
	}
	
	/*public String formatearMinutosAHoraMinuto(int minutos) {
	    String formato = "%02d:%02d";
	    long horasReales = TimeUnit.MINUTES.toHours(minutos);
	    long minutosReales = TimeUnit.MINUTES.toMinutes(minutos) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(minutos));
	    return String.format(formato, horasReales, minutosReales);
	}*/
	
	public String devolverVuelo() {
		
		return getCodigoVuelo() + " - " + avion.getModelo() + 
				" - " + fechaHoraSalida.getDayOfMonth() + 
				" de " + fechaHoraSalida.getMonth() + 
				" " + fechaHoraSalida.getHour() +
				":" + fechaHoraSalida.getMinute() + 
				" " + salida.mostrarCodigoAeropuerto() +
				" (" + salida.ciudad.devolverCiudad() + " - " + salida.mostrarNombreAeropuerto() + ") " + 
				" - " + fechaHoraArribo.getDayOfMonth() + 
				" de " + fechaHoraArribo.getMonth() + 
				" " + fechaHoraArribo.getHour() +
				":" + fechaHoraArribo.getMinute() + 
				" " + arribo.mostrarCodigoAeropuerto() +
				" (" + arribo.ciudad.devolverCiudad() + " - " + arribo.mostrarNombreAeropuerto() + ") " +
				" - Operado por " + aerolinea.devolverAerolinea()  +
				" Duración " + duracionDeVueloMinutos();
		
	}
	
	public void devolverListaDeAsignaciones() {
		boolean señal = false;
		System.out.println("Detalle de Asignaciones - Vuelo " + getCodigoVuelo());
		for(Asiento	asientoVuelo : avion.getListaAsiento()) {
			for(Asignacion pasajero : pasajeros) {
				if(asientoVuelo.getIdAsiento() == pasajero.getAsiento().getIdAsiento()) {
					señal = true;
					System.out.println( "Asiento " + asientoVuelo.getNumeroAsiento() + " - Ocupado. ");
					break;
				}
				else
				{
					señal = false;
				}
				
			}
			if(señal == false) {
				System.out.println("Asiento " + asientoVuelo.getNumeroAsiento() + " - Libre.");
				
			}
		}
	}
	
	
	public void pilotosMayoresA40() {
		
		/*DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(getPilotos(), fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		System.out.printf("Tu edad es: %s años, %s meses y %s días",
		                    periodo.getYears(), periodo.getMonths(), periodo.getDays());*/
	

		boolean señal = false;
		System.out.println("Detalle de Pilotos mayoes a 40 años:");
		for(Piloto	pilotoVuelo : getPilotos()) {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = pilotoVuelo.getFechaNacimiento();
			LocalDate ahora = LocalDate.now();

			Period periodo = Period.between(fechaNac, ahora);
			if (periodo.getYears() > 40) {
				System.out.printf("Tu edad es: %s años",
			                    periodo.getYears());
			}
			//for(Asignacion pasajero : pasajeros) {
				/*if(pilotoVuelo.getFechaNacimiento()) {
					señal = true;
					System.out.println( "Asiento " + asientoVuelo.getNumeroAsiento() + " - Ocupado. ");
					break;
				}
				else
				{
					señal = false;
				}
				
			//}
			if(señal == false) {
				System.out.println("Asiento " + asientoVuelo.getNumeroAsiento() + " - Libre.");
				
			}*/
		}
	}
}
