package modelo;

public class Tecnico extends Thread {

  private String nombre;
  private int idTecnico;
  private GestorVisitas visita;

  private static int siguienteId = 0;
  private static final int tiempoMinimo = 500;
  private static final int tiempoMaximo = 5000;

  public Tecnico(String nombre) {
    this.nombre = nombre;
    this.idTecnico = ++siguienteId;
  }

  public String getNombre() {
    return nombre;
  }

  public int getIdTecnico() {
    return idTecnico;
  }

  public static int getSiguienteId() {
    return siguienteId;
  }

  @Override
  public void run() {
    int tiempo;
    Monitoreo monitoreo;

    while (true) { //termina una visita y va a la siguiente
      tiempo =
        (int) (Math.random() * (tiempoMaximo - tiempoMinimo) + tiempoMinimo);

      monitoreo = this.visita.inicioVisitaTecnica(this);

      try {
        Thread.sleep(tiempo);
      } catch (InterruptedException e) {}

      this.visita.finVisitaTecnica(this, monitoreo);
    }
  }

  public String toString() {
    return idTecnico + " " + nombre;
  }
}
