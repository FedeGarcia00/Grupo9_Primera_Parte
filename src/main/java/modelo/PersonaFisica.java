package modelo;

import exception.DomicilioDuplicadoException;
import exception.PersonaFisicaAccionInvalidaException;

public class PersonaFisica extends Abonado {

  private IPersonaFisicaState estado;

  public PersonaFisica(String nombre, String dni) {
    super(nombre, dni);
    estado = new SinContratacionState(this);
  }

  @Override
  public double aplicarDescuentoCantidad(double monto, int cantidad) {
    return monto;
  }

  public PersonaFisica clone() {
    try {
      PersonaFisica personaFisicaClonada = (PersonaFisica) super.clone();
      return personaFisicaClonada;
    } catch (CloneNotSupportedException e) { // Nunca va a entrar aca
      throw new RuntimeException(e);
    }
  }

  public IPersonaFisicaState getEstado() {
    return estado;
  }

  public void setEstado(IPersonaFisicaState estado) {
    this.estado = estado;
  }

  @Override
  public double pagarFactura(IFactura factura, String metodoPago)
    throws PersonaFisicaAccionInvalidaException {
    return this.estado.pagarFactura(factura, metodoPago);
  }

  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio
  ) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException {
    this.estado.agregarMonitoreo(
        domicilio,
        cantCamaras,
        cantBotones,
        movilAcompanamiento,
        servicio
      );
  }

  public void bajaServicioContratado(int idMonitoreo)
    throws PersonaFisicaAccionInvalidaException {
    this.estado.bajaServicioContratado(idMonitoreo);
  }

  public void actualizarMes() {
    this.estado.actualizarMes();
  }

  @Override
  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio,
    String promo
  ) throws DomicilioDuplicadoException, PersonaFisicaAccionInvalidaException {
    this.estado.agregarMonitoreo(
        domicilio,
        cantCamaras,
        cantBotones,
        movilAcompanamiento,
        servicio,
        promo
      );
  }
}
