package prueba;

import modelo.Empresa;
import modelo.IPromocion;
import modelo.Monitoreo;
import modelo.NoExisteAbonadoException;
import modelo.NoHayServiciosException;
import modelo.PromoDorada;
import modelo.PromoPlatino;
import modelo.YaExisteMonitoreoException;
import modelo.Abonado;
import modelo.AbonadoNoPoseeDomicilioException;
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

        try {

            // Abonado de tipo personaFisica
            Abonado abonado = empresa.getAbonado("30123456");
            // Abonado de tipo personaJuridica para probar que no se puede clonar
            // Abonado abonado = empresa.getAbonado("20456789");
            abonado.agregaDomicilio(d1);
            abonado.agregaDomicilio(d2);
            abonado.agregaDomicilio(d3);

            // Llamada para probar NoExisteAbonadoException
            // Abonado abonado = empresa.getAbonado("12331241");

            // Prueba de agregar monitoreos
            Monitoreo m1 = abonado.agregarMonitoreo(d1, 2, 3, true, "comercio");
            // Llamada para probar YaExisteMonitoreoException
            // Monitoreo m2 = abonado.agregarMonitoreo(d1, 4, 1, false, "vivienda");

            Monitoreo m2 = abonado.agregarMonitoreo(d2, 4, 1, false, "vivienda");
            Monitoreo m3 = abonado.agregarMonitoreo(d3, 1, 0, false, "vivienda");

            m1.setPromo(promoDorada);
            m2.setPromo(promoPlatino);
            // Prueba de generar factura
            empresa.newFactura("20456789", "efectivo");
            // Prueba de mostrar la primer factura
            System.out.println(empresa.getFactura("20456789").toString());
            // Prueba de clonaciones
            DecoratorPago clonada = (DecoratorPago) empresa.getFactura("20456789").clone();
            System.out.println("\nFactura clonada correctamente: \n" + clonada.toString());
            Abonado clonAbonado = (Abonado) abonado.clone();
            System.out.println("\nAbonado clonado correctamente: \n" + clonAbonado.toString());
        } catch (NoExisteAbonadoException e) {
            System.out.println(e.getMensaje());
        } catch (YaExisteMonitoreoException e) {
            System.out.println(e.getMensaje());
        } catch (NoHayServiciosException e) {
            System.out.println(e.getMensaje());
        } catch (AbonadoNoPoseeDomicilioException e) {
            System.out.println(e.getMensaje());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

    }
}