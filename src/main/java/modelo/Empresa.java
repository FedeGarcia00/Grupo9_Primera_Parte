package modelo;

import java.util.ArrayList;

/**
 * <br>
 * Clase que genera una unica instancia de Empresa utilizando un patron
 * Singleton. <br>
 * Contiene metodos que crean y agregan nuevos abonados a la lista de abonados,
 * que generan nuevas facturas para abonados especificando el dni del abonado,
 * que buscan y devuelve la factura de un abonado especificando el dni del
 * abonado.
 */
public class Empresa {

	private static Empresa instancia = null;
	public ArrayList<Abonado> listaAbonados = new ArrayList<Abonado>();
	public ArrayList<IFactura> listaFacturas = new ArrayList<IFactura>();

	private Empresa() {
	}

	public static Empresa getInstancia() {
		if (instancia == null)
			instancia = new Empresa();

		return instancia;
	}

	/**
	 * Agrega un abonado nuevo a la lista de abonados. <br>
	 * 
	 * @param tipo   El tipo de abonado, si es persona fisica o juridica. <br>
	 * @param nombre El nombre del abonado. <br>
	 * @param dni    El n�mero de documento del abonado. <br>
	 *               <b>Pre: </b> El parametro tipo solo puede contener los valores
	 *               "PersonaFisica" o "PersonaJuridica". <br>
	 *               El parametro nombre no debe ser vacio o nulo. Debe ser un valor
	 *               valido. <br>
	 *               El parametro dni no debe ser vacio o nulo. Debe ser valido.
	 *               <br>
	 *               <b>Post: </b> Un abonado fue creado y agregado a la lista de
	 *               abonados de la empresa.<br>
	 */
	public void agregarAbonado(String tipo, String nombre, String dni) {
		Abonado abonado = AbonadoFactory.crearAbonado(tipo, nombre, dni);
		listaAbonados.add(abonado);
	}

	/**
	 * Crea una nueva factura para el abonado correspondiente al dni especificado y
	 * la agrega a la lista de facturas.<br>
	 * 
	 * @param dni        El n�mero de documento del abonado. <br>
	 * @param metodoPago El m�todo de pago utilizado para la factura. <br>
	 *                   <b>Pre: </b> El parametro dni no debe ser vacio o nulo.
	 *                   Debe ser un valor valido. <br>
	 *                   El parametro metodoPago solo puede contener los valores
	 *                   "tarjeta", "cheque" o "efectivo". <br>
	 *                   <b>Post: </b> Se crea una factra nueva correspondiente al
	 *                   dni especificado y es agregada a la lista de facturas.<br>
	 */
	public void newFactura(String dni, String metodoPago) {
		// get abonado con dni
		Abonado abonado = getAbonado(dni);
		IFactura factura = FacturaFactory.crearFactura(abonado, metodoPago);
		listaFacturas.add(factura);
	}

	/**
	 * Busca y devuelve la factura correspondiente al dni del abonado especificado.
	 * <br>
	 * 
	 * @param dni El n�mero de documento del abonado. <br>
	 *            <b>Pre: </b> dni no debe ser vacio o nulo. Debe ser un valor
	 *            valido. <br>
	 *            <b>Post: </b> Se obtiene la factura correspondiente al dni
	 *            especificado del abonado.<br>
	 * @return La factura correspondiente al dni del abonado, o null si no se
	 *         encuentra ninguna factura.<br>
	 */
	public IFactura getFactura(String dni) {

		for (IFactura factura : listaFacturas) {
			if (factura.getAbonado().getDni().equalsIgnoreCase(dni)) {
				return factura;
			}
		}
		return null;
	}

	public Abonado getAbonado(String dni) {
		Abonado abonadoEncontrado = null;

		for (Abonado abonado : listaAbonados) {
			if (abonado.getDni().equalsIgnoreCase(dni)) {
				abonadoEncontrado = abonado;
				break;
			}
		}
		return abonadoEncontrado;
	}

}
