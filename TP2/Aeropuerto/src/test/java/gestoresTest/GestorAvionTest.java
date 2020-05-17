package gestoresTest;

import clases.Avion;
import exepciones.FechaIncorrectaException;
import exepciones.StringNuloException;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GestorAvionTest {

    @Test
    void crearAvion_creacionCorrecta() throws NullPointerException, FechaIncorrectaException, StringNuloException{

        // Arrange
        GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
        int avionesEnColeccion = elGestor.getColeccionAviones().size();
        Avion elAvion = new Avion("LV-CDY","Embraer 190",96,2015);

        // Act
        elGestor.crearAvion(elAvion);
        int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();

        // Assert
        assertTrue((avionesEnColeccion + 1) == avionesLuegoDeCrear);

    }

    @Test
    void crearAvion_yaExisteAvionPorID() throws
            NullPointerException, StringNuloException, FechaIncorrectaException{

        // Arrange
        GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
        elGestor.getColeccionAviones().add(new Avion("LV-CDY","Embraer 190",96,2015));
        int avionesEnColeccion = elGestor.getColeccionAviones().size();
        Avion elAvion = new Avion("LV-CDY","Embraer 190",96,2015);

        // Act
        boolean falsoCrearAvion = elGestor.crearAvion(elAvion);
        int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();

        // Assert
        int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();
        assertFalse(falsoCrearAvion);
        assertTrue(avionesEnColeccion == avionesLuegoDeCrear);

        }

    @Test
    /*void horasVueloAvion_listaVuelos_devuelveSuma() {
        Avion avion1 = new Avion(1, "Airbus A340-313X", "LV-FPV", null);
        GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
        int horasVuelo = elGestor.horasVueloAvion(crearVuelos(), avion1);
        assertEquals(15, horasVuelo);
    }*/

    @Test
    void ConsultarAviones_ConsultaCorrecta () throws FechaIncorrectaException, StringNuloException, NullPointerException {
        // Arrange y Act
        GestorAvion gestor = new GestorAvion(new LinkedList<Avion>());

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);
        Avion elAvion2 = new Avion("lv-cdx","Embraer 190",96,2016);
        Avion elAvion3 = new Avion("lv-cdz","Embraer 190",96,2017);
        Avion elAvion4 = new Avion("lv-cda","Embraer 190",96,2010);
        Avion elAvion5 = new Avion("lv-cdb","Embraer 190",96,2011);

        gestor.agrgarAvion(elAvion1);
        gestor.agrgarAvion(elAvion2);
        gestor.agrgarAvion(elAvion3);
        gestor.agrgarAvion(elAvion4);
        gestor.agrgarAvion(elAvion5);

        Avion avionBuscado = gestor.buscarAvionPorMatricula("LV-CDA");

        // Assert
        assertEquals(elAvion1.getMatricula(),avionBuscado.getMatricula());
        assertEquals(elAvion4.getMatricula(),avionBuscado.getMatricula());
    }
}
