package modelo;

import exception.DomicilioDuplicadoException;
import exception.PersonaFisicaAccionInvalidaException;
import java.util.ArrayList;

public class MorosoState implements IPersonaFisicaState {

  private PersonaFisica p;

  public MorosoState(PersonaFisica p) {
    this.p = p;
  }

  @Override
  public double pagarFactura(IFactura factura, String metodoPago)
    throws PersonaFisicaAccionInvalidaException {
    factura.setPrecio(factura.getPrecio() * 1.3); // recargo 30%
    double precio = factura.pagar(factura, metodoPago).getPrecio(); // paga factura

    ArrayList<IFactura> lista = p.getUltimasFacturas(2);

    boolean a = lista.get(0).isPagada();
    boolean b = lista.get(1).isPagada();

    if (a || b) this.p.setEstado(new ConContratacionState(this.p)); // cambia de estado

    return precio;
  }

  @Override
  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio
  ) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException {
    throw new PersonaFisicaAccionInvalidaException(p);
  }

  @Override
  public void bajaServicioContratado(int idMonitoreo)
    throws PersonaFisicaAccionInvalidaException {
    throw new PersonaFisicaAccionInvalidaException(p);
  }

  @Override
  public void actualizarMes() {}

  @Override
  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio,
    String promo
  ) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException {
    throw new PersonaFisicaAccionInvalidaException(p);
  }
}
