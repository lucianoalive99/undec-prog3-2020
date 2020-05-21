package exepciones;

public class NuloException extends Exception{
    public NuloException(String salida) {
        super();
        System.out.println(salida);
    }
}
