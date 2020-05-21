package gestores;

import clases.Aeropuerto;
import exepciones.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;

public class GestorAeropuerto {

    private Collection<Aeropuerto> aeropuertos = new LinkedList<Aeropuerto>();

    public GestorAeropuerto(Collection<Aeropuerto> linkedList){
        linkedList.addAll(aeropuertos);
    }

    public Aeropuerto crearAeropuerto(String pIATA, String pNombre, String pCiudad, Integer pCodigoPostal) throws CodigoIATAException, NuloException, EnteroNegativoException, NombreApellidoFormatoIncorrectoException, StringNuloException {
        return new Aeropuerto(pIATA,pNombre,pCiudad,pCodigoPostal);
    }

    public Collection<Aeropuerto> getColeccionAeropuerto(){return aeropuertos;}

    public void agregarAeropuerto(Aeropuerto elAeropuerto){
        for (Aeropuerto aero :aeropuertos) {
            if(aero.getIATA().equals(elAeropuerto.getIATA())){
                return;
            }
            break;
        }
        aeropuertos.add(elAeropuerto);
    }

    public void listarAeropuertos(){
        System.out.println("Listado de Aeropuertos: ");
        for (Aeropuerto pAero: aeropuertos) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(pAero.getIATA()+" - "+
                    pAero.getNombre()+" - " +
                    pAero.getCiudad()+" - "+
                    pAero.getCodigoPostal()+".");
        }
    }

    public void modificarAeropuerto(Aeropuerto elAeropuerto, String iataModificar, String nombreModificar,
                                    String ciudadModificar, Integer postalModificar) {

        if(iataModificar!=null){
            boolean señal=false;
            for(Aeropuerto pAeropuerto : aeropuertos){
                if(pAeropuerto.getIATA().equals(iataModificar)){
                    System.out.println("El codigo IATA ingresado para modificar ya existe en el sistema.");
                    señal=true;
                    break;
                }

            }
            if(Aeropuerto.validaCodidoIATA(iataModificar) && !señal){
                elAeropuerto.setIATA(iataModificar);
            }
        }
        if(nombreModificar!=null){
            if(!Aeropuerto.validaNombreCiudad(nombreModificar)){
                System.out.println("El nombre ingresado para modificar no cumple con el formato Abbbb.");
            }else{
                elAeropuerto.setNombre(nombreModificar);
            }
        }

        if(nombreModificar!=null){
            if(!Aeropuerto.validaNombreCiudad(nombreModificar)){
                System.out.println("El nombre ingresado para modificar no cumple con el formato Abbbb.");
            }else{
                elAeropuerto.setNombre(nombreModificar);
            }
        }

        if(ciudadModificar!=null){
            if(!Aeropuerto.validaNombreCiudad(ciudadModificar)){
                System.out.println("El nombre ingresado para modificar no cumple con el formato Abbbb.");
            }else{
                elAeropuerto.setCiudad(ciudadModificar);
            }
        }

        if(postalModificar!=null){
            if(postalModificar<=0){
                System.out.println("El codigo postal ingresao en menor/igual a 0.");
            }else{
                elAeropuerto.setCodigoPostal(postalModificar);
            }
        }
    }

    public void buscarAerpouertosApellido(String pIATA){
        Collection<Aeropuerto> aeropuertosEncontrados=new LinkedList<Aeropuerto>();

        for (Aeropuerto aero : aeropuertos) {
            if(aero.getIATA().equals(pIATA)){
                aeropuertosEncontrados.add(aero);
            }
        }

        System.out.println("Listado de Aeropuertos por Codigo IATA '"+pIATA+"': ");

        for (Aeropuerto aero : aeropuertosEncontrados) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(aero.getIATA() + " - " +
                    aero.getNombre() + " - " +
                    aero.getCiudad() + " - " +
                    aero.getCodigoPostal() + ".");
        }
    }
}
