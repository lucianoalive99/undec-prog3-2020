package gestores;

import clases.Piloto;
import exepciones.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class GestorPiloto {

    private Collection<Piloto> Pilotos = new LinkedList<Piloto>();

    public GestorPiloto(Collection<Piloto> linkedList){
        linkedList.addAll(Pilotos);
    }

    public Piloto crearPiloto(String pCUIL, int pLegajo, String pApellido,
                              String pNombre, Date pfechaNacimiento) throws
            StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException,
            NombreApellidoFormatoIncorrectoException, EnteroNegativoException {

        return new Piloto(pCUIL,pLegajo,pApellido,pNombre,pfechaNacimiento);

    }

    public Collection<Piloto> getColeccionPilotos() {
        return Pilotos;
    }

    public boolean agregarPiloto(Piloto elPiloto) {
        for (Piloto pPiloto: Pilotos) {
            if(elPiloto.getCUIL().equals(pPiloto.getCUIL())) {
                return false;
            }
            break;
        }
        Pilotos.add(elPiloto);
        return true;
    }

    public Piloto buscarPilotoPorLegajo(int pLegajo) {
        Piloto pi = null;
        for (Piloto pPiloto: Pilotos) {
            if(pPiloto.getLegajo() == pLegajo){
                pi = pPiloto;
            }
        }
        return pi;
    }

    public Piloto modificarPilotoApellidoNombreCuil(Piloto pilotoBuscado, String cuilModificar, String apellidoModificar,
                                                    String nombreModificar) {
        if(cuilModificar!=null){
            pilotoBuscado.setCUIL(cuilModificar);
            System.out.println("Se modifico exitosamente el CUIL.");
        }
        if(apellidoModificar!=null){
            pilotoBuscado.setApellido(apellidoModificar);
        }
        if(nombreModificar!=null){
            pilotoBuscado.setNombre(nombreModificar);
        }

        return pilotoBuscado;
    }

    public Piloto modificarPilotoFechaNacimiento(Piloto pilotoBuscado, Date fechaModificar) {
        if(fechaModificar!=null){
            pilotoBuscado.setFechaNacimiento(fechaModificar);
            System.out.println("Se modifico exitosamente la fecha de nacimiento.");
        }
        return pilotoBuscado;
    }

    public void listarPilotos(){
        System.out.println("Listado de Pilotos : ");
        for (Piloto pPiloto: Pilotos) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(pPiloto.getCUIL()+" - "+
                    pPiloto.getLegajo()+" - " +
                    pPiloto.getApellido()+", "+
                    pPiloto.getNombre()+" - "+
                    sdf.format(pPiloto.getFechaNacimiento())+".");
        }
    }

    public void buscarPilotosPorApellido(String pApellido) {
        Collection<Piloto> pilotosEncontrados = new LinkedList<Piloto>();

        for (Piloto pPiloto: Pilotos) {
            if(pPiloto.getApellido().equals(pApellido)){
                pilotosEncontrados.add(pPiloto);
            }
        }

        System.out.println("Listado de Pilotos con apellido '"+pApellido+"': ");

        for (Piloto pEncontrado : pilotosEncontrados) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(pEncontrado.getCUIL() + " - " +
                    pEncontrado.getLegajo() + " - " +
                    pEncontrado.getApellido() + ", " +
                    pEncontrado.getNombre() + " - " +
                    sdf.format(pEncontrado.getFechaNacimiento()) + ".");
        }
    }
}
