package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Abonado {
	protected String nombre;
	protected String dni;
	private ArrayList<Monitoreo> listaMonitoreos = new ArrayList<Monitoreo>();

	public Monitoreo agregarMonitoreo(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento,
			String servicio) {
		Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento,
				servicio);
		listaMonitoreos.add(monitoreo);
		
		return monitoreo;
	}

	public abstract double aplicarDescuentoCantidad(double monto, int cantidad);
	
	/**
	 *Calcula el precio total de la contratación para el abonado actual en base a todos los Monitoreos que contrato. <br>
	 *Si el abonado es una Persona Jurídica y tiene más de tres Monitoreos contratados, se aplica un descuento del 50% al precio total. <br>
	 *@return El precio total de la contratación para el abonado actual.<br>
	 */
    public double calculaPrecio() {
        double precio = 0;
        int cont = this.getListaMonitoreos().size();
        Iterator<Monitoreo> iterator = this.getListaMonitoreos().iterator(); // Si abonado es null, tira null pointer
                                                                                // exception, hay q comprobar o tirar
                                                                                // excepcion
        while (iterator.hasNext()) {
            Monitoreo monitoreo = iterator.next();
            precio += monitoreo.calculaPrecio(); 
        }
 
        return this.aplicarDescuentoCantidad(precio, cont);
    }
	
	
	public String getNombre() {
		return this.nombre;
	}

	public String getDni() {
		return this.dni;
	}

	public ArrayList<Monitoreo> getListaMonitoreos() {
		return listaMonitoreos;
	}

}
