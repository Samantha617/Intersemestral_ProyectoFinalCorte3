/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.MascotaDTO;
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
public class MascotaDAO {
     private static final String ARCHIVO = "mascotas.dat";

    public void guardarMascota(MascotaDTO mascota) {
        ArrayList<MascotaDTO> mascotas = listar();
        mascotas.add(mascota);
        escribirArchivo(mascotas);
    }

    public ArrayList<MascotaDTO> listar() {
        ArrayList<MascotaDTO> lista = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            lista = (ArrayList<MascotaDTO>) in.readObject();
        } catch (Exception e) {
            // Si el archivo no existe o está vacío, retorna lista vacía
        }
        return lista;
    }

    private void escribirArchivo(ArrayList<MascotaDTO> mascotas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(mascotas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MascotaDTO buscarMascota(String nombreM) {
        for (MascotaDTO m : listar()) {
            if (m.getNombreM().equalsIgnoreCase(nombreM)) {
                return m;
            }
        }
        return null;
    }

    //metodo de eliminar
    public boolean eliminarMascota(String nombreM) {
        ArrayList<MascotaDTO> mascotas = listar();
        boolean eliminado = mascotas.removeIf(m -> m.getNombreM().equalsIgnoreCase(nombreM));
        if (eliminado) {
            escribirArchivo(mascotas);
        }
        return eliminado;
    }
    
    //metodo de editar
    public boolean editarMascota(MascotaDTO mascotaActualizada) {
    ArrayList<MascotaDTO> mascotas = listar();
    boolean encontrado = false;

    for (int i = 0; i < mascotas.size(); i++) {
        MascotaDTO m = mascotas.get(i);
        
        // Buscamos por nombre, suponiendo que el nombre de mascota es único
        if (m.getNombreM().equalsIgnoreCase(mascotaActualizada.getNombreM())) {
            mascotas.set(i, mascotaActualizada); // Reemplazamos con los nuevos datos
            encontrado = true;
            break;
        }
    }

    if (encontrado) {
        escribirArchivo(mascotas); // Guardamos la lista modificada
    }

    return encontrado; // true si se editó, false si no se encontró la mascota
}
}
