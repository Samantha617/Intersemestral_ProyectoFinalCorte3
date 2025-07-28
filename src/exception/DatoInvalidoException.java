package exception;

//Excepción personalizada que se lanza cuando un dato ingresado no es valido.
public class DatoInvalidoException extends Exception {
    
    // Constructor que recibe el mensaje de error personalizado
    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
