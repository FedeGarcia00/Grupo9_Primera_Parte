package modelo;

import java.io.Serializable;

/**
 * Clase que crea nuevas instancias de factura. <br>
 * Con m�todos que calculan el precio total de todos los contratos realizados
 * por el Abonado
 * y otro m�todo que clona la factura solo si el Abonado es una persona fisica.
 * <br>
 */
public class Factura implements IFactura, Serializable {

  protected Abonado abonado;
  protected double precio;
  private boolean pagada;

  /**
   * Crea una nueva factura para el abonado especificado y calcula el precio total
   * de la misma. <br>
   *
   * @param abonado El abonado para el que se crear� la factura. <br>
   */
  public Factura(Abonado abonado) {
    this.abonado = abonado;
    this.precio = calculaPrecio();
    this.pagada = false;
  }

  public Abonado getAbonado() {
    return this.abonado;
  }

  public double getPrecio() {
    return this.precio;
  }

  public boolean isPagada() {
    return pagada;
  }

  public IFactura pagar(IFactura encapsulado, String metodoPago) {
    IFactura respuesta = null;

    if (metodoPago.equalsIgnoreCase("tarjeta")) respuesta =
      new DecoratorPagoTarjeta(encapsulado); else if (
      metodoPago.equalsIgnoreCase("cheque")
    ) respuesta = new DecoratorPagoCheque(encapsulado); else if (
      metodoPago.equalsIgnoreCase("efectivo")
    ) respuesta = new DecoratorPagoEfectivo(encapsulado);

    this.pagada = true;

    return respuesta;
  }

  /**
   * Calcula el precio total de la factura llamando al metodo "calculaPrecio()"
   * del abonado asociado a la factura.
   *
   * @return El precio total de la factura.
   */
  public double calculaPrecio() {
    return abonado.calculaPrecio();
  }

  /**
   * Crea y devuelve una copia de esta instancia de Factura. <br>
   *
   * @return Una copia de esta instancia de Factura. <br>
   * @throws CloneNotSupportedException Si la clonacion no es posible. <br>
   */
  @Override
  public Factura clone() throws CloneNotSupportedException {
    Factura clonado = null;
    clonado = (Factura) super.clone();
    clonado.abonado = this.abonado.clone();
    return clonado;
  }

  @Override
  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String toString() {
    if (this.pagada) return "$" + precio + " - pagada"; else return (
      "$" + precio
    );
  }
}
