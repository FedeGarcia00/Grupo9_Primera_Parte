package modelo;

import exception.DomicilioDuplicadoException;
import exception.PersonaFisicaAccionInvalidaException;

public interface IPersonaFisicaState {
  double pagarFactura(IFactura factura, String metodoPago)
    throws PersonaFisicaAccionInvalidaException;

  void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio
  ) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException;

  void bajaServicioContratado(int idMonitoreo)
    throws PersonaFisicaAccionInvalidaException;

  void actualizarMes();

  void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio,
    String promo
  ) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException;
}
