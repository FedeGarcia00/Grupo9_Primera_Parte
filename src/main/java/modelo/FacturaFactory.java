package modelo;

public class FacturaFactory {
    
	public static IFactura crearFactura(Abonado abonado, String metodoPago) {

		IFactura encapsulado = null;
		IFactura respuesta = null;

        encapsulado = new Factura(abonado);

		if (metodoPago.equalsIgnoreCase("tarjeta"))
	        respuesta = new DecoratorPagoTarjeta(encapsulado);
	    else 
			if (metodoPago.equalsIgnoreCase("cheque"))
	        	respuesta = new DecoratorPagoCheque(encapsulado);
            else 
                if(metodoPago.equalsIgnoreCase("efectivo"))
                    respuesta = new DecoratorPagoEfectivo(encapsulado);
        
	    return respuesta;
	}

}