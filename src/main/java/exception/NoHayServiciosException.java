package exception;

import modelo.Abonado;

public class NoHayServiciosException extends Exception {

  Abonado abonado;

  public NoHayServiciosException(Abonado abonado) {
    super(
      "No hay ningun servicio asociado al abonado " +
      abonado.getNombre() +
      " con DNI " +
      abonado.getDni()
    );
    this.abonado = abonado;
  }

  public Abonado getAbonado() {
    return abonado;
  }
}
