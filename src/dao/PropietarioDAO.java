package dao;

import modelo.Propietario;
import java.util.*;
import java.io.*;

//DAO encargado de gestionar la persistencia de objetos Propietario
public class PropietarioDAO {

    // Nombre del archivo donde se guardan los propietarios
    private final String archivo = "propietarios.dat";

//    Lista todos los propietarios almacenados en el archivo.
//    Si el archivo no existe o ocurre un error, retorna una lista vacia
    public ArrayList<Propietario> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Propietario>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

//....................CRUD....................................................
    // Guarda un nuevo propietario en el archivo
    public void guardar(Propietario p) {
        List<Propietario> lista = listar();
        lista.add(p);
        escribirArchivo(lista);
    }

    // Verifica si ya existe un propietario con ese numero de documento Y nombre
    public boolean existePropietario(String documento, String nombre) {
        return listar().stream().anyMatch(p
                -> p.getNumeroDocumento().equalsIgnoreCase(documento)
                && p.getNombreP().equalsIgnoreCase(nombre));
    }

    // Busca y retorna un propietario segun su numero de documento y nombre
    public Propietario buscarPropietario(String documento, String nombre) {
        return listar().stream()
                .filter(p -> p.getNumeroDocumento().equalsIgnoreCase(documento)
                && p.getNombreP().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
   
    // Elimina un propietario
    public boolean eliminarPropietario(String documento) {
        List<Propietario> lista = listar();
        boolean eliminado = lista.removeIf(p -> p.getNumeroDocumento().equalsIgnoreCase(documento));
        if (eliminado) {
            escribirArchivo(lista);
        }
        return eliminado;
    }
    
    //editar propietario
    public boolean editarPropietario(Propietario actualizado) {
     List<Propietario> lista = listar();
    for (int i = 0; i < lista.size(); i++) {
        Propietario p = lista.get(i);
        if (p.getNumeroDocumento().equalsIgnoreCase(actualizado.getNumeroDocumento()) &&
            p.getNombreP().equalsIgnoreCase(actualizado.getNombreP())) {
            lista.set(i, actualizado);
            escribirArchivo(lista);
            return true;
        }
    }
    return false;
    }

    // Método privado para sobrescribir el archivo con una nueva lista de propietarios
    private void escribirArchivo(List<Propietario> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
