/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.VacunaDTO;
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
public class VacunaDAO {
    private static final String ARCHIVO = "vacunas.dat";

     // Guarda una nueva vacuna
    public void guardarVacuna(VacunaDTO vacuna) {
        ArrayList<VacunaDTO> vacunas = listar();
        vacunas.add(vacuna);
        escribirArchivo(vacunas);
    }

    // Lista todas las vacunas desde archivo
   public ArrayList<VacunaDTO> listar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<VacunaDTO>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si el archivo no existe o esta vacio, se retorna una lista vacia
            return new ArrayList<>();
        }
    }
    

    // Elimina una vacuna por su fecha
    public boolean eliminarVacuna(String fecha) {
        ArrayList<VacunaDTO> vacunas = listar();
        boolean eliminado = vacunas.removeIf(v -> v.getFechaVacuna().equalsIgnoreCase(fecha));
        if (eliminado) {
            escribirArchivo(vacunas);
        }
        return eliminado;
    }
    
    // Edita los datos de una vacuna existente
     public boolean editarVacuna(VacunaDTO actualizada) {
        ArrayList<VacunaDTO> vacunas = listar();
        for (int i = 0; i < vacunas.size(); i++) {
            if (vacunas.get(i).getFechaVacuna().equalsIgnoreCase(actualizada.getFechaVacuna())) {
                vacunas.set(i, actualizada);
                escribirArchivo(vacunas);
                return true;
            }
        }
        return false;
    }

    // Busca una vacuna por su fecha
     public VacunaDTO buscarVacuna(String fecha) {
        for (VacunaDTO v : listar()) {
            if (v.getFechaVacuna().equalsIgnoreCase(fecha)) {
                return v;
            }
        }
        return null;
    }

    // Guarda toda la lista de vacunas en el archivo
    public void guardarLista(ArrayList<VacunaDTO> lista) {
        escribirArchivo(lista);
    }

    // Escribe el archivo con la lista completa
    private void escribirArchivo(ArrayList<VacunaDTO> vacunas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(vacunas);
        } catch (IOException e) {
            System.err.println("Error al guardar archivo de vacunas: " + e.getMessage());
        }
    }
}