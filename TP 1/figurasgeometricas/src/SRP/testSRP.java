package SRP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class testSRP {
	
	@Test
	void creacionRectanguloArea() {
		double base= 12.50;
		double altura= 8.90;
		
		rectanguloArea rectangulo = new rectanguloArea(base, altura);
		
		assertEquals(base, rectangulo.getBase());
		assertEquals(altura,rectangulo.getAltura());	
	
}
	@Test
	void creacionRectanguloPerimetro() {
		double base= 12.50;
		double altura= 8.90;
		
		rectanguloPerimetro rectangulo = new rectanguloPerimetro(base, altura);
		
		assertEquals(base, rectangulo.getBase());
		assertEquals(altura,rectangulo.getAltura());	
	
}
	
	@Test
	void calculoRectanguloArea() {
		double areaEsperada=111.25;
		
		rectanguloArea rectangulo = new rectanguloArea(12.5,8.9);
		
		assertEquals(areaEsperada,rectangulo.area());
	}
	
	@Test
	void calculoPerimetro() {
		double perimetroEsperado=42.80;
		
		rectanguloPerimetro rectangulo = new rectanguloPerimetro(12.5,8.9);
		
		assertEquals(perimetroEsperado,rectangulo.perimetro());
	}
}
