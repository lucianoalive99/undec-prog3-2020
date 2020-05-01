package clases;

import java.util.Comparator;

public class compararHorasDeVuelo implements Comparator<Avion>{
		 @Override
		 public int compare(Avion avion1, Avion avion2) {
		    return (avion1.devolverHoraDeVuelo() - avion2.devolverHoraDeVuelo()); // Devuelve un entero positivo si la altura de o1 es mayor que la de o2
		 }
		
		
	}


