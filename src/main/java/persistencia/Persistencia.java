package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia implements IPersistencia {

  private FileOutputStream fileOutput;
  private FileInputStream fileInput;
  private ObjectOutputStream objectOutput;
  private ObjectInputStream objectInput;
  private static final String FILE_NAME = "persistencia.bin";

  @Override
  public void abrirInput() throws IOException {
    fileInput = new FileInputStream(FILE_NAME);
    objectInput = new ObjectInputStream(fileInput);
  }

  @Override
  public void abrirOutput() throws IOException {
    fileOutput = new FileOutputStream(FILE_NAME);
    objectOutput = new ObjectOutputStream(fileOutput);
  }

  @Override
  public void cerrarOutput() throws IOException {
    objectOutput.close();
    fileOutput.close();
  }

  @Override
  public void cerrarInput() throws IOException {
    objectInput.close();
    fileInput.close();
  }

  @Override
  public void escribir(Object objeto) throws IOException {
    try {
      this.abrirOutput();
      objectOutput.writeObject(objeto);
      this.cerrarOutput();
      System.out.println(
        "El objeto ha sido serializado y guardado en " + FILE_NAME
      );
    } catch (Exception e) {
      //e.printStackTrace();
    }
  }

  @Override
  public Object leer() throws IOException, ClassNotFoundException {
    try {
      this.abrirInput();
      Object objeto = objectInput.readObject();
      this.cerrarInput();
      System.out.println(
        "El objeto ha sido deserializado del archivo " + FILE_NAME
      );
      return objeto;
    } catch (Exception e) {
      //e.printStackTrace();
      return null;
    }
  }
}
