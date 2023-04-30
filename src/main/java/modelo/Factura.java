 package modelo;

/**
 *Clase que crea nuevas instancias de factura. <br>
 *Con métodos que calculan el precio total de todos los contratos realizados por el Abonado
 *y otro método que clona la factura solo si el Abonado es una persona fisica. <br>
 */
public class Factura implements IFactura {

    protected Abonado abonado;
    protected double precio;
    
    /**
     *Crea una nueva factura para el abonado especificado y calcula el precio total de la misma. <br>
     *@param abonado El abonado para el que se creará la factura. <br>
     */
    public Factura(Abonado abonado) {
        this.abonado = abonado;
        this.precio = calculaPrecio();
    }

    public Abonado getAbonado() {
        return this.abonado;
    }

    public double getPrecio() {
        return this.precio;
    }
    
    public double calculaPrecio() {
    	return abonado.calculaPrecio();
    }
    
    /**
     *Crea y devuelve una copia de esta instancia de Factura. <br>
     *@return Una copia de esta instancia de Factura. <br>
     *@throws CloneNotSupportedException Si la clonación no es posible. <br>
    */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Factura clonado = null;
        clonado = (Factura) super.clone();
        return clonado;
    }
}
