package gestoresTest;

import clases.*;
import exepciones.*;
import gestores.GestorVuelo;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestorVueloTest {
    @Test
    void creacionVuelo_creacionCorrecta() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {
        GestorVuelo elGestor = new GestorVuelo(new LinkedList<Vuelo>());
        int vuelosEnColeccion = elGestor.getColeccionVuelos().size();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        Piloto comandante = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento);
        Date fecha1 = formato.parse("20-07-1990");
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento2 = fechaNacimiento;
        Piloto copiloto = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento2);

        Aeropuerto salida = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto llegada = new Aeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);
        Avion elAvion2 = new Avion("LV-CDZ","Embraer 190",96,2016);

        Vuelo vuelo1 = elGestor.CrearVuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);

        elGestor.agregarVuelos(vuelo1);

        int pilotosLuegoDeCrear = elGestor.getColeccionVuelos().size();

        // Assert
        assertEquals((vuelosEnColeccion + 1), pilotosLuegoDeCrear);
    }

    @Test
    void modificarVuelo_modificarAvion() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {
        GestorVuelo elGestor = new GestorVuelo(new LinkedList<Vuelo>());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        Piloto comandante = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento);
        Date fecha1 = formato.parse("20-07-1990");
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento2 = fechaNacimiento;
        Piloto copiloto = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento2);

        Aeropuerto salida = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto llegada = new Aeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);


        Vuelo vuelo1 = elGestor.CrearVuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);

        System.out.println(vuelo1.getCodigoVuelo());
        elGestor.agregarVuelos(vuelo1);

        Date fechaNacimiento3=null;
        try {
            Date fechaNacimiento5 = formato.parse("20-5-1980");
            fechaNacimiento3 = fechaNacimiento5;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento3 = fechaNacimiento3;


        Date fechaNacimiento4=null;
        try {
            Date fechaNacimiento6 = formato.parse("20-5-1980");
            fechaNacimiento4 = fechaNacimiento6;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento4 = fechaNacimiento4;
        Piloto copilotoModificar = new Piloto("25-12345678-0", 130, "Ocam", "Jo", finalFechaNacimiento4);
        Piloto comandanteModificar = new Piloto("20-12346666-7", 131, "Ocamp", "Jos", finalFechaNacimiento3);
        LocalDateTime salidaModificar = LocalDateTime.of(2020,8,15,15,50);
        LocalDateTime arriboModificar = LocalDateTime.of(2020,8,16,01,00);
        Avion elAvion2 = new Avion("LV-CDZ","Embraer 190",96,2016);

        elGestor.modificarVueloAvion(vuelo1,elAvion2);
        // Assert
        assertEquals(elAvion2, vuelo1.getAvion());
    }

    @Test
    void modificarVuelo_modificarComandante() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {
        GestorVuelo elGestor = new GestorVuelo(new LinkedList<Vuelo>());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        Piloto comandante = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento);
        Date fecha1 = formato.parse("20-07-1990");
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento2 = fechaNacimiento;
        Piloto copiloto = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento2);

        Aeropuerto salida = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto llegada = new Aeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);


        Vuelo vuelo1 = elGestor.CrearVuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);

        System.out.println(vuelo1.getCodigoVuelo());
        elGestor.agregarVuelos(vuelo1);

        Date fechaNacimiento3=null;
        try {
            Date fechaNacimiento5 = formato.parse("20-5-1980");
            fechaNacimiento3 = fechaNacimiento5;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento3 = fechaNacimiento3;


        Date fechaNacimiento4=null;
        try {
            Date fechaNacimiento6 = formato.parse("20-5-1980");
            fechaNacimiento4 = fechaNacimiento6;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento4 = fechaNacimiento4;
        Piloto copilotoModificar = new Piloto("25-12345678-0", 130, "Ocam", "Jo", finalFechaNacimiento4);
        Piloto comandanteModificar = new Piloto("20-12346666-7", 131, "Ocamp", "Jos", finalFechaNacimiento3);
        LocalDateTime salidaModificar = LocalDateTime.of(2020,8,15,15,50);
        LocalDateTime arriboModificar = LocalDateTime.of(2020,8,16,01,00);
        Avion elAvion2 = new Avion("LV-CDZ","Embraer 190",96,2016);

        elGestor.modificarVuelocomandante(vuelo1,comandanteModificar);
        // Assert
        assertEquals(comandanteModificar, vuelo1.getComandante());
    }

    @Test
    void modificarVuelo_modificarCopiloto() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {
        GestorVuelo elGestor = new GestorVuelo(new LinkedList<Vuelo>());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        Piloto comandante = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento);
        Date fecha1 = formato.parse("20-07-1990");
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento2 = fechaNacimiento;
        Piloto copiloto = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento2);

        Aeropuerto salida = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto llegada = new Aeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);


        Vuelo vuelo1 = elGestor.CrearVuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);

        elGestor.agregarVuelos(vuelo1);

        Date fechaNacimiento3=null;
        try {
            Date fechaNacimiento5 = formato.parse("20-5-1980");
            fechaNacimiento3 = fechaNacimiento5;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento3 = fechaNacimiento3;


        Date fechaNacimiento4=null;
        try {
            Date fechaNacimiento6 = formato.parse("20-5-1980");
            fechaNacimiento4 = fechaNacimiento6;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento4 = fechaNacimiento4;
        Piloto copilotoModificar = new Piloto("25-12345678-0", 130, "Ocam", "Jo", finalFechaNacimiento4);
        Piloto comandanteModificar = new Piloto("20-12346666-7", 131, "Ocamp", "Jos", finalFechaNacimiento3);
        LocalDateTime salidaModificar = LocalDateTime.of(2020,8,15,15,50);
        LocalDateTime arriboModificar = LocalDateTime.of(2020,8,16,01,00);
        Avion elAvion2 = new Avion("LV-CDZ","Embraer 190",96,2016);

        elGestor.modificarVueloCopiloto(vuelo1,copilotoModificar);
        // Assert
        assertEquals(copilotoModificar, vuelo1.getCopiloto());
    }

    @Test
    void modificarVuelo_modificarSalidaArribo() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {
        GestorVuelo elGestor = new GestorVuelo(new LinkedList<Vuelo>());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        Piloto comandante = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento);
        Date fecha1 = formato.parse("20-07-1990");
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento2 = fechaNacimiento;
        Piloto copiloto = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento2);

        Aeropuerto salida = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto llegada = new Aeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);


        Vuelo vuelo1 = elGestor.CrearVuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);

        elGestor.agregarVuelos(vuelo1);

        Date fechaNacimiento3=null;
        try {
            Date fechaNacimiento5 = formato.parse("20-5-1980");
            fechaNacimiento3 = fechaNacimiento5;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento3 = fechaNacimiento3;


        Date fechaNacimiento4=null;
        try {
            Date fechaNacimiento6 = formato.parse("20-5-1980");
            fechaNacimiento4 = fechaNacimiento6;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento4 = fechaNacimiento4;
        Piloto copilotoModificar = new Piloto("25-12345678-0", 130, "Ocam", "Jo", finalFechaNacimiento4);
        Piloto comandanteModificar = new Piloto("20-12346666-7", 131, "Ocamp", "Jos", finalFechaNacimiento3);
        LocalDateTime salidaModificar = LocalDateTime.of(2020,8,15,15,50);
        LocalDateTime arriboModificar = LocalDateTime.of(2020,8,16,01,00);
        Avion elAvion2 = new Avion("LV-CDZ","Embraer 190",96,2016);

        elGestor.modificarVueloSalidaArribo(vuelo1,salidaModificar,arriboModificar);
        // Assert
        assertEquals(salidaModificar, vuelo1.getSalida());
        assertEquals(arriboModificar, vuelo1.getArribo());
    }

    @Test
    void bucarVuelo_porFecha() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {
        GestorVuelo elGestor = new GestorVuelo(new LinkedList<Vuelo>());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        Piloto comandante = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento);
        Date fecha1 = formato.parse("20-07-1990");
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento2 = fechaNacimiento;
        Piloto copiloto = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento2);

        Aeropuerto salida = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto llegada = new Aeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);




        Vuelo vuelo1 = elGestor.CrearVuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);

        elGestor.agregarVuelos(vuelo1);
        LocalDateTime fechabuscar = LocalDateTime.of(2020,07,18,0,0);
        elGestor.buscarVueloPorFecha(fechabuscar);

    }

    @Test
    void bucarVuelo_porAerolinea() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {
        GestorVuelo elGestor = new GestorVuelo(new LinkedList<Vuelo>());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento2=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento2 = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento = fechaNacimiento2;
        Piloto comandante = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento);
        Date fecha1 = formato.parse("20-07-1990");
        Aerolinea laAeroliena = new Aerolinea("30-64140555-4","AR","Aerolineas Aregntinas",fecha1);
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("20-5-1980");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalFechaNacimiento2 = fechaNacimiento;
        Piloto copiloto = new Piloto("20-12345678-0", 123, "Ocampo", "Jose", finalFechaNacimiento2);

        Aeropuerto salida = new Aeropuerto("EZE","Ministro Pistarini","Ezeiza",5360);
        Aeropuerto llegada = new Aeropuerto("IRJ","Almandos Almonacid","La Rioja",5361);

        Avion elAvion1 = new Avion("LV-CDY","Embraer 190",96,2015);




        Vuelo vuelo1 = elGestor.CrearVuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);

        elGestor.agregarVuelos(vuelo1);
        //LocalDateTime fechabuscar = LocalDateTime.of(2020,07,18,0,0);
        elGestor.buscarVueloPorAerolinea(laAeroliena.getNombre());

    }
}
