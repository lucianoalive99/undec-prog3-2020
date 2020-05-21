package clases;

import exepciones.*;

public class Aeropuerto {

    private String IATA;
    private String Nombre;
    private String Ciudad;
    private Integer CodigoPostal;

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        CodigoPostal = codigoPostal;
    }

    public Aeropuerto(String pIATA, String pNombre, String pCiudad, Integer pPostal) throws NuloException, StringNuloException, EnteroNegativoException, CodigoIATAException, NombreApellidoFormatoIncorrectoException {
        if(pIATA == null){
            throw new NuloException("El codigo IATA no puede ser nulo.");
        }else{
            if(pIATA.equals("")){
                throw new StringNuloException("El codigo IATA no puede ser vacio.");
            }else {
                if(pNombre==null || pNombre.equals("")){
                    throw  new NuloException("El nombre no puede ser nulo/vacio.");
                }else{
                    if(pCiudad==null||pCiudad.equals("")){
                        throw new NuloException("La ciudad no puede se nulo/vacio.");
                    }else{
                        if (pPostal == null || pPostal<=0){
                            throw new EnteroNegativoException("El codigo postal no puede ser Nulo/menor o igual a 0.");
                        }else {
                            if(!validaCodidoIATA(pIATA)){
                                throw new CodigoIATAException("El codigo IATA ingresado no cumple con el formato AAA.");
                            }else{
                                if (!validaNombreCiudad(pNombre) || !validaNombreCiudad(pCiudad)) {
                                    throw new NombreApellidoFormatoIncorrectoException("El nombre/ciudad de el aeropuerto no cumple con el formato Abbb");
                                }else{
                                    this.IATA = pIATA;
                                    this.Nombre = pNombre;
                                    this.Ciudad = pCiudad;
                                    this.CodigoPostal = pPostal;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean validaNombreCiudad(String texto) {
        return texto.matches("^([A-Z]{1}[a-z]+[ ]?){1,4}$");
    }
    public static boolean validaCodidoIATA(String iata){
        return iata.matches("^([A-Z]{3})$");
    }