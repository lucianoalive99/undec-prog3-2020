package clases;

import com.sun.tracing.dtrace.ArgsAttributes;
import exepciones.*;

import java.util.Date;

public class Aerolinea {

    private String CUIT;
    private String CodigoIATA;
    private String Nombre;
    private Date FechaIA;

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getCodigoIATA() {
        return CodigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        CodigoIATA = codigoIATA;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFechaIA() {
        return FechaIA;
    }

    public void setFechaIA(Date fechaIA) {
        FechaIA = fechaIA;
    }


    public Aerolinea(String pCUIT, String pCodigoIATA, String pNombre, Date pFechaIA) throws
            NuloException, StringNuloException, FechaNulaException, NombreApellidoFormatoIncorrectoException, CodigoIATAException, CuilIncorrectoException {
        if(pCUIT == null){
            throw new NuloException("El CUIT no puede ser nulo.");
        }else{
            if(pCUIT.equals("")){
                throw new StringNuloException("El CUIT d la aerolinea no puede ser vacio.");
            }else{
                if(pCodigoIATA==null){
                    throw new NuloException("El codigo IATA no puede ser nulo.");
                }else {
                    if(pCodigoIATA.equals("")){
                        throw new StringNuloException("El cogido IATA no se puede ingresar vacio.");
                    }else{
                        if(pNombre == null){
                            throw new NuloException("El nombre de la aerolinea no puede ser nulo.");
                        } else {
                            if(pNombre.equals("")){
                                throw new StringNuloException("El nombre no se puede ingresar vacio.");
                            }else{
                                if(pFechaIA == null){
                                    throw new FechaNulaException("La fecha ingresada no puede ser nula.");
                                }else{
                                    if(!validaNombreApellido(pNombre)) {
                                        throw new NombreApellidoFormatoIncorrectoException("El nombre/apellido no cumple con el formato Abbbb.");
                                    }
                                    else {
                                        if(!validaCodidoIATA(pCodigoIATA)){
                                            throw new CodigoIATAException("El codigo IATA no cumple con el formato AA.");
                                        }else{
                                            if(!validaCUIT(pCUIT)){
                                                throw new CuilIncorrectoException("El CUIT ingresaso no cumple con el formato 11-11111111-1.");
                                            }else{
                                                this.CUIT = pCUIT;
                                                this.CodigoIATA = pCodigoIATA;
                                                this.Nombre = pNombre;
                                                this.FechaIA = pFechaIA;
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
    }
    public static boolean validaCUIT(String cuit) {

        return cuit.matches("^([0-9]{2}[-][0-9]{8}[-][0-9])$");
    }

    public static boolean validaNombreApellido(String texto) {

        return texto.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$");
    }
    public static boolean validaCodidoIATA(String iata){
        return iata.matches("^([A-Z]{2})$");
    }
