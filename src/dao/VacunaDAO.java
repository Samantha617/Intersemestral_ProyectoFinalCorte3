/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Vacuna;

/**
 *
 * @author MI PC
 */
public class VacunaDAO {
    private static final String ARCHIVO = "vacunas.dat";

    public void guardarVacuna(Vacuna vacuna) {
        ArrayList<Vacuna> vacunas = listar();
        vacunas.add(vacuna);
        escribirArchivo(vacunas);
    }

    public ArrayList<Vacuna> listar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (ArrayList<Vacuna>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Retorna vacía si no existe o error
        }
    }

    public boolean eliminarVacuna(String fecha) {
        ArrayList<Vacuna> vacunas = listar();
        boolean eliminado = vacunas.removeIf(v -> v.getFecha().equalsIgnoreCase(fecha));
        if (eliminado) {
            escribirArchivo(vacunas);
        }
        return eliminado;
    }

    public boolean editarVacuna(Vacuna vacunaActualizada) {
        ArrayList<Vacuna> vacunas = listar();
        for (int i = 0; i < vacunas.size(); i++) {
            if (vacunas.get(i).getFecha().equalsIgnoreCase(vacunaActualizada.getFecha())) {
                vacunas.set(i, vacunaActualizada);
                escribirArchivo(vacunas);
                return true;
            }
        }
        return false;
    }

    public Vacuna buscarVacuna(String fecha) {
        for (Vacuna v : listar()) {
            if (v.getFecha().equalsIgnoreCase(fecha)) {
                return v;
            }
        }
        return null;
    }

    public void guardarLista(ArrayList<Vacuna> lista) {
        escribirArchivo(lista);
    }

    private void escribirArchivo(ArrayList<Vacuna> vacunas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(vacunas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}