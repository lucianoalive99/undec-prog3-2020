package OCPLSP;

import java.util.List;


public class empleadoServicio {

	public List<empleado> Empleados;

	
	public List<empleado> getEmpleados() {
		return Empleados;
	}

	public void setEmpleados(List<empleado> Empleados) {
		this.Empleados = Empleados;
	}

	public empleadoServicio(List<empleado> Empleados) {
		super();
		this.Empleados = Empleados;
	}
	
	//metodo para calcular el bono dependiendo del tipo de empleado
	
	public void calcularBono() {
		for(empleado emp : Empleados){
			emp.calcularBono();
		}
	}

}
