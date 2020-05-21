package clasesTest;

import clases.*;
import exepciones.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VueloTest {

    @Test
    void crearVuelo_CreacionCorrecta() throws StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException, EnteroNegativoException, NuloException, CodigoIATAException, FechaIncorrectaException, MatriculaIncorrectaException {

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

        Vuelo elVuelo = new Vuelo((laAeroliena.getCodigoIATA()+" 1234"),
                LocalDateTime.of(2020,07,18,20,50),
                LocalDateTime.of(2020,07,19,07,30),
                salida, llegada, elAvion1,comandante,copiloto,laAeroliena);



        assertEquals("AR 1234", elVuelo.getCodigoVuelo());
        assertEquals(LocalDateTime.of(2020,07,18,20,50),elVuelo.getSalida());
    }
