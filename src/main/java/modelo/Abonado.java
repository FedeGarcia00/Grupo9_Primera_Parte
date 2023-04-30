package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Abonado implements Cloneable {
	protected String nombre;
	protected String dni;
	protected ArrayList<Domicilio> listaDomicilios = new ArrayList<Domicilio>();
	protected ArrayList<Monitoreo> listaMonitoreos = new ArrayList<Monitoreo>();

	public Abonado(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public Monitoreo agregarMonitoreo(Domicilio domicilio, int cantCamaras, int cantBotones,
			boolean movilAcompanamiento, String servicio)
			throws AbonadoNoPoseeDomicilioException, YaExisteMonitoreoException {
		if (abonadoNoPoseeDomicilio(domicilio))
			throw new AbonadoNoPoseeDomicilioException(domicilio);
		if (existeMonitoreoConDomicilio(domicilio)) {
			throw new YaExisteMonitoreoException(domicilio);
		}
		Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento,
				servicio);
		listaMonitoreos.add(monitoreo);
		return monitoreo;
	}

	public abstract double aplicarDescuentoCantidad(double monto, int cantidad);

	/**
	 * Calcula el precio total de la contrataci�n para el abonado actual en base a
	 * todos los Monitoreos que contrato. <br>
	 * Si el abonado es una Persona Jur�dica y tiene m�s de tres Monitoreos
	 * contratados, se aplica un descuento del 50% al precio total. <br>
	 * 
	 * @return El precio total de la contrataci�n para el abonado actual.<br>
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

	public ArrayList<Domicilio> getListaDomicilios() {
		return listaDomicilios;
	}

	public Object clone() throws CloneNotSupportedException {
		Abonado abonadoClonado = (Abonado) super.clone();
		// Clonar las listas de domicilios y monitoreos
		abonadoClonado.listaDomicilios = new ArrayList<>(this.listaDomicilios);
		abonadoClonado.listaMonitoreos = new ArrayList<>(this.listaMonitoreos);
		return abonadoClonado;
	}

	public boolean existeMonitoreoConDomicilio(Domicilio domicilio) {
		for (Monitoreo monitoreo : listaMonitoreos) {
			if (monitoreo.getDomicilio().equals(domicilio)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Abonado [nombre=" + nombre + ", dni=" + dni + ", listaDomicilios=" + listaDomicilios
				+ ", listaMonitoreos=" + listaMonitoreos + "]";
	}

	public void agregaDomicilio(Domicilio domicilio) {
		listaDomicilios.add(domicilio);
	}

	public boolean abonadoNoPoseeDomicilio(Domicilio DomicilioNuevo) {

		boolean booleano = true;
		for (Domicilio domicilio : listaDomicilios) {
			if (DomicilioNuevo.equals(domicilio)) {
				booleano = false;
			}
		}
		return booleano;
	}
}
