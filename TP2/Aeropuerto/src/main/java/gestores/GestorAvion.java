package gestores;

import clases.Avion;
import exepciones.FechaIncorrectaException;
import exepciones.MatriculaIncorrectaException;
import exepciones.StringNuloException;

import java.util.Collection;
import java.util.LinkedList;

public class GestorAvion {

    private Collection<Avion> Aviones = new LinkedList<Avion>();


    public GestorAvion(Collection<Avion> linkedList) {
        linkedList.addAll(Aviones);
    }


    public Avion crearAvion(String pMatricula, String pModelo, int pCapacidad, int pAnioFabricacion) throws
            StringNuloException, MatriculaIncorrectaException, FechaIncorrectaException {
        
        return new Avion(pMatricula,pModelo,pCapacidad,pAnioFabricacion);
    }

    public boolean agregarAvion(Avion elAvion) {
        for (Avion pAvion: Aviones) {
            if(elAvion.getMatricula().equals(pAvion.getMatricula())) {
                return false;
            }
            break;
        }
        Aviones.add(elAvion);
        return true;
    }

    public Avion buscarAvionPorMatricula(String pMatricula) {
        Avion av = null;
        for (Avion pAvion: Aviones) {
            if(pAvion.getMatricula().equals(pMatricula)){
                av=pAvion;
            }
        }
        return av;
    }

    public Collection<Avion> getColeccionAviones() {
        return Aviones;
    }

    public void listarAviones(){
        System.out.println("Listado de Aviones : ");
        for (Avion pAvion: Aviones) {
            //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(pAvion.getMatricula()+"-"+
                    pAvion.getModelo()+" - "+
                    pAvion.getCapacidad()+" - "+
                    pAvion.getAnioFabricacion()+".");
        }
    }
}
