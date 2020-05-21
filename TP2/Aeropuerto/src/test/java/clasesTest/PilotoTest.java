package clasesTest;

import clases.Avion;
import clases.Piloto;
import exepciones.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PilotoTest {

    @Test
    void creacionPiloto_creacionCorrecta() throws
            StringNuloException, FechaNulaException, EnteroNegativoException, CuilIncorrectoException,
            NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        // Act
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Piloto elPiloto = new Piloto("20-12345678-0",
                123,
                "Ocampo",
                "Jose Antonio",
                fechaNacimiento2);
        // Assert

        assertEquals("20-12345678-0",elPiloto.getCUIL());
        assertEquals(123,elPiloto.getLegajo());
        assertEquals("Ocampo",elPiloto.getApellido());
        assertEquals("Jose Antonio",elPiloto.getNombre());
        assertEquals(fechaNacimiento2 ,elPiloto.getFechaNacimiento());
    }

    @Test
    void creacionPiloto_creacionIncorrecta_sinCUIL_null() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Piloto elPiloto = new Piloto("20-12345678-0",
                123,
                "Ocampo",
                "Jose Antonio",
                fechaNacimiento2);
        // Assert
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(NullPointerException.class,
                () -> new Piloto(null, 123, "Ocampo", "Jose Antonio", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_sinCUIL_vacio() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Piloto elPiloto = new Piloto("20-12345678-0",
                123,
                "Ocampo",
                "Jose Antonio",
                fechaNacimiento2);
        // Assert
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(CuilIncorrectoException.class,
                () -> new Piloto("", 123, "Ocampo", "Jose Antonio", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_legajoceroNegativo() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Piloto elPiloto = new Piloto("20-12345678-0",
                123,
                "Ocampo",
                "Jose Antonio",
                fechaNacimiento2);
        // Assert
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(EnteroNegativoException.class,
                () -> new Piloto("20-12345678-0", 0, "Ocampo", "Jose Antonio", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_apellidoNuloVacio() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(StringNuloException.class,
                () -> new Piloto("20-12345678-0", 123, "", "Jose Antonio", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_apellidoNulo() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(StringNuloException.class,
                () -> new Piloto("20-12345678-0", 123, null, "Jose Antonio", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_apellidoFormatoIncorrecto() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(NombreApellidoFormatoIncorrectoException.class,
                () -> new Piloto("20-12345678-0", 123, "ocampo", "Jose Antonio", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_nombreNulo() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(StringNuloException.class,
                () -> new Piloto("20-12345678-0", 123, "Ocampo", null, finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_nombreVacio() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(StringNuloException.class,
                () -> new Piloto("20-12345678-0", 123, "Ocampo", "", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_nombreFormatoIncorrecto() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(NombreApellidoFormatoIncorrectoException.class,
                () -> new Piloto("20-12345678-0", 123, "Ocampo", "jose", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_fechaNacimientoNula() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = null;
        assertThrows(FechaNulaException.class,
                () -> new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento));
    }

    @Test
    void creacionPiloto_creacionIncorrecta_cuilFormatoIcorrecto() throws
            NullPointerException, StringNuloException, FechaNulaException, EnteroNegativoException,
            CuilIncorrectoException, NombreApellidoFormatoIncorrectoException, ParseException {

        // Arrange
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        assertThrows(CuilIncorrectoException.class,
                () -> new Piloto("2012-345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento));
    }
}