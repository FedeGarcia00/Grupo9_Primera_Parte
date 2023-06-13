package modelo;

public class PromoDorada implements IPromocion {

  public static PromoDorada instancia = null;

  private PromoDorada() {}

  @Override
  public double getDescuentoVivienda(double monto) {
    return monto - 1500.0;
  }

  @Override
  public double getDescuentoComercio(double monto) {
    return monto - 2500.0;
  }

  public static PromoDorada getInstancia() {
    if (instancia == null) instancia = new PromoDorada();

    return instancia;
  }
}
