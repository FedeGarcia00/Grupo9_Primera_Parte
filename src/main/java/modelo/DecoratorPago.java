package modelo;

import java.util.Iterator;

public abstract class DecoratorPago implements IFactura {

  private IFactura encapsulado;

  public DecoratorPago(IFactura encapsulado) {
    super();
    this.encapsulado = encapsulado;
  }

  public abstract double getPrecioFinal();

  public IFactura getEncapsulado() {
    return encapsulado;
  }

  public double getPrecio() {
    return encapsulado.getPrecio();
  }

  public Abonado getAbonado() {
    return encapsulado.getAbonado();
  }

  @Override
  public String toString() {
    Abonado abonado = getAbonado();
    String factura = "";
    Iterator<Monitoreo> iterator = abonado.getListaMonitoreos();

    factura +=
      "Nombre: " +
      abonado.getNombre() +
      "\n" +
      "Dni: " +
      abonado.getDni() +
      "\n";

    while (iterator.hasNext()) {
      Monitoreo monitoreo = iterator.next();
      factura +=
        "[" +
        monitoreo.getId() +
        "] - Direccion: " +
        monitoreo.getDomicilio() +
        " $" +
        monitoreo.calculaPrecio() +
        "\n";
    }
    factura += "Precio sin descuento: " + encapsulado.getPrecio() + "\n";
    factura += "Precio con descuento: " + getPrecioFinal();
    return factura;
  }

  @Override
  public DecoratorPago clone() throws CloneNotSupportedException {
    DecoratorPago clonado = null;
    clonado = (DecoratorPago) super.clone();
    clonado.encapsulado = (IFactura) this.encapsulado.clone();
    return clonado;
  }
}
