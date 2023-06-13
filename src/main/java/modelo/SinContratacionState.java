package modelo;

import exception.DomicilioDuplicadoException;
import exception.PersonaFisicaAccionInvalidaException;

public class SinContratacionState implements IPersonaFisicaState {

  private PersonaFisica p;

  public SinContratacionState(PersonaFisica p) {
    this.p = p;
  }

  @Override
  public double pagarFactura(IFactura factura, String metodoPago)
    throws PersonaFisicaAccionInvalidaException {
    throw new PersonaFisicaAccionInvalidaException(p);
  }

  @Override
  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio
  ) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException {
    // cambiar de estado
    this.p.setEstado(new ConContratacionState(this.p));
    if (p.buscaDomicilio(domicilio)) {
      throw new DomicilioDuplicadoException(domicilio);
    }
    Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(
      domicilio,
      cantCamaras,
      cantBotones,
      movilAcompanamiento,
      servicio
    );
    p.listaMonitoreos.add(monitoreo);
  }

  @Override
  public void bajaServicioContratado(int idMonitoreo)
    throws PersonaFisicaAccionInvalidaException {
    throw new PersonaFisicaAccionInvalidaException(p);
  }

  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio,
    String promo
  ) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException {
    if (p.buscaDomicilio(domicilio)) {
      throw new DomicilioDuplicadoException(domicilio);
    }
    Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(
      domicilio,
      cantCamaras,
      cantBotones,
      movilAcompanamiento,
      servicio
    );
    if (promo == "PromoDorada") {
      monitoreo.setPromo(PromoDorada.getInstancia());
    } else if (promo == "PromoPlatino") {
      monitoreo.setPromo(PromoPlatino.getInstancia());
    }
    p.listaMonitoreos.add(monitoreo);
  }

  @Override
  public void actualizarMes() {}
}
