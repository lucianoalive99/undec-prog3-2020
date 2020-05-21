package exepciones;

public class CuilIncorrectoException extends Exception {
    public CuilIncorrectoException(String salida) {
        super();
        System.out.println(salida);
    }
}
