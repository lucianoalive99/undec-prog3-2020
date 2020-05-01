package clases;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class OrdenarPilotosPorEdad implements Comparator<Piloto> {
    @Override
    public int compare(Piloto p1, Piloto p2) {
    return (p1.getFechaNacimiento().getYear() - p2.getFechaNacimiento().getYear()); // Devuelve un entero positivo si la altura de o1 es mayor que la de o2
    }
}
/*public class DevolverEdad {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		

		// 01/01/2000
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse("13/04/1990", fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		System.out.printf("Tu edad es: %s años, %s meses y %s días",
		                    periodo.getYears(), periodo.getMonths(), periodo.getDays());
	}

}*/
