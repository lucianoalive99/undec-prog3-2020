package gestoresTest;

import clases.Aeropuerto;
import exepciones.*;
import gestores.GestorAeropuerto;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestorAeropuertoTest {

    @Test
    void crearAeropuerto_creacionCorrecta() throws CodigoIATAException, NuloException, StringNuloException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException {
        GestorAeropuerto elGestor = new GestorAeropuerto(new LinkedList<Aeropuerto>());
        int AeropuertosEnColeccion = elGestor.getColeccionAeropuerto().size();

        // Act
        Aeropuerto elAeropuerto = elGestor.crearAeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        elGestor.agregarAeropuerto(elAeropuerto);

        int aeropuertoLuegoDeCrear = elGestor.getColeccionAeropuerto().size();

        // Assert
        assertEquals((AeropuertosEnColeccion + 1), aeropuertoLuegoDeCrear);
    }

    @Test
    void modificarAeropuerto() throws CodigoIATAException, NuloException, StringNuloException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException {
        GestorAeropuerto elGestor = new GestorAeropuerto(new LinkedList<Aeropuerto>());

        Aeropuerto elAeropuerto = elGestor.crearAeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        elGestor.agregarAeropuerto(elAeropuerto);

        elGestor.modificarAeropuerto(elAeropuerto,"ABA", null, null, null);
        assertEquals("ABA",elAeropuerto.getIATA());
    }

    @Test
    void listarAeropuertos() throws CodigoIATAException, NuloException, StringNuloException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException {
        GestorAeropuerto elGestor = new GestorAeropuerto(new LinkedList<Aeropuerto>());

        Aeropuerto elAeropuerto = elGestor.crearAeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto elAeropuerto2 = elGestor.crearAeropuerto("EZI","Almandos Almonacid","La Rioja",5361);
        Aeropuerto elAeropuerto3 = elGestor.crearAeropuerto("EZO","Aeroparque","Cordoba",5362);
        Aeropuerto elAeropuerto4 = elGestor.crearAeropuerto("EZU","Ministro","Rosario",5363);
        Aeropuerto elAeropuerto5 = elGestor.crearAeropuerto("EZA","Pistarini","Posadas",5364);


        elGestor.agregarAeropuerto(elAeropuerto);
        elGestor.agregarAeropuerto(elAeropuerto2);
        elGestor.agregarAeropuerto(elAeropuerto3);
        elGestor.agregarAeropuerto(elAeropuerto4);
        elGestor.agregarAeropuerto(elAeropuerto5);

        elGestor.listarAeropuertos();

    }

    @Test
    void buscarAeropuertoporIATA() throws CodigoIATAException, NuloException, StringNuloException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException {
        GestorAeropuerto elGestor = new GestorAeropuerto(new LinkedList<Aeropuerto>());

        Aeropuerto elAeropuerto = elGestor.crearAeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto elAeropuerto2 = elGestor.crearAeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);
        Aeropuerto elAeropuerto3 = elGestor.crearAeropuerto("EZO","Aeroparque","Cordoba",5362);
        Aeropuerto elAeropuerto4 = elGestor.crearAeropuerto("EZU","Ministro","Rosario",5363);
        Aeropuerto elAeropuerto5 = elGestor.crearAeropuerto("EZA","Pistarini","Posadas",5364);


        elGestor.agregarAeropuerto(elAeropuerto);
        elGestor.agregarAeropuerto(elAeropuerto2);
        elGestor.agregarAeropuerto(elAeropuerto3);
        elGestor.agregarAeropuerto(elAeropuerto4);
        elGestor.agregarAeropuerto(elAeropuerto5);

        elGestor.buscarAerpouertosApellido("EZA");

    }
}
