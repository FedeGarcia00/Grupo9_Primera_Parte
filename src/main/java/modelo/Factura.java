package modelo;

import java.util.Iterator;

public class Factura implements IFactura {

    protected Abonado abonado;
    protected double precio;

    public Factura(Abonado abonado) {
        this.abonado = abonado;
        this.precio = calculaPrecio();
    }

    public Abonado getAbonado() {
        return this.abonado;
    }

    public double getPrecio() {
        return this.precio;
    }

    public double calculaPrecio() {
        double precio = 0;
        int cont = 0;
        Iterator<Monitoreo> iterator = abonado.getListaMonitoreos().iterator(); // Si abonado es null, tira null pointer
                                                                                // exception, hay q comprobar o tirar
                                                                                // excepcion

        while (iterator.hasNext()) {
            Monitoreo monitoreo = iterator.next();
            precio += monitoreo.getPrecio();
            cont++;
        }

        String clase = abonado.getClass().getName();

        if (clase.equalsIgnoreCase("personajuridica") && cont > 3) {
            precio /= 2;
        }

        return precio;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Factura clonado = null;
        clonado = (Factura) super.clone();
        return clonado;
    }
}