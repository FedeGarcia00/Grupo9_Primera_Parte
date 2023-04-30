package modelo;

public interface IFactura extends Cloneable {

    public Abonado getAbonado();

    public double getPrecio();

    public Object clone() throws CloneNotSupportedException;
}
