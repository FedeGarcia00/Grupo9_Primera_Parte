package prueba;

import controlador.controlador;
import modelo.IPromocion;
import modelo.PromoDorada;
import modelo.PromoPlatino;

public class prueba {

  public static void main(String[] args) {
    controlador controlador = new controlador();
  }

  IPromocion promoDorada = PromoDorada.getInstancia();
  IPromocion promoPlatino = PromoPlatino.getInstancia();
}
