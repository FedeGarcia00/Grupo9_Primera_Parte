package prueba;

import modelo.Empresa;
import modelo.PromoDorada;
import modelo.PromoPlatino;
import modelo.Promocion;
import modelo.Abonado;

public class prueba {

    public static void main(String[] args) {

        Empresa empresa = Empresa.getInstancia();
        Promocion promoDorada = PromoDorada.getInstancia();
        Promocion promoPlatino = PromoPlatino.getInstancia();

        empresa.agregarAbonado("PersonaJuridica", "Juancito", "20456789");
        empresa.agregarAbonado("PersonaFisica", "Pablito", "30123456");

        Abonado abonado = empresa.getAbonado("20456789");

        abonado.agregarMonitoreo("Funes 1234", 2, 3, true, "comercio", promoDorada);
        abonado.agregarMonitoreo("Chaco 3456", 4, 1, false, "vivienda", promoPlatino);
        abonado.agregarMonitoreo("San Juan 3487", 1, 0, false, "vivienda");
    }
}