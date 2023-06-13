package modelo;

public class DecoratorPagoEfectivo extends DecoratorPago {

  public DecoratorPagoEfectivo(IFactura encapsulado) {
    super(encapsulado);
  }

  @Override
  public double getPrecioFinal() {
    return super.getPrecio() * 0.8;
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
