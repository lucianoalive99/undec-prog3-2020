package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import clases.Avion;
import clases.Vuelo;
import gestores.GestorAvion;

class GestorAvionTest {

	@Test
	void crearAvion_creacionCorrecta() {

		// Arrange
		GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
		int avionesEnColeccion = elGestor.getColeccionAviones().size();
		Avion unAvion = new Avion(1, "Airbus A340-313X", "LV-FPV", null);

		// Act
		elGestor.crearAvion(unAvion);
		int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();

		// Assert
		assertTrue((avionesEnColeccion + 1) == avionesLuegoDeCrear);

	}

	@Test
	void crearAvion_yaExisteAvionPorID() {

		// Arrange
		GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
		elGestor.getColeccionAviones().add(new Avion(1, "Airbus A340-313X", "LV-FPV", null));
		int avionesEnColeccion = elGestor.getColeccionAviones().size();
		Avion unAvion = new Avion(1, "Boeing 737-8MB", "LV-FYK", null);

		// Act
		boolean falsoCrearAvion = elGestor.crearAvion(unAvion);

		// Assert
		int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();
		assertFalse(falsoCrearAvion);
		assertTrue(avionesEnColeccion == avionesLuegoDeCrear);

	}

	@Test
	void crearAvion_yaExisteAvionPorMatricula_devuelveFalso() {

		// Arrange
		GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
		elGestor.getColeccionAviones().add(new Avion(1, "Airbus A340-313X", "LV-FPV", null));
		
		int avionesEnColeccion = elGestor.getColeccionAviones().size();
		Avion unAvion = new Avion(2, "Boeing 737-8MB", "LV-FPV", null);

		// Act
		boolean falsoCrearAvion = elGestor.crearAvion(unAvion);
		int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();

		// Assert
		assertFalse(falsoCrearAvion);
		assertTrue(avionesEnColeccion == avionesLuegoDeCrear);

	}

	@Test
	void horasVueloAvion_listaVuelos_devuelveSuma() {
		Avion avion1 = new Avion(1, "Airbus A340-313X", "LV-FPV", null);
		GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
		int horasVuelo = elGestor.horasVueloAvion(crearVuelos(), avion1);
		assertEquals(15, horasVuelo);

	}

	protected Collection<Vuelo> crearVuelos() {

		Avion avion1 = new Avion(1, "Airbus A340-313X", "LV-FPV", null);
		Avion avion2 = new Avion(2, "Airbus A330-233", "LV-FNI", null);

		Vuelo vuelo1 = new Vuelo("AR2443", null, LocalDateTime.of(2018, 04, 10, 21, 10), null,
				LocalDateTime.of(2018, 04, 10, 22, 45), null, null, avion1, null);
		Vuelo vuelo2 = new Vuelo("AR2444", null, LocalDateTime.of(2018, 04, 12, 8, 10), null,
				LocalDateTime.of(2018, 04, 12, 10, 45), null, null, avion1, null);
		Vuelo vuelo3 = new Vuelo("AR2445", null, LocalDateTime.of(2018, 04, 8, 11, 10), null,
				LocalDateTime.of(2018, 04, 8, 22, 45), null, null, avion1, null);
		Vuelo vuelo4 = new Vuelo("AR2446", null, LocalDateTime.of(2018, 04, 12, 8, 10), null,
				LocalDateTime.of(2018, 04, 12, 10, 45), null, null, avion2, null);

		LinkedList<Vuelo> vuelos = new LinkedList<Vuelo>();
		vuelos.add(vuelo1);
		vuelos.add(vuelo2);
		vuelos.add(vuelo3);
		vuelos.add(vuelo4);
		return vuelos;
	}

}
