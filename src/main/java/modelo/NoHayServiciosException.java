package modelo;

public class NoHayServiciosException extends Exception {

    Abonado abonado;

    public NoHayServiciosException(Abonado abonado) {
        this.abonado = abonado;
    }

    public String getMensaje() {
        return "No hay ningun servicio asociado al abonado" + this.abonado.getNombre() + "con DNI "
                + this.abonado.getDni();
    }

}
