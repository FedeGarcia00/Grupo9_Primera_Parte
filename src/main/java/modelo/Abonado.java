package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que crea y agrega un monitoreo nuevo a la lista de monitoreos de un
 * abonado. <br>
 * Cuenta con un m�todo que devuelve el total a pagar por el abonado en base a
 * todos los monitoreos contratados por este. <br>
 */
public abstract class Abonado implements Cloneable {
	protected String nombre;
	protected String dni;
	protected ArrayList<Domicilio> listaDomicilios = new ArrayList<Domicilio>();
	protected ArrayList<Monitoreo> listaMonitoreos = new ArrayList<Monitoreo>();

	public Abonado(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	/**
	 * Agrega un nuevo monitoreo a la lista de monitoreos del abonado.<br>
	 * 
	 * @param domicilio           Objeto de la clase Domicilio que representa el
	 *                            domicilio del monitoreo contratado.<br>
	 * @param cantCamaras         La cantidad de c�maras a incluir en el
	 *                            monitoreo.<br>
	 * @param cantBotones         La cantidad de botones de p�nico a incluir en el
	 *                            monitoreo.<br>
	 * @param movilAcompanamiento Un booleano que indica si se incluir� el servicio
	 *                            de acompa�amiento.<br>
	 * @param servicio            Una cadena que indica el tipo de servicio
	 *                            contratado.<br>
	 * @return Un objeto de la clase Monitoreo que representa el nuevo monitoreo
	 *         agregado a la lista.<br>
	 */
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
	 * Calcula el precio total de los monitoreos del abonado teniendo en cuenta un
	 * posible descuento. <br>
	 * 
	 * @return el precio total de los monitoreos del abonado con descuento si es que
	 *         le corresponde.<br>
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
