package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Factura implements IFactura {

    Abonado abonado;
    double precio;
    

    public Factura(Abonado abonado)
    {
        this.abonado = abonado;
        this.precio = getPrecio();
    }

    public String getAbonado()
    {
        return ("Nombre: " + this.abonado.getNombre() + ", DNI: " + this.abonado.getDni());
    }

    public double getPrecio()
    {
        double precio = 0;
        int cont = 0;
        Iterator<Monitoreo> iterador = abonado.getListaMonitoreos().iterator();

        while (iterador.hasNext()) {
            Monitoreo monitoreo = iterador.next();
            precio += monitoreo.getPrecio();
            cont++;
        }
        String clase = abonado.getClass();
        
        if(clase.equalsIgnoreCase("personajuridica"))

        return precio;

        
    }

}