package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import clases.Piloto;

public class PilotoTest {

	@Test
	public void getSurnameAndName_FormatCriteria_ShowCorrectFormat() {
		final Piloto unPiloto = makeAPilot();
		final String pilotName = unPiloto.getSurnameAndName();
		assertEquals("Perez, Juan Antonio", pilotName);
	}

	@Test
	public void getAgeMethod_CalculateAgeMock_Return34() {
		final Piloto unPiloto = makeAPilot();
		final int pilotAge = unPiloto.getAge(LocalDate.of(2018, 4, 13));
		assertEquals(34, pilotAge);
	}

	private Piloto makeAPilot() {
		return new Piloto(1, "Perez", "Juan Antonio", "07071970", LocalDate.of(1984, 1, 31));
	}

}
