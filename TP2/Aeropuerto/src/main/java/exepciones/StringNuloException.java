package exepciones;

public class StringNuloException extends Exception  {

    public StringNuloException(String salida) {
        super();
        System.out.println(salida);
    }
}
