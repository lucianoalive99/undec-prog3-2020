package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import clases.Aerolinea;
import clases.Aeropuerto;
import clases.Avion;
import clases.Ciudad;
import clases.Vuelo;

class VueloTest {

	@Test
	void ShowDetails_ReturnsRightFormat() {

		Vuelo aFlight = makeAFlight();

		String output = aFlight.getDetails();

		String expected = "Vuelo AR2443 - Embraer ERJ-190-100AR\r\n"
				+ "Martes 10 de abril 21:10 IRJ (La Rioja - Aeropuerto Capitán Vicente Almandos Almonacid)\r\n"
				+ "Martes 10 de abril 22:45 AEP (Buenos Aires - Aeropuerto Buenos Aires Jorge Newbery)\r\n"
				+ "Operado por Austral. Duración 1h 35m";

		assertEquals(expected, output);

	}

	// Para este test, se requiere crear una Interface que provea la funcionalidad
	// de dar la fecha en Español. La clase Vuelo debe implementar esa interface
	// El método "fechaHoraSpanish" no es un método "normal" de la clase Vuelo, sino
	// la implementación de un método de interface
	@Test
	void fechaHoraSpanish_LocalDateTimeValue_ReturnsFormatted() {
		LocalDateTime departureDateTime = LocalDateTime.of(2018, 06, 07, 13, 10);
		Vuelo aFlight = new Vuelo("", null, departureDateTime, null, null, null, null, null, null);

		String dateFormatted = aFlight.fechaHoraSpanish(departureDateTime);

		assertEquals("Jueves 7 de junio 13:10", dateFormatted);

	}

	// @Test
	// public void FlightHoursPilot_RequestSum_ReturnSum() {
	//
	// final PilotoEntity aPilot = makeAPilotWithFlights();
	// final Integer hours = aPilot.getTotalHours();
	//
	// assertEquals(Integer.valueOf(13), hours);
	// }
	//
	// @Test
	// public void FlightHoursPilot_NoFlights_ReturnZero() {
	//
	// final PilotoEntity aPilot = makeAPilot();
	// final Integer hours = aPilot.getTotalHours();
	//
	// assertEquals(Integer.valueOf(0), hours);
	// }
	//
	/*---------Factories---------------*/

	private Vuelo makeAFlight() {

		Ciudad laRioja = new Ciudad(1, "La Rioja", "5300");
		Ciudad buenosAires = new Ciudad(2, "Buenos Aires", "1000");
		Aeropuerto origin = new Aeropuerto(1, "Aeropuerto Capitán Vicente Almandos Almonacid", "IRJ", laRioja);
		Aeropuerto destination = new Aeropuerto(2, "Aeropuerto Buenos Aires Jorge Newbery", "AEP", buenosAires);
		Aerolinea austral = new Aerolinea(1, "Austral");

		Avion embraer = new Avion(4, "Embraer ERJ-190-100AR", "LV-CIH", null);

		final Vuelo aFlight = new Vuelo("AR2443", origin, LocalDateTime.of(2018, 04, 10, 21, 10), destination,
				LocalDateTime.of(2018, 04, 10, 22, 45), austral, null, embraer, null);

		return aFlight;
	}

}
