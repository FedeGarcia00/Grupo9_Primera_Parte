package modelo;

import java.util.Iterator;

public class Factura implements IFactura {

    Abonado abonado;
    double precio;
    

    public Factura(Abonado abonado)
    {
        this.abonado = abonado;
        this.precio = calculaPrecio();
    }

    public String getAbonado()
    {
        return ("Nombre: " + this.abonado.getNombre() + ", DNI: " + this.abonado.getDni());
    }

    public double getPrecio()
    {
        return this.precio;
    }

    public double calculaPrecio()
    {
        double precio = 0;
        int cont = 0;
        Iterator<Monitoreo> iterador = abonado.getListaMonitoreos().iterator(); //Si abonado es null, tira null pointer exception, hay q comprobar o tirar excepcion

        while (iterador.hasNext()) {
            Monitoreo monitoreo = iterador.next();
            precio += monitoreo.getPrecio();
            cont++;
        }
        
        String clase = abonado.getClass().getName();

        if(clase.equalsIgnoreCase("personajuridica") && cont > 3)
        {
            precio /= 2;
        }

        return precio;
    }

}