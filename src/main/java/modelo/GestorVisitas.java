package modelo;

import java.util.ArrayList;
import java.util.Observable;

public class GestorVisitas extends Observable {

  // es el recurso compartido
  ArrayList<Monitoreo> listaMonitoreosEsperandoVisita = new ArrayList<Monitoreo>();

  public synchronized void solicitarTecnico(Monitoreo monitoreo) {
    listaMonitoreosEsperandoVisita.add(monitoreo);
    notifyAll(); // cuando se agregue un monitoreo se despiertan los hilos(Tecnicos)
  }

  public synchronized Monitoreo inicioVisitaTecnica(Tecnico tecnico) {
    Monitoreo monitoreo;
    String msj;
    while (listaMonitoreosEsperandoVisita.size() == 0) { // espero mientras sea 0
      try {
        wait();
      } catch (InterruptedException e) {}
    }

    monitoreo = listaMonitoreosEsperandoVisita.remove(0);
    // visita en curso
    msj =
      "Tecnico: " +
      tecnico.getNombre() +
      "ID: " +
      tecnico.getIdTecnico() +
      "inicio la visita";
    setChanged();
    notifyObservers(msj);
    return monitoreo;
  }

  public synchronized void finVisitaTecnica(
    Tecnico tecnico,
    Monitoreo monitoreo
  ) {
    // finalizo la visita
    String msj =
      "Tecnico: " +
      tecnico.getNombre() +
      " ID: " +
      tecnico.getIdTecnico() +
      " finalizo la visita en el domicilio Monitoreado:  " +
      monitoreo.getDomicilio().toString();
    setChanged();
    notifyObservers(msj);
  }
}
