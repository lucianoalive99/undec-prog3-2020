package clases;

import exepciones.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Piloto {
    private String CUIL;
    private int legajo;
    private String apellido;
    private String nombre;
    private Date fechaNacimiento;


    public String getCUIL() {
        return CUIL;
    }

    public void setCUIL(String CUIL) {
        if (!validaCUIL(CUIL)) {
            System.out.println("El CUIL no respeta el formato 11-11111111-1.");
        } else {
            this.CUIL = CUIL;
        }
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (!validaNombreApellido(apellido)) {
            System.out.println("El apellido no cumple con el formato Abbbbbb.");
        } else {
            this.apellido = apellido;
            System.out.println("Se modifico exitosamente el nombre.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!validaNombreApellido(nombre)) {
            System.out.println("El nombre no cumple con el formato Abbbbbb.");
        } else {
            this.nombre=nombre;
            System.out.println("Se modifico exitosamente el apellido.");
        }
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public Piloto(String pCUIL, int pLegajo, String pApellido, String pNombre, Date pFechaNacimiento ) throws
            StringNuloException, EnteroNegativoException, FechaNulaException, CuilIncorrectoException,
            NombreApellidoFormatoIncorrectoException, ParseException {

        if (pCUIL == null) {
            throw new NullPointerException("El CUIL del piloto no puede ser nulo.");
        } else {
            if(pCUIL.equals("")){
                throw new CuilIncorrectoException("El CUIL del piloto no puede ser vacio.");
            }else {
                if(pLegajo <= 0){
                    throw new EnteroNegativoException("El legajo del Piloto no puede ser 0 o menor que 0");
                } else {

                    if(pApellido ==null || pApellido.isEmpty()){
                        throw new StringNuloException("El apellido del piloto no puede ser nulo/vacio.");
                    }
                    else{
                        if(!validaNombreApellido(pApellido)){
                            throw new NombreApellidoFormatoIncorrectoException("El apellido no cumple con el formato Abbbbbb.");
                        }else{
                            if(pNombre == null || pNombre.isEmpty()){
                                throw new StringNuloException("El nombre del piloto no puede ser vacio/nulo");
                            } else{
                                if(!validaNombreApellido(pNombre)){
                                    throw new NombreApellidoFormatoIncorrectoException("El Nombre no cumple con el formato Abbbbbb.");
                                }else {
                                    if(pFechaNacimiento==null){
                                        throw new FechaNulaException("La fecha de nacimiento no puede ser nula.");
                                    } else{
                                        if(!validaCUIL(pCUIL)){
                                            throw new CuilIncorrectoException("El CUIL no respeta el formato 11-11111111-1");
                                        }else{
                                            this.CUIL = pCUIL;
                                            this.legajo = pLegajo;
                                            this.apellido = pApellido;
                                            this.nombre = pNombre;
                                            this.fechaNacimiento = pFechaNacimiento;
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean validaCUIL(String matri) {

        return matri.matches("^([0-9]{2}[-][0-9]{8}[-][0-9])$");
    }

    public static boolean validaNombreApellido(String texto) {

        return texto.matches("^([A-Z]{1}[a-z]+[ ]?){1,3}$");
    }

}