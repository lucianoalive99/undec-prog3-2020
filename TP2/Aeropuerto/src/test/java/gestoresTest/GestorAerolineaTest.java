package gestoresTest;

import clases.Aerolinea;
import exepciones.*;
import gestores.GestorAerolinea;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GestorAerolineaTest {

    @Test
    void crearAerolinea_creacionCorrecta() throws
            EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException,
            ParseException, NombreApellidoFormatoIncorrectoException, CodigoIATAException, NuloException {

        GestorAerolinea gAero = new GestorAerolinea(new LinkedList<Aerolinea>());
        int AerolineasEnColeccion = gAero.getColeccionAerolineas().size();

        // Act
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha=null;
        try {
            fecha = formato.parse("14-05-1949");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Aerolinea laArolinea = gAero.crearAerolinea("20-12345678-0", "AR", "Aerolineas Argentinas", fecha);
        gAero.agregarAerolinea(laArolinea);

        int aerolineaLuegoDeCrear = gAero.getColeccionAerolineas().size();

        // Assert
        assertEquals((AerolineasEnColeccion + 1), aerolineaLuegoDeCrear);

    }

    @Test
    void crearAerolinea_yaExisteAerolineaporCUITCodigoIATA() throws
            EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException,
            ParseException, NombreApellidoFormatoIncorrectoException, CodigoIATAException, NuloException {

        GestorAerolinea gAero = new GestorAerolinea(new LinkedList<Aerolinea>());


        // Act
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha=null;
        try {
            fecha = formato.parse("14-05-1949");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        gAero.getColeccionAerolineas().add(new Aerolinea("20-12345678-0", "AR", "Aerolineas Argentinas", fecha));
        int AerolineasEnColeccion = gAero.getColeccionAerolineas().size();
        Aerolinea laArolinea = gAero.crearAerolinea("20-12345678-0", "AR", "Aerolineas Argentinas", fecha);
        gAero.agregarAerolinea(laArolinea);

        int aerolineaLuegoDeCrear = gAero.getColeccionAerolineas().size();

        boolean falsoCrearAerolinea = gAero.agregarAerolinea(laArolinea);
        if(!falsoCrearAerolinea){
            System.out.println("El CUIT/Codigo IATA ya existe, no se puede crear un piloto nuevo con este CUIT/Codigo IATA.");
        }
        // Assert
        assertFalse(falsoCrearAerolinea);
        assertEquals(AerolineasEnColeccion, gAero.getColeccionAerolineas().size());

    }

    @Test
    void consultarAerolinea_buscarAerolineaporNombre() throws
            StringNuloException, FechaNulaException, CuilIncorrectoException, CodigoIATAException,
            NombreApellidoFormatoIncorrectoException, NuloException {
        GestorAerolinea gAero = new GestorAerolinea(new LinkedList<Aerolinea>());
        // Act
       //Aerolinea 1
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha=null;
        try {
            fecha = formato.parse("14-05-1949");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea = gAero.crearAerolinea("20-12345678-0", "AR", "Aerolineas Argentinas", fecha);

        //Aerolinea 2
        //Formato Fecha

        Date fecha2=null;
        try {
            fecha2 = formato.parse("18-06-1953");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea2 = gAero.crearAerolinea("21-45345678-9", "AB", "Austral", fecha2);

        //Aerolinea 3
        //Formato Fecha

        Date fecha3 =null;
        try {
            fecha3 = formato.parse("1-7-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea3 = gAero.crearAerolinea("27-44445623-7", "LT", "Latam", fecha3);

        gAero.agregarAerolinea(laArolinea);
        gAero.agregarAerolinea(laArolinea2);
        gAero.agregarAerolinea(laArolinea3);

        gAero.buscarAerolineaPorNombre("Austral");


    }

    @Test
    void consultarAerolinea_buscarAerolineaporNombreModificarCUITIATANombre() throws
            StringNuloException, FechaNulaException, CuilIncorrectoException, CodigoIATAException,
            NombreApellidoFormatoIncorrectoException, NuloException {
        GestorAerolinea gAero = new GestorAerolinea(new LinkedList<Aerolinea>());
        // Act
        //Aerolinea 1
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha=null;
        try {
            fecha = formato.parse("14-05-1949");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea = gAero.crearAerolinea("20-12345678-0", "AR", "Aerolineas Argentinas", fecha);

        //Aerolinea 2
        //Formato Fecha

        Date fecha2=null;
        try {
            fecha2 = formato.parse("18-06-1953");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea2 = gAero.crearAerolinea("21-45345678-9", "AB", "Austral", fecha2);

        //Aerolinea 3
        //Formato Fecha

        Date fecha3 =null;
        try {
            fecha3 = formato.parse("1-7-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea3 = gAero.crearAerolinea("27-44445623-7", "LT", "Latam", fecha3);

        gAero.agregarAerolinea(laArolinea);
        gAero.agregarAerolinea(laArolinea2);
        gAero.agregarAerolinea(laArolinea3);

        Aerolinea buscada = gAero.buscarAerolinea("Austral");

        System.out.println(buscada.getCUIT());
        String cuiTModificar =null;
        String iataModificar ="GL";
        String nombreModificar = null;

        gAero.modificarAerolinea_cuitIataNombre(buscada,cuiTModificar,iataModificar,nombreModificar);

        System.out.println(buscada.getCodigoIATA());

        assertEquals(iataModificar,buscada.getCodigoIATA());
    }

    @Test
    void consultarAerolinea_buscarAerolineaporNombreModificarfecha() throws
            StringNuloException, FechaNulaException, CuilIncorrectoException, CodigoIATAException,
            NombreApellidoFormatoIncorrectoException, NuloException {
        GestorAerolinea gAero = new GestorAerolinea(new LinkedList<Aerolinea>());
        // Act
        //Aerolinea 1
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha=null;
        try {
            fecha = formato.parse("14-05-1949");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea = gAero.crearAerolinea("20-12345678-0", "AR", "Aerolineas Argentinas", fecha);

        //Aerolinea 2
        //Formato Fecha

        Date fecha2=null;
        try {
            fecha2 = formato.parse("18-06-1953");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea2 = gAero.crearAerolinea("21-45345678-9", "AB", "Austral", fecha2);

        //Aerolinea 3
        //Formato Fecha

        Date fecha3 =null;
        try {
            fecha3 = formato.parse("1-7-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea laArolinea3 = gAero.crearAerolinea("27-44445623-7", "LT", "Latam", fecha3);

        gAero.agregarAerolinea(laArolinea);
        gAero.agregarAerolinea(laArolinea2);
        gAero.agregarAerolinea(laArolinea3);

        Aerolinea buscada = gAero.buscarAerolinea("Austral");


        Date fechaModificar =null;
        try {
            fechaModificar = formato.parse("30-08-1970");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        gAero.modificarAerolinea_fecha(buscada,fechaModificar);

        System.out.println(buscada.getFechaIA());

        assertEquals(fechaModificar,buscada.getFechaIA());
    }
}
