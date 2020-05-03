package OCP;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import SRP.rectanguloArea;
import SRP.rectanguloPerimetro;

public class testOCP {

	@Test
	void creacionprogamador() {
		String nombre = "Jose Mercado";
		double sueldo= 800;
		
		programador prog = new programador(nombre, sueldo,0);
		
		assertEquals(nombre , prog.getNombre());
		assertEquals(sueldo, prog.getSueldo());	
	
}
	@Test
	void creaciongerente() {
		String nombre = "Antonio Franco";
		double sueldo= 1200;
		
		gerente gere = new gerente(nombre, sueldo,0);
		
		assertEquals(nombre , gere.getNombre());
		assertEquals(sueldo, gere.getSueldo());	
		
	
}
	
	@Test
	void calculoBonoProgramador() {
		String nombre = "Jose Mercado";
		double sueldo= 800;
		double bonoEsperado = 1600;
		
		programador prog = new programador(nombre, sueldo,0);
		
		prog.calcularBono();
		
		assertEquals(bonoEsperado, prog.getBono());
	}
	
	@Test
	void calculoBonoGerente() {
		String nombre = "Antonio Franco";
		double sueldo= 1200;
		double bonoEsperadogere = 18000;
		
		gerente gere = new gerente(nombre, sueldo,0);
		
		gere.calcularBono();
		
		
		assertEquals(bonoEsperadogere, gere.getBono());
	}
	
}