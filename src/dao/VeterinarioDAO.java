package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.Veterinario;

/**
 *
 * @author MI PC
 */
public class VeterinarioDAO {

    private final String archivo = "veterinarios.dat";

    // Lista todos los veterinarios almacenados en el archivo
    public ArrayList<Veterinario> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Veterinario>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Guarda un nuevo veterinario
    public void guardar(Veterinario v) {
        List<Veterinario> lista = listar();
        lista.add(v);
        escribirArchivo(lista);
    }

    // Verifica si ya existe un veterinario con ese nombre
    public boolean existeVeterinario(String nombre) {
        return listar().stream()
                .anyMatch(v -> v.getNombreV().equalsIgnoreCase(nombre));
    }

    // Busca un veterinario por nombre
    public Veterinario buscarVeterinario(String nombre) {
        return listar().stream()
                .filter(v -> v.getNombreV().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Elimina un veterinario por nombre
    public boolean eliminarVeterinario(String nombre) {
        List<Veterinario> lista = listar();
        boolean eliminado = lista.removeIf(v -> v.getNombreV().equalsIgnoreCase(nombre));
        if (eliminado) {
            escribirArchivo(lista);
        }
        return eliminado;
    }

    // Editar veterinario por nombre
    public boolean editarVeterinario(Veterinario actualizado) {
        List<Veterinario> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Veterinario v = lista.get(i);
            if (v.getNombreV().equalsIgnoreCase(actualizado.getNombreV())) {
                lista.set(i, actualizado);
                escribirArchivo(lista);
                return true;
            }
        }
        return false;
    }

    // Método privado para sobrescribir el archivo con la lista actualizada
    private void escribirArchivo(List<Veterinario> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

