package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import clases.Piloto;
import clases.Vuelo;
import gestores.GestorPiloto;

class GestorPilotosTest {

	@Test
	void horasVueloPiloto_listaVuelos_devuelveSuma() {
		Piloto piloto1 = new Piloto(1, "Perez", "Juan Antonio", "07071970", LocalDate.of(1984, 1, 31));
		GestorPilotos elGestor = new GestorPilotos(new LinkedList<Piloto>());
		int horasVuelo = elGestor.horasVueloPiloto(crearVuelos(), piloto1);
		assertEquals(15, horasVuelo);
	}

	protected Collection<Vuelo> crearVuelos() {

		Piloto piloto1 = new Piloto(1, "Perez", "Juan Antonio", "07071970", LocalDate.of(1984, 1, 31));
		Piloto piloto2 = new Piloto(2, "Lopez", "Juan Ramon", "12345678", LocalDate.of(1984, 11, 20));

		Collection<Piloto> tripulacion = new LinkedList<Piloto>();
		tripulacion.add(piloto1);
		tripulacion.add(piloto2);

		Vuelo vuelo1 = new Vuelo("AR2443", null, LocalDateTime.of(2018, 04, 10, 21, 10), null,
				LocalDateTime.of(2018, 04, 10, 22, 45), null, tripulacion, null, null);
		Vuelo vuelo2 = new Vuelo("AR2444", null, LocalDateTime.of(2018, 04, 12, 8, 10), null,
				LocalDateTime.of(2018, 04, 12, 10, 45), null, tripulacion, null, null);
		Vuelo vuelo3 = new Vuelo("AR2445", null, LocalDateTime.of(2018, 04, 8, 11, 10), null,
				LocalDateTime.of(2018, 04, 8, 22, 45), null, tripulacion, null, null);
		Vuelo vuelo4 = new Vuelo("AR2446", null, LocalDateTime.of(2018, 04, 12, 8, 10), null,
				LocalDateTime.of(2018, 04, 12, 10, 45), null, null, null, null);

		LinkedList<Vuelo> vuelos = new LinkedList<Vuelo>();
		vuelos.add(vuelo1);
		vuelos.add(vuelo2);
		vuelos.add(vuelo3);
		vuelos.add(vuelo4);
		return vuelos;
	}

}
