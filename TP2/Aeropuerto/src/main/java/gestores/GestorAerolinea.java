package gestores;

import clases.Aerolinea;
import exepciones.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class GestorAerolinea {
    private Collection<Aerolinea> aerolienas = new LinkedList<Aerolinea>();

    public GestorAerolinea(Collection<Aerolinea> linkedList) {
        linkedList.addAll(aerolienas);
    }

    public Aerolinea crearAerolinea(String pCUIT, String pCodigoIATA, String pNombre, Date pFechaIA) throws
            CuilIncorrectoException, StringNuloException, FechaNulaException,
            NombreApellidoFormatoIncorrectoException, CodigoIATAException, NuloException {

        return new Aerolinea(pCUIT,pCodigoIATA,pNombre,pFechaIA);
    }

    public Collection<Aerolinea> getColeccionAerolineas(){
        return aerolienas;
    }

    public boolean agregarAerolinea(Aerolinea laAerolinea){
        for (Aerolinea pAerolinea: aerolienas) {
            if(pAerolinea.getCUIT().equals(laAerolinea.getCUIT())||
                    pAerolinea.getCodigoIATA().equals(laAerolinea.getCodigoIATA())){
                return false;
            }
            break;
        }
        aerolienas.add(laAerolinea);
        return true;
    }

    public void buscarAerolineaPorNombre(String pNombre) {
        Collection<Aerolinea> AerolienasEncontradas = new LinkedList<Aerolinea>();

        for (Aerolinea pAerolinea: aerolienas) {
            if(pAerolinea.getNombre().equals(pNombre)){
                AerolienasEncontradas.add(pAerolinea);
            }

        }

        System.out.println("Listado de Aerolineas buscados: ");

        for (Aerolinea pEncontrado : AerolienasEncontradas) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(pEncontrado.getCUIT() + " - " +
                    pEncontrado.getCodigoIATA() + " - " +
                    pEncontrado.getNombre() + " - " +
                    sdf.format(pEncontrado.getFechaIA()) + ".");
        }
    }
    
    public Aerolinea modificarAerolinea_cuitIataNombre(Aerolinea laAerolinea, String cuitModificar,
                                                       String iataModificar, String nombreModificar){
        if(cuitModificar!=null) {
            boolean señal=false;
            for (Aerolinea pAerolinea : aerolienas) {
                if (pAerolinea.getCUIT().equals(cuitModificar)) {
                    System.out.println("El CUIT ingresado para modificar ya existe en el sistema.");
                    señal=true;
                    break;
                }
            }
            if(Aerolinea.validaCUIT(cuitModificar) && !señal){
                laAerolinea.setCUIT(cuitModificar);
                // System.out.println("El CUIT ingresado para modificar ya existe en el sistema.");
            }/*else {
                laAerolinea.setCUIT(cuitModificar);
            }*/

        }
        if(iataModificar!=null){
            boolean señal=false;
            for(Aerolinea pAerolinea: aerolienas){
                if(pAerolinea.getCodigoIATA().equals(iataModificar)){
                    System.out.println("El codigo IATA ingresado para modificar ya existe en el sistema.");
                    señal=true;
                    break;
                }

            }
            if(Aerolinea.validaCodidoIATA(iataModificar) && !señal){
                laAerolinea.setCodigoIATA(iataModificar);
            }
        }
        if(nombreModificar!=null){
            if(!Aerolinea.validaNombreApellido(nombreModificar)){
                System.out.println("El nombre ingresado para modificar no cumple con el formato Abbbb.");
            }else{
                laAerolinea.setNombre(nombreModificar);
            }
        }
        return laAerolinea;
    }

    public Aerolinea buscarAerolinea(String pNombre) {
        Aerolinea aero= null;
        for(Aerolinea pAero:aerolienas){
            if(pAero.getNombre().equals(pNombre)){
                aero=pAero;
            }
        }
        return aero;
    }

    public Aerolinea modificarAerolinea_fecha(Aerolinea laAerolinea, Date fechaModificar) {
        if(fechaModificar!=null){
            laAerolinea.setFechaIA(fechaModificar);
        }
        return laAerolinea;
    }
}
