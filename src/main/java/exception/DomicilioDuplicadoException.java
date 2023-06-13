package exception;

import modelo.Domicilio;

public class DomicilioDuplicadoException extends Exception {

  private Domicilio domicilio;

  public DomicilioDuplicadoException(Domicilio domicilio) {
    super("Domicilio duplicado: " + domicilio.toString());
    this.domicilio = domicilio;
  }

  public Domicilio getDomicilio() {
    return domicilio;
  }
}
