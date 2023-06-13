package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import exception.DomicilioDuplicadoException;
import exception.PersonaFisicaAccionInvalidaException;

public class ConContratacionState implements IPersonaFisicaState {

	private PersonaFisica p;

	public ConContratacionState(PersonaFisica p) {
		this.p = p;
	}

	@Override
	public double pagarFactura(IFactura factura, String metodoPago) throws PersonaFisicaAccionInvalidaException {
		double precio = factura.pagar(factura, metodoPago).getPrecio(); // paga factura
		return precio;
	}

	@Override
	public void agregarMonitoreo(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento,
			String servicio) throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException {
		if (p.buscaDomicilio(domicilio)) {
			throw new DomicilioDuplicadoException(domicilio);
		}
		Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento,
				servicio);
		p.listaMonitoreos.add(monitoreo);
	}

	@Override
	public void bajaServicioContratado(int id) throws PersonaFisicaAccionInvalidaException {
		Iterator<Monitoreo> iterator = p.getListaMonitoreos();
		Monitoreo monitoreo = null;
		boolean encontrado = false;

		while (iterator.hasNext() && !encontrado) {
			monitoreo = iterator.next();
			if (monitoreo.getId() == id) {
				monitoreo.setEstadoFinDeMes(true);
				encontrado = true;
			}
		}
	}

	@Override
	public void actualizarMes() {
		ArrayList<IFactura> lista = p.getUltimasFacturas(2);

		if (lista.size() >= 2) {
			boolean a = lista.get(0).isPagada();
			boolean b = lista.get(1).isPagada();

			if (!a && !b)
				this.p.setEstado(new MorosoState(this.p));
		}

		int cant = p.eliminarMonitoreos();
		if (cant == 0) {
			this.p.setEstado(new SinContratacionState(this.p));
		}
	}

	@Override
	public void agregarMonitoreo(Domicilio domicilio, int cantCamaras, int cantBotones, boolean movilAcompanamiento,
			String servicio, String promo)  throws PersonaFisicaAccionInvalidaException, DomicilioDuplicadoException {
		if (p.buscaDomicilio(domicilio)) {
			throw new DomicilioDuplicadoException(domicilio);
		}
		Monitoreo monitoreo = MonitoreoFactory.crearMonitoreo(domicilio, cantCamaras, cantBotones, movilAcompanamiento,
				servicio);
		if(promo=="PromoDorada") {
			monitoreo.setPromo(PromoDorada.getInstancia());
		} else if(promo=="PromoPlatino") {
			monitoreo.setPromo(PromoPlatino.getInstancia());
		}
		p.listaMonitoreos.add(monitoreo);
		
	}

}
