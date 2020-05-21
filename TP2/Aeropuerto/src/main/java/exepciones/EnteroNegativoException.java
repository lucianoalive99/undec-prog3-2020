package exepciones;

public class EnteroNegativoException extends Exception {
    public EnteroNegativoException(String salida) {
        super();
        System.out.println(salida);
    }
}
