package clasesTest;

import clases.Aeropuerto;
import clases.Avión;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviónTest {

    @Test
    void cargarNuevoAvion_creacionCorrecta(){
        // Arrange
        String matricula = "LV-CDY";
        String modelo = "Embraer 190";
        int capacidad = 96;
        int añoFabricacion = 2015;

        // Act
        Avión elAvion = new Avión("LV-CDY","Embraer 190",96,2015);

        // Assert
        assertEquals(matricula,elAvion.getMatricula());
        assertEquals(modelo, elAvion.getModelo());
        assertEquals(capacidad, elAvion.getCapacidad());
        assertEquals(añoFabricacion, elAvion.getAñoFabricacion());
    }

    @Test
    void modificacionAvionExistente_modificacionMatriculaCorrecta(){
        // Arrange
        String matriculaNueva = "LV-CDZ";

        // Act
        Avión elAvionViejo = new Avión("LV-CDY","Embraer 190",96,2015);

        elAvionViejo.setMatricula(matriculaNueva);

        // Assert
        assertEquals(matriculaNueva,elAvionViejo.getMatricula());

    }

    @Test
    void cargarNuevoAvion_creacionIncorrecta_sinID() throws NullPointerException{
        // Arrange y Act

        // Assert
        assertThrows(NullPointerException.class() -> new Avión(null,"Embraer 190",96,2015));
        Throwable excepcion;
        excepcion = assertThrows(NullPointerException.class; () -> new Avión(null,"Embraer 190",96,2015));
        assertEquals("El ID del avion no puede ser nulo",excepcion.getMessage());
    }




}