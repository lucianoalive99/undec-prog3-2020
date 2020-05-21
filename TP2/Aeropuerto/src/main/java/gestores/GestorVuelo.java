package gestores;

import clases.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

public class GestorVuelo {
    private Collection<Vuelo> Vuelos = new LinkedList<Vuelo>();

    public GestorVuelo(Collection<Vuelo> linkedList){linkedList.addAll(Vuelos);}

    public Collection<Vuelo> getColeccionVuelos(){return Vuelos;}


    public Vuelo CrearVuelo(String pIATA, LocalDateTime pSalida, LocalDateTime pArribo,
                            Aeropuerto pAeroSalida, Aeropuerto pAeroLlegada, Avion pAvion,
                            Piloto pComandante, Piloto pCopiloto, Aerolinea pAeroliena) {
        return new Vuelo(pIATA,pSalida,pArribo,pAeroSalida,pAeroLlegada,pAvion,pComandante,pCopiloto,pAeroliena);
    }

    public boolean agregarVuelos(Vuelo elVuelo) {
        for (Vuelo pVuelo : Vuelos) {
            if(pVuelo.getCodigoVuelo().equals(elVuelo.getCodigoVuelo())) {
                return false;
            }
            break;
        }
        Vuelos.add(elVuelo);
        return true;
    }

    public void modificarVueloAvion(Vuelo vuelo1, Avion avion2) {
        Vuelo encontrado=null;
        for (Vuelo pVue:Vuelos) {
            if(pVue.getCodigoVuelo().equals(vuelo1.getCodigoVuelo())){
                encontrado=pVue;
            }

        }
        if(avion2!=null){
            encontrado.setAvion(avion2);
        }
    }

    public void modificarVuelocomandante(Vuelo vuelo1, Piloto comandanteModificar) {
        Vuelo encontrado=null;
        for (Vuelo pVue:Vuelos) {
            if(pVue.getCodigoVuelo().equals(vuelo1.getCodigoVuelo())){
                encontrado=pVue;
            }

        }
        if(comandanteModificar!=null){
            encontrado.setComandante(comandanteModificar);
        }
    }

    public void modificarVueloCopiloto(Vuelo vuelo1, Piloto copilotoModificar) {
        Vuelo encontrado=null;
        for (Vuelo pVue:Vuelos) {
            if(pVue.getCodigoVuelo().equals(vuelo1.getCodigoVuelo())){
                encontrado=pVue;
            }

        }
        if(copilotoModificar!=null){
            encontrado.setCopiloto(copilotoModificar);
        }
    }

    public void modificarVueloSalidaArribo(Vuelo vuelo1, LocalDateTime salidaModificar,
                                           LocalDateTime arriboModificar) {
        Vuelo encontrado=null;
        for (Vuelo pVue:Vuelos) {
            if(pVue.getCodigoVuelo().equals(vuelo1.getCodigoVuelo())){
                encontrado=pVue;
            }

        }
        if(salidaModificar!=null && arriboModificar !=null){
            encontrado.setSalida(salidaModificar);
            encontrado.setArribo(arriboModificar);
        }
    }

    public void buscarVueloPorFecha(LocalDateTime fechabuscar) {
        Collection<Vuelo> vuelosEncontradas = new LinkedList<Vuelo>();

        for (Vuelo pvue : Vuelos) {
            if(pvue.getSalida().getDayOfMonth() == fechabuscar.getDayOfMonth() &&
            pvue.getSalida().getMonth() == fechabuscar.getMonth() &&
            pvue.getSalida().getYear() == fechabuscar.getYear()){
                vuelosEncontradas.add(pvue);
            }

        }

        System.out.println("Listado de Vuelos encontrados por la fecha ingresasda: ");

        for (Vuelo pvue : vuelosEncontradas) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(pvue.getCodigoVuelo() + " - " + pvue.getAvion().getModelo() +
                    " - " + pvue.getSalida().getDayOfMonth() +
                    " de " + pvue.getSalida().getMonth() +
                    " " + pvue.getSalida().getHour() +
                    ":" + pvue.getSalida().getMinute() +
                    " " + pvue.getAeropuertoSalida().getIATA() +
                    " (" + pvue.getAeropuertoSalida().getCiudad() + " - " + pvue.getAeropuertoSalida().getNombre() + ") " +
                    " - " + pvue.getArribo().getDayOfMonth() +
                    " de " + pvue.getArribo().getMonth() +
                    " " + pvue.getArribo().getHour() +
                    ":" + pvue.getArribo().getMinute() +
                    " " + pvue.getAeropuertoArribo().getIATA() +
                    " (" + pvue.getAeropuertoArribo().getCiudad() + " - " + pvue.getAeropuertoArribo().getNombre() + ") " +
                    " - Operado por " + pvue.getAerolinea().getNombre());
        }
    }

    public void buscarVueloPorAerolinea(String nombre) {
        Collection<Vuelo> vuelosEncontradas = new LinkedList<Vuelo>();

        for (Vuelo pvue : Vuelos) {
            if(pvue.getAerolinea().getNombre().equals(nombre)){
                vuelosEncontradas.add(pvue);
            }

        }

        System.out.println("Listado de Vuelos encontrados por la aerolineaIngresada: ");

        for (Vuelo pvue : vuelosEncontradas) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(pvue.getCodigoVuelo() + " - " + pvue.getAvion().getModelo() +
                    " - " + pvue.getSalida().getDayOfMonth() +
                    " de " + pvue.getSalida().getMonth() +
                    " " + pvue.getSalida().getHour() +
                    ":" + pvue.getSalida().getMinute() +
                    " " + pvue.getAeropuertoSalida().getIATA() +
                    " (" + pvue.getAeropuertoSalida().getCiudad() + " - " + pvue.getAeropuertoSalida().getNombre() + ") " +
                    " - " + pvue.getArribo().getDayOfMonth() +
                    " de " + pvue.getArribo().getMonth() +
                    " " + pvue.getArribo().getHour() +
                    ":" + pvue.getArribo().getMinute() +
                    " " + pvue.getAeropuertoArribo().getIATA() +
                    " (" + pvue.getAeropuertoArribo().getCiudad() + " - " + pvue.getAeropuertoArribo().getNombre() + ") " +
                    " - Operado por " + pvue.getAerolinea().getNombre());
        }
    }

}
