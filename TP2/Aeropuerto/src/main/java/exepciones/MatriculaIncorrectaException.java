package exepciones;

public class MatriculaIncorrectaException extends Exception{
    public MatriculaIncorrectaException(String salida) {
        super();
        System.out.println(salida);
    }
}
