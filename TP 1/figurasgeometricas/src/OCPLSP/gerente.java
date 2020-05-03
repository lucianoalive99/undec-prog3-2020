package OCPLSP;

public class gerente extends empleado{

	public gerente(String nombre, double sueldo, double bono) {
		super(nombre, sueldo, bono);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcularBono() {
		bono = sueldo *15;
	}

}
