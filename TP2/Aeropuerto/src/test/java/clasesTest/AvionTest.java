package clasesTest;

import clases.Avion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvionTest {

    @Test
    void cargarNuevoAvion_creacionCorrecta(){
        // Arrange
        String matricula = "LV-CDY";
        String modelo = "Embraer 190";
        int capacidad = 96;
        int añoFabricacion = 2015;

        // Act
        Avion elAvion = new Avion("LV-CDY","Embraer 190",96,2015);

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
        Avion elAvionViejo = new Avion("LV-CDY","Embraer 190",96,2015);

        elAvionViejo.setMatricula(matriculaNueva);

        // Assert
        assertEquals(matriculaNueva,elAvionViejo.getMatricula());

    }

    @Test
    void cargarNuevoAvion_creacionIncorrecta_sinID() throws NullPointerException{
        // Arrange y Act

        // Assert
        Throwable excepcion =  assertThrows(NullPointerException.class, () -> new Avion(null,"Embraer 190",96,2015));
        assertEquals("El ID del avion no puede ser nulo",excepcion.getMessage());
    }




}