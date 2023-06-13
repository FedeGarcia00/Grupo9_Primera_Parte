package modelo;

import exception.DomicilioDuplicadoException;
import exception.NoExisteAbonadoException;
import exception.NoExisteFacturaAbonadoException;
import exception.NoHayServiciosException;
import exception.PersonaFisicaAccionInvalidaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <br>
 * Clase que genera una unica instancia de Empresa utilizando un patron
 * Singleton. <br>
 * Contiene metodos que crean y agregan nuevos abonados a la lista de abonados,
 * que generan nuevas facturas para abonados especificando el dni del abonado,
 * que buscan y devuelve la factura de un abonado especificando el dni del
 * abonado.
 */
public class Empresa implements Serializable {

  private static Empresa instancia = null;
  public ArrayList<Abonado> listaAbonados = new ArrayList<Abonado>();
  public ArrayList<IFactura> listaFacturas = new ArrayList<IFactura>();
  public ArrayList<Tecnico> listaTecnicos = new ArrayList<Tecnico>();

  private Empresa() {}

  public static Empresa getInstancia() {
    if (instancia == null) instancia = new Empresa();
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
  public Abonado agregarAbonado(String tipo, String nombre, String dni) {
    assert tipo != null &&
    !tipo.isEmpty() : "El tipo de abonado no puede ser nulo o vacío";
    assert (
      tipo.equals("personajuridica") || tipo.equals("personafisica")
    ) : "Tipo de abonado inválido";
    assert (
      nombre != null && !nombre.isEmpty()
    ) : "El nombre no puede ser nulo o vacío";
    assert (dni != null && !dni.isEmpty()) : "El DNI no puede ser nulo o vacío";

    int cantidadAntes = listaAbonados.size();
    Abonado abonado = AbonadoFactory.crearAbonado(tipo, nombre, dni);
    listaAbonados.add(abonado);
    int cantidadDespues = listaAbonados.size();

    assert cantidadAntes +
    1 ==
    cantidadDespues : "No se agregó un abonado a la lista";

    return abonado;
  }

  public void actualizarMes() { // BOTON
    try {
      this.generadorDeFacturas();
    } catch (NoHayServiciosException e) {
      e.printStackTrace();
    }

    for (Abonado abonado : listaAbonados) {
      abonado.actualizarMes();
    }
  }

  /**
   * Crea una nueva factura para todos los abonados.<br>
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
  public void generadorDeFacturas() throws NoHayServiciosException {
    // get abonado con dni
    // recorre abonados
    // genera una factura para cada uno y la mete en el array de facturas
    for (Abonado abonado : listaAbonados) {
      if (abonado.listaMonitoreos.size() > 0) {
        IFactura factura = FacturaFactory.crearFactura(abonado);
        listaFacturas.add(factura);
        abonado.agregarFactura(factura);
      }
    }
    // Realizar alguna operación con el abonado
    // Por ejemplo, imprimir el nombre del abonado:
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
  public IFactura getFactura(String dni)
    throws NoExisteFacturaAbonadoException {
    assert dni != null && !dni.isEmpty() : "El DNI no puede ser nulo o vacío";

    Iterator<IFactura> iterator = this.listaFacturas.iterator();

    if (
      this.listaFacturas.size() == 0
    ) throw new NoExisteFacturaAbonadoException(dni);

    IFactura factura = iterator.next();
    while (
      iterator.hasNext() && !factura.getAbonado().getDni().equalsIgnoreCase(dni)
    ) {
      factura = iterator.next();
    }

    if (
      !factura.getAbonado().getDni().equalsIgnoreCase(dni)
    ) throw new NoExisteFacturaAbonadoException(dni);

    return factura;
  }

  /**
   * Retorna el objeto Abonado correspondiente al dni ingresado. <br>
   *
   * @param dni El n�mero de documento del abonado. <br>
   *            <b>Pre: </b> El parametrodni no debe ser vacio o nulo. Debe ser un
   *            valor valido. <br>
   *            <b>Post: </b> Devolve el abonado correspondiente al dni. <br>
   * @return El objeto Abonado correspondiente al dni ingresado, o null si no se
   *         encuentra<br>
   */
  public Abonado getAbonado(String dni) throws NoExisteAbonadoException {
    Iterator<Abonado> iterator = this.listaAbonados.iterator();

    if (this.listaAbonados.size() == 0) throw new NoExisteAbonadoException(dni);

    Abonado abonado = iterator.next();
    while (iterator.hasNext() && !abonado.getDni().equalsIgnoreCase(dni)) {
      abonado = iterator.next();
    }

    if (
      !abonado.getDni().equalsIgnoreCase(dni)
    ) throw new NoExisteAbonadoException(dni);
    return abonado;
  }

  /**
   * Busca un domicilio en la lista de abonados y devuelve true si lo encuentra,
   * false en caso contrario.<br>
   *
   * @param d Domicilio a buscar.<br>
   * @return true si el domicilio se encuentra en alg�n abonado de la lista, false
   *         en caso contrario.<br>
   */
  public boolean buscaDomicilio(Domicilio d) {
    Iterator<Abonado> iterator = this.listaAbonados.iterator();

    if (this.listaAbonados.size() == 0) return false;

    Abonado abonado = iterator.next();
    while (iterator.hasNext() && abonado.buscaDomicilio(d)) {
      abonado = iterator.next();
    }

    return abonado.buscaDomicilio(d);
  }

  // la empresa administra los monitoreos

  /**
   * Agrega un nuevo monitoreo a un abonado existente en la lista, siempre que el
   * domicilio no se encuentre duplicado.<br>
   *
   * @param dni                 El dni del abonado al que se le agregar� el
   *                            monitoreo.<br>
   * @param domicilio           El domicilio al que se asociara el monitoreo.<br>
   * @param cantCamaras         La cantidad de c�maras que se agregan en el
   *                            servicio de monitoreo.<br>
   * @param cantBotones         La cantidad de botones de p�nico que se agregan en
   *                            el servicio de monitoreo.<br>
   * @param movilAcompanamiento Un booleano que indica si se agrega el servicio de
   *                            un m�vil de acompa�amiento.<br>
   * @param servicio            El tipo de servicio de monitoreo que se
   *                            realizar�.<br>
   * @throws DomicilioDuplicadoException Si el domicilio se encuentra duplicado en
   *                                     el abonado que solicita el monitoreo u
   *                                     otro abonado de la lista.<br>
   */
  public void agregaMonitoreo(
    String dni,
    Domicilio domicilio,
    int cantCamaras,
    int cantBotones,
    boolean movilAcompanamiento,
    String servicio
  ) throws NoExisteAbonadoException, DomicilioDuplicadoException {
    if (!this.buscaDomicilio(domicilio)) {
      Abonado abonado = this.getAbonado(dni);
      try {
        abonado.agregarMonitoreo(
          domicilio,
          cantCamaras,
          cantBotones,
          movilAcompanamiento,
          servicio
        );
      } catch (PersonaFisicaAccionInvalidaException e) {
        e.printStackTrace();
      }
    } else {
      throw new DomicilioDuplicadoException(domicilio);
    }
  }

  public Tecnico altaTecnico(String nombre) {
    Tecnico tecnico = new Tecnico(nombre);

    listaTecnicos.add(tecnico);
    return tecnico;
  }

  public void bajaTecnico(int idTecnico) {
    listaTecnicos.remove(idTecnico);
  }

  public ArrayList<Abonado> getListaAbonados() {
    return listaAbonados;
  }

  public ArrayList<Tecnico> getListaTecnicos() {
    return listaTecnicos;
  }
}
