package OCPLSP;

public class programador extends empleado {

	public programador(String nombre, double sueldo, double bono) {
		super(nombre, sueldo, bono);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcularBono() {
		bono = sueldo *2;
		
	}

}
