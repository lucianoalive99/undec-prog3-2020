package exepciones;

public class FechaIncorrectaException extends Exception{
    public FechaIncorrectaException(String salida) {
        super();
        System.out.println(salida);
    }
}
