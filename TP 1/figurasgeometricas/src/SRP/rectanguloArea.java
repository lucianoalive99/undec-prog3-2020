package SRP;
/* SE LE SOLICITA CALCULAR EL AREAb DE UN RECTANGULO 
 CON LOS LADOS CAPTURADOS POR LA MAQUINA*/
public class rectanguloArea {
    
	private double base;
    private double altura;

    public rectanguloArea(double base, double altura) {
        
        this.base = base;
        this.altura = altura;
        
    }
    
    

    public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}


    public double area() {
       return base * altura;
    }

}
