package modelo;

public class FacturaFactory {

  public static IFactura crearFactura(Abonado abonado) {
    return new Factura(abonado);
  }
}
