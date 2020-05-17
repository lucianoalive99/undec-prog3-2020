package clasesTest;

import clases.Avion;
import exepciones.FechaIncorrectaException;
import exepciones.MatriculaIncorrectaException;
import exepciones.StringNuloException;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AvionTest {

    @Test
    void cargarNuevoAvion_creacionCorrecta ()throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException{
        // Arrange
        String matricula = "LV-CDY";
        String modelo = "Embraer 190";
        int capacidad = 96;
        int anioFabricacion = 2015;

        // Act
        Avion elAvion = new Avion("LV-CDY","Embraer 190",96,2015);

        // Assert
        assertEquals(matricula,elAvion.getMatricula());
        assertEquals(modelo, elAvion.getModelo());
        assertEquals(capacidad, elAvion.getCapacidad());
        assertEquals(anioFabricacion, elAvion.getAnioFabricacion());
    }

    @Test
    void modificacionAvionExistente_modificacionMatriculaCorrecta()throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException{
        // Arrange
        String matriculaNueva = "LV-CDZ";

        // Act
        Avion elAvionViejo;
        elAvionViejo = new Avion("LV-CDY","Embraer 190",96,2015);

        elAvionViejo.setMatricula(matriculaNueva);

        // Assert
        assertEquals(matriculaNueva,elAvionViejo.getMatricula());

    }

    @Test
    void cargarNuevoAvion_creacionIncorrecta_sinID_null() throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException {
        // Arrange y Act

        // Assert
        Throwable excepcion = assertThrows(NullPointerException.class,
                () -> new Avion(null,"Embraer 190",96,2015));
        assertEquals("El ID del avion no puede ser nulo.",excepcion.getMessage());
    }

    @Test
    void cargarNuevoAvion_creacionIncorrecta_sinID_vacio() throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException {
        // Arrange y Act

        // Assert
        assertThrows(StringNuloException.class,
                () -> new Avion("","Embraer 190",96,2015));

    }

    @Test
    void cargarNuevoAvion_creacionIncorrecta_sinModelo() throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException {
        // Arrange y Act

        // Assert
        assertThrows(StringNuloException.class,
                () -> new Avion("Lv-CdY","",96,2015));
        assertThrows(StringNuloException.class,
                () -> new Avion("Lv-CdY",null,96,2015));

    }

    @Test
    void cargarNuevoAvion_creacionIncorrecta_anioFabricacion() throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException {
        // Arrange y Act

        // Assert

        assertThrows(FechaIncorrectaException.class,
                () -> new Avion("Lv-CdY","Embraer 190",96,1900));
        assertThrows(FechaIncorrectaException.class,
                () -> new Avion("Lv-CdY","Embraer 190",96,2900));

        //assertEquals(2020, );

    }
    @Test
    void cargarNuevoAvion_creacionIncorrecta_formatoMatriculaIncorrecto() throws
            NullPointerException, StringNuloException, FechaIncorrectaException, MatriculaIncorrectaException {

        // Arrange
        // Act


        // Assert
        assertThrows(MatriculaIncorrectaException.class,
                () -> new Avion("LV-C12","Embraer 190",96,2015));

    }


}