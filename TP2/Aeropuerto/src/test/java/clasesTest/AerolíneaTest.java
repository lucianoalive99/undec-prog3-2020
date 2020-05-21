package clasesTest;

import clases.Aerolinea;
import clases.Piloto;
import exepciones.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AerolineaTest {

    @Test
    void crearArolinea_creacionCorrecta() throws StringNuloException, NuloException, FechaNulaException,
            NombreApellidoFormatoIncorrectoException, CodigoIATAException, CuilIncorrectoException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);

        assertEquals("30-64140555-4",laAeroliena.getCUIT());
        assertEquals("AR",laAeroliena.getCodigoIATA());
        assertEquals("Aerolineas Aregntinas",laAeroliena.getNombre());
        assertEquals(fecha1,laAeroliena.getFechaIA());
    }

    @Test
    void crearArolinea_creacionIncorrecta_cuitnulo() throws NuloException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(NuloException.class,
                () -> new Aerolinea(null, "AR", "Aerolineas Aregntinas", finalFecha));
    }

    @Test
    void crearArolinea_creacionIncorrecta_cuitvacio() throws
            NullPointerException, StringNuloException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(StringNuloException.class,
                () -> new Aerolinea("", "AR", "Aerolineas Aregntinas", finalFecha));
    }

    @Test
    void crearArolinea_creacionIncorrecta_codigoIATAnulo() throws
            NuloException, StringNuloException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(NuloException.class,
                () -> new Aerolinea("30-64140555-4", null, "Aerolineas Aregntinas", finalFecha));
    }

    @Test
    void crearArolinea_creacionIncorrecta_codigoIATAvacio() throws
            NullPointerException, StringNuloException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(StringNuloException.class,
                () -> new Aerolinea("30-64140555-4", "", "Aerolineas Aregntinas", finalFecha));
    }

    @Test
    void crearArolinea_creacionIncorrecta_nombreNulo() throws
            NuloException, StringNuloException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(NuloException.class,
                () -> new Aerolinea("30-64140555-4", "AR", null, finalFecha));
    }

    @Test
    void crearArolinea_creacionIncorrecta_nombreVacio() throws
            NuloException, StringNuloException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(StringNuloException.class,
                () -> new Aerolinea("30-64140555-4", "AR", "", finalFecha));
    }

    @Test
    void crearArolinea_creacionIncorrecta_fechaNula() throws
            NuloException, StringNuloException, FechaNulaException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = null;
        assertThrows(FechaNulaException.class,
                () -> new Aerolinea("30-64140555-4", "AR", "Aerolinea Argentina", finalFecha));
    }

    @Test
    void creacionAerolinea_creacionIncorrecta_nombreFormatoIncorrecto() throws
            NuloException, StringNuloException, FechaNulaException, NombreApellidoFormatoIncorrectoException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(NombreApellidoFormatoIncorrectoException.class,
                () -> new Aerolinea("30-64140555-4", "AR", "Aerolineas argentina", finalFecha));
    }

    @Test
    void creacionAerolinea_creacionIncorrecta_codigoIATAFormatoIncorrecto() throws
            NuloException, StringNuloException, FechaNulaException,
            CodigoIATAException{

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(CodigoIATAException.class,
                () -> new Aerolinea("30-64140555-4", "ARA", "Aerolineas Argentina", finalFecha));
    }

    @Test
    void creacionAerolinea_creacionIncorrecta_cuitFormatoIncorrecto() throws
            NuloException, StringNuloException, FechaNulaException,
            CodigoIATAException, CuilIncorrectoException{

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        try {
            Date fecha2 = formato.parse("20-5-1980");
            fecha1 = fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date finalFecha = fecha1;
        assertThrows(CuilIncorrectoException.class,
                () -> new Aerolinea("306-4140555-4", "AR", "Aerolineas Argentina", finalFecha));
    }

}