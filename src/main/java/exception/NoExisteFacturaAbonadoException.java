package exception;

public class NoExisteFacturaAbonadoException extends Exception {

  String dni;

  public NoExisteFacturaAbonadoException(String dni) {
    super("No existe factura para el abonado con el dni: " + dni);
    this.dni = dni;
  }

  public String getDni() {
    return dni;
  }
}
