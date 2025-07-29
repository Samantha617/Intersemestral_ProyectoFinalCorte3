/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.CitaDTO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author MI PC
 */
public class CitaDAO {
    private static final String ARCHIVO = "citas.dat";

     // Guarda una nueva cita
    public void guardarCita(CitaDTO cita) {
        ArrayList<CitaDTO> citas = listar();
        citas.add(cita);
        escribirArchivo(citas);
    }

    // Lista todas las citas desde archivo
   public ArrayList<CitaDTO> listar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<CitaDTO>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si el archivo no existe o esta vacio, se retorna una lista vacia
            return new ArrayList<>();
        }
    }
    

    // Elimina una cita por su fecha
    public boolean eliminarCita(String fecha) {
        ArrayList<CitaDTO> citas = listar();
        boolean eliminado = citas.removeIf(v -> v.getFecha().equalsIgnoreCase(fecha));
        if (eliminado) {
            escribirArchivo(citas);
        }
        return eliminado;
    }
    
    // Edita los datos de una cita existente
     public boolean editarCita(CitaDTO actualizada) {
        ArrayList<CitaDTO> citas = listar();
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getFecha().equalsIgnoreCase(actualizada.getFecha())) {
                citas.set(i, actualizada);
                escribirArchivo(citas);
                return true;
            }
        }
        return false;
    }

    // Busca una cita por su fecha
     public CitaDTO buscarCita(String fecha) {
        for (CitaDTO v : listar()) {
            if (v.getFecha().equalsIgnoreCase(fecha)) {
                return v;
            }
        }
        return null;
    }

    // Guarda toda la lista de citas en el archivo
    public void guardarLista(ArrayList<CitaDTO> lista) {
        escribirArchivo(lista);
    }

    // Escribe el archivo con la lista completa
    private void escribirArchivo(ArrayList<CitaDTO> citas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(citas);
        } catch (IOException e) {
            System.err.println("Error al guardar archivo de citas: " + e.getMessage());
        }
    }
}
