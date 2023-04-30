package prueba;

import modelo.Empresa;
import modelo.IPromocion;
import modelo.Monitoreo;
import modelo.PromoDorada;
import modelo.PromoPlatino;
import modelo.Abonado;
import modelo.DecoratorPago;
import modelo.Domicilio;

public class prueba {

    public static void main(String[] args) {

        Empresa empresa = Empresa.getInstancia();
        IPromocion promoDorada = PromoDorada.getInstancia();
        IPromocion promoPlatino = PromoPlatino.getInstancia();

        Domicilio d1 = new Domicilio("Funes", 1234);
        Domicilio d2 = new Domicilio("Chaco", 3456);
        Domicilio d3 = new Domicilio("San Juan", 3487);

        // Prueba de agregar abonados
        empresa.agregarAbonado("PersonaJuridica", "Juancito", "20456789");
        empresa.agregarAbonado("PersonaFisica", "Pablito", "30123456");

        // Prueba de agregar monitoreos
        Abonado abonado = empresa.getAbonado("20456789");
        Monitoreo m1 = abonado.agregarMonitoreo(d1, 2, 3, true, "comercio");
        Monitoreo m2 = abonado.agregarMonitoreo(d2, 4, 1, false, "vivienda");
        Monitoreo m3 = abonado.agregarMonitoreo(d3, 1, 0, false, "vivienda");

        m1.setPromo(promoDorada);
        m2.setPromo(promoPlatino);

        // Prueba de generar factura
        empresa.newFactura("20456789", "efectivo");

        // Prueba de mostrar la primer factura
        System.out.println(empresa.getFactura("20456789").toString());

        // Prueba de clonacion
        try {
            DecoratorPago clonada = (DecoratorPago) empresa.getFactura("20456789").clone();
            System.out.println(clonada.toString());
        } catch (CloneNotSupportedException e) {

        }

    }
}