package SRP;
/* SE LE SOLICITA CALCULAR EL AREA Y EL PERIMETRO DE UN RECTANGULO 
 CON LOS LADOS CAPTURADOS POR LA MAQUINA*/
public class rectangulo {
    
	private double base;
    private double altura;

    public rectangulo(double base, double altura) {
        
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



	public double perimetro() {
        return 2.0*(this.base + this.altura);
    }

    public double area() {
       return base * altura;
    }

}
