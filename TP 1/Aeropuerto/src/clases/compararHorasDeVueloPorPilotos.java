package clases;

import java.util.Comparator;

public class compararHorasDeVueloPorPilotos implements Comparator<Piloto> {

	 @Override
	 public int compare(Piloto p1, Piloto p2) {
	    return (p2.getHoraVueloPiloto() - p1.getHoraVueloPiloto()); // Devuelve un entero positivo si la altura de o1 es mayor que la de o2
	 }

}
