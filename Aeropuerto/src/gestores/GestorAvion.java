package gestores;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Collections;

import clases.Asiento;
import clases.Avion;
import clases.Ciudad;
import clases.Vuelo;

public class GestorAvion {

	private Collection<Avion> listaAviones = new LinkedList<Avion>();	
	private int iterador = 0;
	private boolean bandera = false;
	

	public GestorAvion(Collection<Avion> linkedList) {
		linkedList.addAll(listaAviones);
	}

	public GestorAvion() {
		
	}
	
	public boolean crearAvion(Avion pAvion) {
		
		for (Avion avion : listaAviones) {
			if(pAvion.getMatricula().equals(avion.getMatricula()) || pAvion.getIdAvion().equals(avion.getIdAvion()))
			{
				return false;
			}
		}
		listaAviones.add(pAvion);
		return true;
		
		/*//Avion nuevoavion = new Avion(pidAvion,pModelo, pMatricula, pListaAsiento);
		if(iterador == 0) {
			listaAviones.add(pAvion);
			return true;
			
		}
		//else
		//{
		 
			for (Avion aviones : listaAviones){
				
				if(aviones.getIdAvion() == pAvion.getIdAvion()) {
					return false;
				}
				else {
					
				
					if(aviones.getMatricula() == pAvion.getMatricula()) {
						return false;
					
					}
				}
			}
			/*}
			if (bandera == true) {
				bandera = false;
				return false;
				
				
			}
			//else {
					
				if(pAvion.getListaAsiento().isEmpty()) {
					return false;
					//return false;
						
				}
				else {
					listaAviones.add(pAvion);
					return true;
					//return true;
				}
					
				
			}
		//}
		//}
		
		//return false;*/
		
	}

	public Collection<Avion> getColeccionAviones() {
		return listaAviones;
	}

	public int horasVueloAvion(Collection<Vuelo> crearVuelos, Avion avion1) {
		
		for (Vuelo vuelos : crearVuelos) {
			if (vuelos.getAvion().getMatricula() == avion1.getMatricula()) {
				String formato = "%02dh:%02dm";
				LocalDateTime d1 = LocalDateTime.of(vuelos.getFechaHoraSalida().getYear(), vuelos.getFechaHoraSalida().getMonth(), vuelos.getFechaHoraSalida().getDayOfMonth(), vuelos.getFechaHoraSalida().getHour(), vuelos.getFechaHoraSalida().getMinute());
				LocalDateTime d2 = LocalDateTime.of(vuelos.getFechaHoraArribo().getYear(), vuelos.getFechaHoraArribo().getMonth(), vuelos.getFechaHoraArribo().getDayOfMonth(), vuelos.getFechaHoraArribo().getHour(), vuelos.getFechaHoraArribo().getMinute());
		
				//long horas = ChronoUnit.HOURS.between(d1, d2);
				long minutos = ChronoUnit.MINUTES.between(d1, d2);
				
				long horasReales = TimeUnit.MINUTES.toHours(minutos);
			    long minutosReales = TimeUnit.MINUTES.toMinutes(minutos) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(minutos));
			    avion1.acumularhorasdevuelo(horasReales*60);
			    avion1.acumularhorasdevuelo(minutosReales);
			}
		}
		
		return avion1.devolverHoraDeVuelo();
	}
		
	
}
