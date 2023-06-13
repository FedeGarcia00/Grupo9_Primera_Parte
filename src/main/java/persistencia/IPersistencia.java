package persistencia;

import java.io.IOException;

//DAO
public interface IPersistencia {
  void abrirInput() throws IOException;

  void abrirOutput() throws IOException;

  void cerrarOutput() throws IOException;

  void cerrarInput() throws IOException;

  void escribir(Object objeto) throws IOException;

  Object leer() throws IOException, ClassNotFoundException;
}
