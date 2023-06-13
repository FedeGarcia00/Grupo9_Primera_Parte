package modelo;

public class DecoratorPagoTarjeta extends DecoratorPago {

  public DecoratorPagoTarjeta(IFactura encapsulado) {
    super(encapsulado);
  }

  @Override
  public double getPrecioFinal() {
    return super.getPrecio() * 1.05;
  }

  @Override
  public void setPrecio(double precio) {
    // TODO Auto-generated method stub
  }

  @Override
  public IFactura pagar(IFactura factura, String metodoPago) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isPagada() {
    // TODO Auto-generated method stub
    return false;
  }
}
