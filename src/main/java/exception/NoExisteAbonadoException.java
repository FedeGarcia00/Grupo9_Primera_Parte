package exception;

public class NoExisteAbonadoException extends Exception {

  String dni;

  public NoExisteAbonadoException(String dni) {
    super("No existe un abonado con el dni " + dni);
    this.dni = dni;
  }

  public String getDni() {
    return dni;
  }
}
