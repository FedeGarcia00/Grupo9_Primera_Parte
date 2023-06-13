package modelo;

public interface IFactura extends Cloneable {
  public Abonado getAbonado();

  public double getPrecio();

  public void setPrecio(double precio);

  public IFactura pagar(IFactura factura, String metodoPago);

  public IFactura clone() throws CloneNotSupportedException;

  public boolean isPagada();
}
