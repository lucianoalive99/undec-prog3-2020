package exepciones;

public class CodigoIATAException extends Exception {
    public CodigoIATAException(String salida) {
        super();
        System.out.println(salida);
    }
}

