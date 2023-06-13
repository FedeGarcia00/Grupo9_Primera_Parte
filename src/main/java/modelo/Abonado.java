package modelo;

import exception.DomicilioDuplicadoException;
import exception.PersonaFisicaAccionInvalidaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que crea y agrega un monitoreo nuevo a la lista de monitoreos de un
 * abonado. <br>
 * Cuenta con un m�todo que devuelve el total a pagar por el abonado en base a
 * todos los monitoreos contratados por este. <br>
 */
public abstract class Abonado implements Cloneable, Serializable {

  private String nombre;
  private String dni;
  protected ArrayList<Monitoreo> listaMonitoreos = new ArrayList<Monitoreo>();
  protected ArrayList<IFactura> listaFacturas = new ArrayList<IFactura>();

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

  public int eliminarMonitoreos() {
    int i = 0;
    Monitoreo monitoreo = null;
    while (i < listaMonitoreos.size()) {
      monitoreo = listaMonitoreos.get(i);
      if (monitoreo.getDarDeBaja()) listaMonitoreos.remove(i); else i++;
    }
    return listaMonitoreos.size();
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
    int cont = this.listaMonitoreos.size();
    if (cont == 0) return 0;
    Iterator<Monitoreo> iterator = this.getListaMonitoreos();
    Monitoreo monitoreo;

    while (iterator.hasNext()) {
      monitoreo = iterator.next();
      precio += monitoreo.calculaPrecio();
    }

    return this.aplicarDescuentoCantidad(precio, cont);
  }

  public boolean buscaDomicilio(Domicilio d) {
    Iterator<Monitoreo> iterator = getListaMonitoreos();

    if (this.listaMonitoreos.size() == 0) return false;

    Monitoreo monitoreo = iterator.next();
    while (iterator.hasNext() && monitoreo.getDomicilio().equals(d)) {
      monitoreo = iterator.next();
    }

    return monitoreo.getDomicilio().equals(d);
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDni() {
    return this.dni;
  }

  public Iterator<Monitoreo> getListaMonitoreos() {
    return this.listaMonitoreos.iterator();
  }

  public ArrayList<Monitoreo> getMonitoreos() {
    return this.listaMonitoreos;
  }

  public void agregarFactura(IFactura facturaNueva) {
    listaFacturas.add(facturaNueva);
  }

  public Iterator<IFactura> getListaFacturas() {
    return this.listaFacturas.iterator();
  }

  public ArrayList<IFactura> getFacturas() {
    return this.listaFacturas;
  }

  public ArrayList<IFactura> getUltimasFacturas(int n) {
    int tamanio = listaFacturas.size();
    if (tamanio > n) {
      int a = tamanio - n;
      int b = tamanio;
      return new ArrayList<IFactura>(listaFacturas.subList(a, b));
    } else {
      return new ArrayList<IFactura>(this.listaFacturas);
    }
  }

  public Abonado clone() throws CloneNotSupportedException {
    Abonado abonadoClonado = (Abonado) super.clone();

    abonadoClonado.listaMonitoreos = new ArrayList<Monitoreo>();
    for (int i = 0; i < listaMonitoreos.size(); i++) {
      Monitoreo monitoreo = this.listaMonitoreos.get(i).clone();
      abonadoClonado.listaMonitoreos.add(i, monitoreo);
    }
    return abonadoClonado;
  }

  public abstract double pagarFactura(IFactura factura, String metodoPago)
    throws PersonaFisicaAccionInvalidaException;

  public abstract void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio
  ) throws DomicilioDuplicadoException, PersonaFisicaAccionInvalidaException;

  public abstract void agregarMonitoreo(
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio,
    String promo
  ) throws DomicilioDuplicadoException, PersonaFisicaAccionInvalidaException;

  public abstract void bajaServicioContratado(int id)
    throws PersonaFisicaAccionInvalidaException;

  public abstract void actualizarMes();

  @Override
  public String toString() {
    return nombre + " DNI= " + dni;
  }
}
