package gestoresTest;

import clases.Avion;
import exepciones.FechaIncorrectaException;
import exepciones.MatriculaIncorrectaException;
import exepciones.StringNuloException;
import gestores.GestorAvion;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GestorAvionTest {

    @Test
    void crearAvion_creacionCorrecta() throws NullPointerException, FechaIncorrectaException, StringNuloException, MatriculaIncorrectaException {

        // Arrange
        GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
        int avionesEnColeccion = elGestor.getColeccionAviones().size();

        // Act
        Avion elAvion = elGestor.crearAvion("LV-CDY", "Embraer 190", 96, 2015);
        elGestor.agregarAvion(elAvion);

        int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();

        // Assert
        assertTrue( (avionesEnColeccion + 1) == avionesLuegoDeCrear );

    }

    @Test
    void crearAvion_yaExisteAvionPorID() throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException {

        // Arrange
        GestorAvion elGestor = new GestorAvion(new LinkedList<Avion>());
        elGestor.getColeccionAviones().add(new Avion("LV-CDY","Embraer 190",96,2015));

        int avionesEnColeccion = elGestor.getColeccionAviones().size();
        Avion elAvion = elGestor.crearAvion("LV-CDY","Embraer 190",96,2015);

        // Act
        boolean falsoCrearAvion = elGestor.agregarAvion(elAvion);
        int avionesLuegoDeCrear = elGestor.getColeccionAviones().size();


        // Assert
        assertFalse(falsoCrearAvion);
        assertEquals(avionesEnColeccion, avionesLuegoDeCrear);

    }

    @Test
    void ConsultarAviones_ConsultaCorrecta () throws
            FechaIncorrectaException, StringNuloException, NullPointerException, MatriculaIncorrectaException {
        // Arrange y Act
        GestorAvion gestor = new GestorAvion(new LinkedList<Avion>());

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);
        Avion elAvion2 = new Avion("LV-CDZ","Embraer 190",96,2016);
        Avion elAvion3 = new Avion("LV-CDA","Embraer 190",96,2017);
        Avion elAvion4 = new Avion("LV-CDB","Embraer 190",96,2010);
        Avion elAvion5 = new Avion("LV-CDC","Embraer 190",96,2011);

        gestor.agregarAvion(elAvion1);
        gestor.agregarAvion(elAvion2);
        gestor.agregarAvion(elAvion3);
        gestor.agregarAvion(elAvion4);
        gestor.agregarAvion(elAvion5);

        Avion avionBuscado = gestor.buscarAvionPorMatricula("LV-CDA");

        // Assert
        assertEquals(elAvion3.getMatricula(),avionBuscado.getMatricula());
    }

    @Test
    void listarAviones() throws StringNuloException, MatriculaIncorrectaException, FechaIncorrectaException {
        // Arrange y Act
        GestorAvion gestor = new GestorAvion(new LinkedList<Avion>());

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);
        Avion elAvion2 = new Avion("LV-CDZ","Embraer 190",96,2016);
        Avion elAvion3 = new Avion("LV-CDA","Embraer 190",96,2017);
        Avion elAvion4 = new Avion("LV-CDB","Embraer 190",96,2010);
        Avion elAvion5 = new Avion("LV-CDC","Embraer 190",96,2011);

        gestor.agregarAvion(elAvion1);
        gestor.agregarAvion(elAvion2);
        gestor.agregarAvion(elAvion3);
        gestor.agregarAvion(elAvion4);
        gestor.agregarAvion(elAvion5);

        gestor.listarAviones();
    }


}

