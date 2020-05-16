package clases;

public class Avion {
    private String matricula;
    private String modelo;
    private int capacidad;
    private int añoFabricacion;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setAñoFabricacion(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public Avion(String matricula, String modelo, int capacidad, int añoFabricacion) throws NullPointerException{


        if(matricula == null) {
            throw new NullPointerException("El ID del avion no puede ser nulo");
        }else {
                        this.matricula = matricula;
                        this.modelo = modelo;
                        this.capacidad = capacidad;
                        this.añoFabricacion = añoFabricacion;

                    }
    }

}
