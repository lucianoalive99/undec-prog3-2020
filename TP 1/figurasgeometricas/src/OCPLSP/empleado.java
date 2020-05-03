package OCPLSP;

public abstract class empleado {
	public String nombre;
	public double sueldo;
	public double bono;

	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public double getBono() {
		return bono;
	}
	public void setBono(double bono) {
		this.bono = bono;
	}
	
	public empleado(String nombre, double sueldo, double bono) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.bono = bono;
	}

	public abstract void calcularBono();
}


