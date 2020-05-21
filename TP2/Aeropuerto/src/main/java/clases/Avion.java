package clases;

import exepciones.FechaIncorrectaException;
import exepciones.MatriculaIncorrectaException;
import exepciones.StringNuloException;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Avion{
    private String matricula;
    private String modelo;
    private int capacidad;
    private int anioFabricacion;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setAnioFabricacion(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public Avion(String matricula, String modelo, int capacidad, int anioFabricacion) throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException {
        String salida = "";
        Calendar fecha = Calendar.getInstance();
        int anioActual = fecha.get(Calendar.YEAR);

        if (matricula == null) {
            throw new NullPointerException("El ID del avion no puede ser nulo.");
        } else {
            if(matricula.isEmpty()){
                throw new StringNuloException("El ID del avion no puede ser vacio.");
            }else {
                if(modelo == null || modelo.equals("")){
                    throw new StringNuloException("El modelo del Avion no puede ser nulo/vacio.");
                } else {

                    if(anioFabricacion <= 1950 || anioFabricacion > anioActual){
                        throw new FechaIncorrectaException("El año de fabricacion Ingrsado es incorrecto.");
                    }
                    else{
                        System.out.println(validaMatricula(matricula));
                        if(!validaMatricula(matricula)){
                            throw new MatriculaIncorrectaException("La matricula Ingresada no cumple con el formato AA-AAA.");
                        }
                        else {
                            this.matricula = matricula;
                            this.modelo = modelo;
                            this.capacidad = capacidad;
                            this.anioFabricacion = anioFabricacion;
                        }

                    }
                }

            }


        }

    }

    public static boolean validaMatricula(String matri) {

        return matri.matches("^([A-Z]{2}[-][A-Z]{3})$");
    }


}