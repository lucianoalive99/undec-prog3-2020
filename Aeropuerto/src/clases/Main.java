package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gestores.GestorAvion;
import gestores.GestorCiudad;

import java.util.Collections;


public class Main {
	private List<Aeropuerto> nuevosAeropuertos = new ArrayList<Aeropuerto>();
	
	//public static void CargarNuevoAeropuerto() {
	public static void main(String[] args) {
		GestorCiudad gestorCiudad = new GestorCiudad();
		GestorAvion gestoravion = new GestorAvion();
		int numeroCiudades;
		List<Asiento> asientoAvion1 = new ArrayList<Asiento>();
		List<Asiento> asientoAvion2 = new ArrayList<Asiento>();
		List<Asiento> asientoAvion3 = new ArrayList<Asiento>();
		List<Asiento> asientoAvion4 = new ArrayList<Asiento>();
		List<Piloto> piloto2443 = new ArrayList<Piloto>();
		List<Asignacion> pasajeros2443 = new ArrayList<Asignacion>();
		List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
		List<Aeropuerto> listaAeropuertos = new ArrayList<Aeropuerto>();
		List<Piloto> listaDePilotos = new ArrayList<Piloto>();
		List<Piloto> pilotosMayoresA40 = new ArrayList<Piloto>();
		List<Avion> horasDeVueloPorAvion = new ArrayList<Avion>();
		
		//GestorCiudad gestorCiudad = new GestorCiudad();
		//CARGA DE DATOS PARA PRUEBA
			//CARGA DE LAS CIUDADES
		//Ciudad ciudad1 = new Ciudad(1,"La Rioja","5360");
		gestorCiudad.crearCiudad(1,"La Rioja","5360");
		gestorCiudad.crearCiudad(2,"Buenos Aires","1000");
		gestorCiudad.crearCiudad(2,"Buenos Aires","1000");
		System.out.println(gestorCiudad.mostrarCiudades());
		Ciudad ciudad2 = new Ciudad(2,"Buenos Aires","1000");
		Ciudad ciudad3 = new Ciudad(3,"Mendoza","5500");
		Ciudad ciudad4 = new Ciudad(4,"Tucumán","4000");
			//CARGA DE LAS CIUDADES EN UNA LISTA
		//listaCiudades.add();
		listaCiudades.add(ciudad2);
		listaCiudades.add(ciudad3);
		listaCiudades.add(ciudad4);
			//CARGA DE LOS AEROPUERTOS
		//Aeropuerto aeropuerto1 = new Aeropuerto(1,"Aeropuerto Capitán Vicente Almandos Amonacid",ciudad1,"IRJ");
		Aeropuerto aeropuerto2 = new Aeropuerto(2,"Aeropuerto Buenos Aires Jorge Newbery",ciudad2,"AEP");
		Aeropuerto aeropuerto3 = new Aeropuerto(2,"Aeropuerto El Plumerillo",ciudad3,"MDZ");
		Aeropuerto aeropuerto4 = new Aeropuerto(2,"Aeropuerto Benjamín Matienzo",ciudad4,"TUC");
			//CARGA LISTA DE AEROPUERTOS
		//listaAeropuertos.add(aeropuerto1);
		listaAeropuertos.add(aeropuerto2);
		listaAeropuertos.add(aeropuerto3);
		listaAeropuertos.add(aeropuerto4);
			//CARGA DE LOS PASAJEROS
		Pasajero pasajero1 = new Pasajero(1,"20123456784","Ramírez","Ramiro Ramón","12345678");
		Pasajero pasajero2 = new Pasajero(2,"20102030404","Fernández","Fernando Fermín","10203040");
		Pasajero pasajero3 = new Pasajero(3,"20987654324","Martínez","Martín Marcos","98765432");
		Pasajero pasajero4 = new Pasajero(4,"20198273644","Rodríguez","Rodrigo Rogelio","19827364");
			
			//CARGA DE LAS AEROLINEAS
		Aerolinea aerolinea1 = new Aerolinea(1,"Aerolíneas Argentinas");
		Aerolinea aerolinea2 = new Aerolinea(2,"Austral");
		Aerolinea aerolinea3 = new Aerolinea(3,"LATAM");
		Aerolinea aerolinea4 = new Aerolinea(4,"Iberia");
			//CARGA DE LOS PILOTOS
		Piloto piloto1 = new Piloto(1,"Pérez","Juan Antonio","07071970",LocalDate.of(1970, 7, 7));
		Piloto piloto2 = new Piloto(2,"Martínez","Juan Ignacio","08081978",LocalDate.of(1950, 8, 8));
		Piloto piloto3 = new Piloto(3,"López","Juan Carlos","05051950",LocalDate.of(1950, 5, 5));
		Piloto piloto4 = new Piloto(4,"Gómez","Juan Gabriel","10101960", LocalDate.of(1960, 10, 10));
			//ASIGANCION DE PILOTOS A LISTA
		piloto2443.add(piloto1);
		piloto2443.add(piloto2);
		listaDePilotos.add(piloto1);
		listaDePilotos.add(piloto2);
		listaDePilotos.add(piloto3);
		listaDePilotos.add(piloto4);
			//CARGA DE ASIENTOS
		Asiento asiento1 = new Asiento(1,"A1");
		Asiento asiento2 = new Asiento(2,"B1");
		Asiento asiento3 = new Asiento(3,"C1");
		Asiento asiento4 = new Asiento(4,"H1");
		Asiento asiento5 = new Asiento(5,"J1");
		Asiento asiento6 = new Asiento(6,"K1");
		Asiento asiento7 = new Asiento(7,"A2");
		Asiento asiento8 = new Asiento(8,"B2");
		Asiento asiento9 = new Asiento(9,"C2");
		Asiento asiento10 = new Asiento(10,"H2");
		Asiento asiento11 = new Asiento(11,"J2");
		Asiento asiento12 = new Asiento(12,"K2");
		Asiento asiento13 = new Asiento(13,"A1");
		Asiento asiento14 = new Asiento(14,"B1");
		Asiento asiento15 = new Asiento(15,"C1");
		Asiento asiento16 = new Asiento(16,"H1");
		Asiento asiento17 = new Asiento(17,"J1");
		Asiento asiento18 = new Asiento(18,"K1");
		Asiento asiento19 = new Asiento(19,"A2");
		Asiento asiento20 = new Asiento(20,"B2");
		Asiento asiento21 = new Asiento(21,"C2");
		Asiento asiento22 = new Asiento(22,"H2");
		Asiento asiento23 = new Asiento(23,"J2");
		Asiento asiento24 = new Asiento(24,"K2");
		Asiento asiento25 = new Asiento(25,"A1");
		Asiento asiento26 = new Asiento(26,"C1");
		Asiento asiento27 = new Asiento(27,"D1");
		Asiento asiento28 = new Asiento(28,"E1");
		Asiento asiento29 = new Asiento(29,"G1");
		Asiento asiento30 = new Asiento(30,"H1");
		Asiento asiento31 = new Asiento(31,"K1");
		Asiento asiento32 = new Asiento(32,"A2");
		Asiento asiento33 = new Asiento(33,"C2");
		Asiento asiento34 = new Asiento(34,"D2");
		Asiento asiento35 = new Asiento(35,"E2");
		Asiento asiento36 = new Asiento(36,"G2");
		Asiento asiento37 = new Asiento(37,"H2");
		Asiento asiento38 = new Asiento(38,"K2");
		Asiento asiento39 = new Asiento(39,"A1");
		Asiento asiento40 = new Asiento(40,"H1");
		Asiento asiento41 = new Asiento(41,"K1");
		Asiento asiento42 = new Asiento(42,"A2");
		Asiento asiento43 = new Asiento(43,"H2");
		Asiento asiento44 = new Asiento(44,"K2");
			//CARGA DE LISTAS CON ASIENTOS POR AVION
			//AVION 1
		asientoAvion1.add(asiento1);
		asientoAvion1.add(asiento2);
		asientoAvion1.add(asiento3);
		asientoAvion1.add(asiento4);
		asientoAvion1.add(asiento5);
		asientoAvion1.add(asiento6);
		asientoAvion1.add(asiento7);
		asientoAvion1.add(asiento8);
		asientoAvion1.add(asiento9);
		asientoAvion1.add(asiento10);
		asientoAvion1.add(asiento11);
		asientoAvion1.add(asiento12);
			//AVION 2
		asientoAvion2.add(asiento13);
		asientoAvion2.add(asiento14);
		asientoAvion2.add(asiento15);
		asientoAvion2.add(asiento16);
		asientoAvion2.add(asiento17);
		asientoAvion2.add(asiento18);
		asientoAvion2.add(asiento19);
		asientoAvion2.add(asiento20);
		asientoAvion2.add(asiento21);
		asientoAvion2.add(asiento22);
		asientoAvion2.add(asiento23);
		asientoAvion2.add(asiento24);
			//AVION 3
		asientoAvion3.add(asiento25);
		asientoAvion3.add(asiento26);
		asientoAvion3.add(asiento27);
		asientoAvion3.add(asiento28);
		asientoAvion3.add(asiento29);
		asientoAvion3.add(asiento30);
		asientoAvion3.add(asiento31);
		asientoAvion3.add(asiento32);
		asientoAvion3.add(asiento33);
		asientoAvion3.add(asiento34);
		asientoAvion3.add(asiento35);
		asientoAvion3.add(asiento36);
		asientoAvion3.add(asiento37);
		asientoAvion3.add(asiento38);
			//AVION 4
		asientoAvion4.add(asiento39);
		asientoAvion4.add(asiento40);
		asientoAvion4.add(asiento41);
		asientoAvion4.add(asiento42);
		asientoAvion4.add(asiento43);
		asientoAvion4.add(asiento44);
		
				
			//CARGA DE AVIONES
		Avion avion1 = new Avion(1,"Airbus A340-313X","LV-FPV",asientoAvion1);
		Avion avion2 = new Avion(2,"Airbus A330-223","LV-FNI",asientoAvion2);
		Avion avion3 = new Avion(3,"Boeing 737-8MB","LV-FYK",asientoAvion3);
		Avion avion4 = new Avion(4,"Embraer ERJ-190-100AR","LV-CIH",asientoAvion4);
		
		gestoravion.crearAvion(avion1);
		gestoravion.crearAvion(avion1);
		gestoravion.crearAvion(avion2);
		gestoravion.crearAvion(avion2);
		gestoravion.crearAvion(avion3);
		gestoravion.crearAvion(avion3);
		gestoravion.crearAvion(avion4);
		gestoravion.crearAvion(avion4);
		
		
			//ASIGNACION DE LOS PASAJEROS
		Asignacion asignacion1 = new Asignacion(pasajero1,asientoAvion4.set(1, asiento43),"AR2443100420182012345678443");
		Asignacion asignacion2 = new Asignacion(pasajero4,asientoAvion4.set(2, asiento41),"AR2443100420182019827364441");
			//CARGA DE LAS ASIGNACIONES
		pasajeros2443.add(asignacion1);
		pasajeros2443.add(asignacion2);
			//CARGA DE VUELOS
		//Vuelo vuelo1 = new Vuelo("AR2443",aeropuerto1,LocalDateTime.of(2018, 04, 10, 21, 10),aeropuerto2,LocalDateTime.of(2018, 04, 10, 22, 45),aerolinea2,piloto2443,avion4,pasajeros2443);
		
		
			//MUESTRA DE LAS CIUDADES
		numeroCiudades = listaCiudades.size();
		System.out.println(numeroCiudades);
		for(Ciudad ciu : listaCiudades) {
			System.out.println(ciu.devolverCiudad());
		}
		
			//MUESTRA DE LOS AEROPUERTOS
		int numeroAeropuerto = listaAeropuertos.size();
		System.out.println(numeroAeropuerto);
		for(Aeropuerto aero : listaAeropuertos) {
			System.out.println(aero.mostrarAeropuertos());
		}
		
			//DEVOLVER VUELO
		
		//System.out.println(vuelo1.devolverVuelo());
		//System.out.println(vuelo1.duracionDeVueloMinutos());


			// pilotos mayores a 40
		//vuelo1.pilotosMayoresA40();
		System.out.println("Detalle de Pilotos mayoes a 40 años:");
		for(Piloto	pilotoVuelo : listaDePilotos) {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = pilotoVuelo.getFechaNacimiento();
			LocalDate ahora = LocalDate.now();

			Period periodo = Period.between(fechaNac, ahora);
			if (periodo.getYears() > 40) {
				pilotosMayoresA40.add(pilotoVuelo);
				}
			}
		
		//Collections.sort(pilotosMayoresA40, new OrdenarPilotosPorEdad());
		Collections.sort(pilotosMayoresA40, new OrdenarPilotosPorEdad());
		for(Piloto pilotos : pilotosMayoresA40) {
			LocalDate fechaNac = pilotos.getFechaNacimiento();
			LocalDate ahora = LocalDate.now();

			Period periodo = Period.between(fechaNac, ahora);
			
			System.out.println(pilotos.getApellido()+","+ pilotos.getNombres() + " - " + periodo.getYears());
		}
		
		// HORA DE VUELOS DE LOS AVIONES
		/*horasDeVueloPorAvion.add(avion1);
		horasDeVueloPorAvion.add(avion2);
		horasDeVueloPorAvion.add(avion3);
		horasDeVueloPorAvion.add(avion4);*/
		Collections.sort(horasDeVueloPorAvion, new compararHorasDeVuelo());
		for(Avion avion : horasDeVueloPorAvion){
			System.out.println(avion.getModelo() + " (" + avion.getMatricula() +") - "+avion.devolverHoraDeVuelo() + " Hs. de Vuelo");
			
		}
		
		Collections.sort(listaDePilotos, new compararHorasDeVueloPorPilotos());
		for(Piloto PilotoOrdenado : listaDePilotos) {
			LocalDate fechaNac = PilotoOrdenado.getFechaNacimiento();
			LocalDate ahora = LocalDate.now();

			Period periodo = Period.between(fechaNac, ahora);
			System.out.println(PilotoOrdenado.getApellido()+", "+ PilotoOrdenado.getNombres() + " - " + periodo.getYears() + " Años - " + PilotoOrdenado.getHoraVueloPiloto() + " Hs. de Vuelo" );
		}
		
		/*gestorCiudad.crearCiudad(1,"La Rioja","5300");
		gestorCiudad.crearCiudad(2,"Chilecito","5360");
		gestorCiudad.mostrarCiudades();*/
		
		//System.out.println(gestorCiudad.listaCiudades);
	}
		
}
