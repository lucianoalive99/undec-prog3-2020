package clasesTest;

import clases.Aerolinea;
import clases.Aeropuerto;
import exepciones.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AeropuertoTest {

    @Test
    void crearAeropuerto_creacionCorrecta() throws NuloException, StringNuloException, EnteroNegativoException, CodigoIATAException, NombreApellidoFormatoIncorrectoException {

        Aeropuerto elAeropuerto = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);

        assertEquals("EZE", elAeropuerto.getIATA());
        assertEquals("Ministro Pistarini", elAeropuerto.getNombre());
        assertEquals("Ezeiza", elAeropuerto.getCiudad());
        assertEquals(5360, elAeropuerto.getCodigoPostal());
    }

    @Test
    void crearAeropuerto_creacionIncorrectaIataNulo()  {
        assertThrows(NuloException.class,
                () -> new Aeropuerto(null, "Ministro Pistarini","Ezeiza",5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaIataVacio()  {
        assertThrows(StringNuloException.class,
                () -> new Aeropuerto("", "Ministro Pistarini","Ezeiza",5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaNombreNulo()  {
        assertThrows(NuloException.class,
                () -> new Aeropuerto("EZE", null,"Ezeiza",5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaNombreVacio()  {
        assertThrows(NuloException.class,
                () -> new Aeropuerto("EZE", "","Ezeiza",5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaCiudadNula()  {
        assertThrows(NuloException.class,
                () -> new Aeropuerto("EZE", "Ministro Pistarini",null,5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaCiudadVacia()  {
        assertThrows(NuloException.class,
                () -> new Aeropuerto("EZE", "Ministro Pistarini","",5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaPostalNulo()  {
        assertThrows(EnteroNegativoException.class,
                () -> new Aeropuerto("EZE", "Ministro Pistarini","Ezeiza",null));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaPostalVacio()  {
        assertThrows(EnteroNegativoException.class,
                () -> new Aeropuerto("EZE", "Ministro Pistarini","Ezeiza",0));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaIataFormatoIncumplido()  {
        assertThrows(CodigoIATAException.class,
                () -> new Aeropuerto("EZ", "Ministro Pistarini","Ezeiza",5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaNombreFormatoIncumplido()  {
        assertThrows(NombreApellidoFormatoIncorrectoException.class,
                () -> new Aeropuerto("EZE", "ministro Pistarini","Ezeiza",5360));
    }

    @Test
    void crearAeropuerto_creacionIncorrectaCiudadFormatoIncumplido()  {
        assertThrows(NombreApellidoFormatoIncorrectoException.class,
                () -> new Aeropuerto("EZE", "Ministro Pistarini","ezeiza",5360));
    }
}