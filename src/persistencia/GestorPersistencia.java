package persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestorPersistencia
 * Implementa el patron Singleton para gestionar la serialización y
 * deserialización de listas de objetos en archivos.
 * Esta clase centraliza el manejo de archivos binarios en el proyecto.
 */
public class GestorPersistencia {

    // Instancia estática única de la clase (Singleton)
    private static GestorPersistencia instancia;

    /**
     * Constructor privado para evitar que se creen instancias externas.
     * Solo se puede acceder a través del metodo getInstance().
     */
    private GestorPersistencia() {}

    /**
     * Devuelve la unica instancia de GestorPersistencia.
     * Si no existe, la crea (hilo seguro con synchronized).
     */
    public static synchronized GestorPersistencia getInstance() {
        if (instancia == null) {
            instancia = new GestorPersistencia(); // se crea solo una vez
        }
        return instancia;
    }

    /**
     * Guarda una lista de objetos serializables en un archivo especificado. 
     * - ruta Ruta del archivo donde se guardarán los datos.
     * - lista Lista de objetos que se desea guardar.
     * - <T> Tipo genérico que extiende Serializable.
     */
    public <T extends Serializable> void guardarLista(String ruta, List<T> lista) {
        try {
            // Verifica que el directorio exista, si no, lo crea
            File archivo = new File(ruta);
            File directorio = archivo.getParentFile();
            if (directorio != null && !directorio.exists()) {
                directorio.mkdirs(); // Crea el directorio si no existe
            }

            // Guardar la lista en el archivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                oos.writeObject(lista);
            }

        } catch (IOException e) {
            System.err.println("❌ Error al guardar datos: " + e.getMessage());
        }
    }

    /**
     * Carga una lista de objetos desde un archivo especificado
     * -ruta Ruta del archivo desde el que se cargarán los datos.
     * - <T> Tipo genérico que extiende Serializable.
     * - Lista de objetos cargados, o null si ocurre un error.
     */
    
    public <T extends Serializable> List<T> cargarLista(String ruta) {
        File archivo = new File(ruta);
        if(!archivo.exists()){
            return new ArrayList<>();
        }
        
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<T>) ois.readObject();
               } catch (EOFException e) { //retorna lista vacia
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Error al leer datos: " + e.getMessage());
        }
        return new ArrayList<>();
               //return null;
    }
}
    

