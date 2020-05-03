package SRP;
/* SE LE SOLICITA CALCULAR EL perimetro DE UN RECTANGULO 
CON LOS LADOS CAPTURADOS POR LA MAQUINA*/
public class rectanguloPerimetro {

	private double base;
    private double altura;




	public rectanguloPerimetro(double base, double altura) {
        
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

}
