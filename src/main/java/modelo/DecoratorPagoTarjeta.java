package modelo;

public class DecoratorPagoTarjeta extends DecoratorPago {

  public DecoratorPagoTarjeta(IFactura encapsulado) {
    super(encapsulado);
    this.precioFinal = encapsulado.getPrecio() * 1.05;
  }
}
