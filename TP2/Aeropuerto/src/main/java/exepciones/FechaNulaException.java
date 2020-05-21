package exepciones;

public class FechaNulaException extends Exception {
    public FechaNulaException(String salida) {
        super();
        System.out.println(salida);
    }
}
