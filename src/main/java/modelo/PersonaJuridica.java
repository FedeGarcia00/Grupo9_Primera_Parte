package modelo;

import exception.DomicilioDuplicadoException;
import java.util.Iterator;

public class PersonaJuridica extends Abonado {

  public PersonaJuridica(String nombre, String dni) {
    super(nombre, dni);
  }

  @Override
  public double aplicarDescuentoCantidad(double monto, int cantidad) {
    return cantidad < 3 ? monto : monto / 2;
  }

  public PersonaJuridica clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException(
      "Los abonados de tipo persona juridica no son clonables"
    );
  }

  public double pagarFactura(IFactura factura, String metodoPago) {
    double precio = factura.pagar(factura, metodoPago).getPrecio(); // paga factura
    return precio;
  }

  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio
  ) throws DomicilioDuplicadoException {
    if (this.buscaDomicilio(domicilio)) {
      throw new DomicilioDuplicadoException(domicilio);
    }
    Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(
      domicilio,
      cantCamaras,
      cantBotones,
      movilAcompanamiento,
      servicio
    );
    listaMonitoreos.add(monitoreo);
  }

  public void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio,
    String promo
  ) throws DomicilioDuplicadoException {
    if (this.buscaDomicilio(domicilio)) {
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
    listaMonitoreos.add(monitoreo);
  }

  public void bajaServicioContratado(int id) {
    Iterator<Monitoreo> iterator = this.getListaMonitoreos();
    Monitoreo monitoreo = null;
    boolean encontrado = false;

    while (iterator.hasNext() && !encontrado) {
      monitoreo = iterator.next();
      if (monitoreo.getId() == id) {
        monitoreo.setEstadoFinDeMes(true);
        encontrado = true;
      }
    }
  }

  @Override
  public void actualizarMes() {}
}
