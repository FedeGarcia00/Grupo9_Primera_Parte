package modelo;

public class YaExisteMonitoreoException extends Exception {
    Domicilio domicilio;

    public YaExisteMonitoreoException(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getMensaje() {
        return "Ya hay un monitoreo en el domicilio " + this.domicilio.toString();
    }

}
