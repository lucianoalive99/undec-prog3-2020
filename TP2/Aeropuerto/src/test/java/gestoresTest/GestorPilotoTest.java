package gestoresTest;

import clases.Piloto;
import exepciones.*;
import gestores.GestorPiloto;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GestorPilotoTest {

    @Test
    void crearPiloto_creacionCorrecta() throws
            EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException,
            ParseException, NombreApellidoFormatoIncorrectoException {

        GestorPiloto gesPilotos = new GestorPiloto(new LinkedList<Piloto>());
        int pilotosEnColeccion = gesPilotos.getColeccionPilotos().size();

        // Act
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento=null;
        try {
            fechaNacimiento = formato.parse("20-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto elPiloto = gesPilotos.crearPiloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimiento);
        gesPilotos.agregarPiloto(elPiloto);

        int pilotosLuegoDeCrear = gesPilotos.getColeccionPilotos().size();

        // Assert
        assertEquals((pilotosEnColeccion + 1), pilotosLuegoDeCrear);

    }

    @Test
    void crearPiloto_yaExistePilotoPorCuil() throws
            NullPointerException, StringNuloException, FechaIncorrectaException,
            MatriculaIncorrectaException, FechaNulaException, CuilIncorrectoException,
            NombreApellidoFormatoIncorrectoException, ParseException, EnteroNegativoException {

        GestorPiloto gesPilotos = new GestorPiloto(new LinkedList<Piloto>());

        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento=null;
        try {
            fechaNacimiento = formato.parse("20-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        gesPilotos.getColeccionPilotos().add(new Piloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimiento));
        int pilotosEnColeccion = gesPilotos.getColeccionPilotos().size();

        Piloto elPiloto = gesPilotos.crearPiloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimiento);
        gesPilotos.agregarPiloto(elPiloto);

        boolean faldoCrearPiloto = gesPilotos.agregarPiloto(elPiloto);
        if(!faldoCrearPiloto){
            System.out.println("El CUIL ya existe, no se puede crear un piloto nuevo con este CUIL.");
        }

        // Assert
        assertFalse(faldoCrearPiloto);
        assertEquals(pilotosEnColeccion, gesPilotos.getColeccionPilotos().size());

    }

    @Test
    void ConsultarPiloto_buscarPilotoPorLegajo() throws EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException {
        GestorPiloto gesPiloto = new GestorPiloto(new LinkedList<Piloto>());
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimientop1=null;
        try {
            fechaNacimientop1 = formato.parse("20-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p1 = gesPiloto.crearPiloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimientop1);

     //Piloto 2
        Date fechaNacimientop2=null;
        try {
            fechaNacimientop2 = formato.parse("10-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p2 = gesPiloto.crearPiloto("20-35345678-1", 124, "Oliva",
                "Antonio", fechaNacimientop2);

        //Piloto 3
        Date fechaNacimientop3=null;
        try {
            fechaNacimientop3 = formato.parse("10-5-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p3 = gesPiloto.crearPiloto("20-20345998-2", 125, "Arce",
                "Gabriel", fechaNacimientop3);

        //Piloto 4
        Date fechaNacimientop4=null;
        try {
            fechaNacimientop4 = formato.parse("28-6-1987");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p4 = gesPiloto.crearPiloto("20-27345000-5", 126, "Gaitan",
                "Federico", fechaNacimientop3);

        gesPiloto.agregarPiloto(p1);
        gesPiloto.agregarPiloto(p2);
        gesPiloto.agregarPiloto(p3);
        gesPiloto.agregarPiloto(p4);

        Piloto pilotoBuscado = gesPiloto.buscarPilotoPorLegajo(126);

        assertEquals(p4.getLegajo(),pilotoBuscado.getLegajo());
    }

    @Test
    void ConsultarPiloto_buscarPilotoPorLegajoyModificarFechaNacimiento() throws EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException {

        GestorPiloto gesPiloto = new GestorPiloto(new LinkedList<Piloto>());
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimientop1=null;
        try {
            fechaNacimientop1 = formato.parse("20-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p1 = gesPiloto.crearPiloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimientop1);

        //Piloto 2
        Date fechaNacimientop2=null;
        try {
            fechaNacimientop2 = formato.parse("10-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p2 = gesPiloto.crearPiloto("20-35345678-1", 124, "Oliva",
                "Antonio", fechaNacimientop2);

        //Piloto 3
        Date fechaNacimientop3=null;
        try {
            fechaNacimientop3 = formato.parse("10-5-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p3 = gesPiloto.crearPiloto("20-20345998-2", 125, "Arce",
                "Gabriel", fechaNacimientop3);

        //Piloto 4
        Date fechaNacimientop4=null;
        try {
            fechaNacimientop4 = formato.parse("28-6-1987");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p4 = gesPiloto.crearPiloto("20-27345000-5", 126, "Gaitan",
                "Federico", fechaNacimientop3);

        gesPiloto.agregarPiloto(p1);
        gesPiloto.agregarPiloto(p2);
        gesPiloto.agregarPiloto(p3);
        gesPiloto.agregarPiloto(p4);

        Piloto pilotoBuscado = gesPiloto.buscarPilotoPorLegajo(126);

        Date fechaModificar = null;

        try {
            fechaModificar = formato.parse("25-02-1975");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        gesPiloto.modificarPilotoFechaNacimiento(pilotoBuscado,fechaModificar);

        System.out.println(pilotoBuscado.getFechaNacimiento());

        assertEquals(fechaModificar,pilotoBuscado.getFechaNacimiento());
    }

    @Test
    void ConsultarPiloto_buscarPilotoPorLegajoyModificarApellido_nombre_cuil() throws EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException {

        GestorPiloto gesPiloto = new GestorPiloto(new LinkedList<Piloto>());
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimientop1=null;
        try {
            fechaNacimientop1 = formato.parse("20-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p1 = gesPiloto.crearPiloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimientop1);

        //Piloto 2
        Date fechaNacimientop2=null;
        try {
            fechaNacimientop2 = formato.parse("10-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p2 = gesPiloto.crearPiloto("20-35345678-1", 124, "Oliva",
                "Antonio", fechaNacimientop2);

        //Piloto 3
        Date fechaNacimientop3=null;
        try {
            fechaNacimientop3 = formato.parse("10-5-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p3 = gesPiloto.crearPiloto("20-20345998-2", 125, "Arce",
                "Gabriel", fechaNacimientop3);

        //Piloto 4
        Date fechaNacimientop4=null;
        try {
            fechaNacimientop4 = formato.parse("28-6-1987");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p4 = gesPiloto.crearPiloto("20-27345000-5", 126, "Gaitan",
                "Federico", fechaNacimientop3);

        gesPiloto.agregarPiloto(p1);
        gesPiloto.agregarPiloto(p2);
        gesPiloto.agregarPiloto(p3);
        gesPiloto.agregarPiloto(p4);

        Piloto pilotoBuscado = gesPiloto.buscarPilotoPorLegajo(126);

        String cuilModificar=null;
        String apellidoModificar="Ortiz";
        String nombreModificar = null;


        gesPiloto.modificarPilotoApellidoNombreCuil(pilotoBuscado,cuilModificar,apellidoModificar,nombreModificar);

        System.out.println(pilotoBuscado.getApellido());

        assertEquals(apellidoModificar,pilotoBuscado.getApellido());
    }

    @Test
    void listarTodosLosPilotos() throws EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException {
        GestorPiloto gesPiloto = new GestorPiloto(new LinkedList<Piloto>());
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimientop1=null;
        try {
            fechaNacimientop1 = formato.parse("20-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p1 = gesPiloto.crearPiloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimientop1);

        //Piloto 2
        Date fechaNacimientop2=null;
        try {
            fechaNacimientop2 = formato.parse("10-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p2 = gesPiloto.crearPiloto("20-35345678-1", 124, "Oliva",
                "Antonio", fechaNacimientop2);

        //Piloto 3
        Date fechaNacimientop3=null;
        try {
            fechaNacimientop3 = formato.parse("10-5-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p3 = gesPiloto.crearPiloto("20-20345998-2", 125, "Arce",
                "Gabriel", fechaNacimientop3);

        //Piloto 4
        Date fechaNacimientop4=null;
        try {
            fechaNacimientop4 = formato.parse("28-6-1987");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p4 = gesPiloto.crearPiloto("20-27345000-5", 126, "Gaitan",
                "Federico", fechaNacimientop3);

        gesPiloto.agregarPiloto(p1);
        gesPiloto.agregarPiloto(p2);
        gesPiloto.agregarPiloto(p3);
        gesPiloto.agregarPiloto(p4);

        gesPiloto.listarPilotos();
    }

    @Test
    void listarPilotos_porApellido() throws EnteroNegativoException, StringNuloException, FechaNulaException, CuilIncorrectoException, ParseException, NombreApellidoFormatoIncorrectoException {
        GestorPiloto gesPiloto = new GestorPiloto(new LinkedList<Piloto>());
        //Formato Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimientop1=null;
        try {
            fechaNacimientop1 = formato.parse("20-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p1 = gesPiloto.crearPiloto("20-12345678-0", 123, "Ocampo", "Jose", fechaNacimientop1);

        //Piloto 2
        Date fechaNacimientop2=null;
        try {
            fechaNacimientop2 = formato.parse("10-5-1980");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p2 = gesPiloto.crearPiloto("20-35345678-1", 124, "Oliva",
                "Antonio", fechaNacimientop2);

        //Piloto 3
        Date fechaNacimientop3=null;
        try {
            fechaNacimientop3 = formato.parse("10-5-1965");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p3 = gesPiloto.crearPiloto("20-20345998-2", 125, "Arce",
                "Gabriel", fechaNacimientop3);

        //Piloto 4
        Date fechaNacimientop4=null;
        try {
            fechaNacimientop4 = formato.parse("28-6-1987");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p4 = gesPiloto.crearPiloto("20-27345000-5", 126, "Gaitan",
                "Federico", fechaNacimientop4);

        //Piloto 5
        Date fechaNacimientop5=null;
        try {
            fechaNacimientop5 = formato.parse("12-9-1973");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p5 = gesPiloto.crearPiloto("21-29855111-6", 127, "Gaitan",
                "Angel", fechaNacimientop5);

        //Piloto 6
        Date fechaNacimientop6=null;
        try {
            fechaNacimientop6 = formato.parse("1-1-1991");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Piloto p6 = gesPiloto.crearPiloto("20-18292331-2", 128, "Gaitan",
                "Jesus", fechaNacimientop6);

        gesPiloto.agregarPiloto(p1);
        gesPiloto.agregarPiloto(p2);
        gesPiloto.agregarPiloto(p3);
        gesPiloto.agregarPiloto(p4);
        gesPiloto.agregarPiloto(p5);
        gesPiloto.agregarPiloto(p6);

        gesPiloto.buscarPilotosPorApellido("Gaitan");
    }
}
