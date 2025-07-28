/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.VeterinarioDAO;
import dto.VeterinarioDTO;
import exception.DatoInvalidoException;
import modelo.Veterinario;

/**
 *
 * @author MI PC
 */
public class ControladorVeterinario {

    private VeterinarioDAO dao = new VeterinarioDAO();

    // Guarda un nuevo veterinario
    public void guardarVeterinario(VeterinarioDTO dto) throws DatoInvalidoException {
        if (dto.getNombreV().isBlank() || dto.getEspecialidad().isBlank()) {
            throw new DatoInvalidoException("Todos los campos deben estar llenos.");
        }

        if (dao.existeVeterinario(dto.getNombreV())) {
            throw new DatoInvalidoException("Ya existe un veterinario con ese nombre.");
        }

        Veterinario nuevo = new Veterinario(
                dto.getNombreV(),
                dto.getEspecialidad(),
                dto.isDisponible()
        );

        dao.guardar(nuevo);
    }

    // Buscar un veterinario por nombre
    public Veterinario buscarVeterinario(String nombreV) throws DatoInvalidoException {
        if (nombreV.isBlank()) {
            throw new DatoInvalidoException("Debe ingresar un nombre para buscar");
        }

        Veterinario encontrado = dao.buscarVeterinario(nombreV);

        if (encontrado == null) {
            throw new DatoInvalidoException("No se encontró ningún veterinario con ese nombre.");
        }

        return encontrado;
    }

    // Eliminar un veterinario por nombre
    public void eliminarVeterinario(String nombreV) throws DatoInvalidoException {
        if (nombreV.isBlank()) {
            throw new DatoInvalidoException("Debe ingresar un nombre para eliminar");
        }

        boolean eliminado = dao.eliminarVeterinario(nombreV);

        if (!eliminado) {
            throw new DatoInvalidoException("No se encontró ningún veterinario con ese nombre");
        }
    }

    // Editar un veterinario
    public void editarVeterinario(VeterinarioDTO dto) throws DatoInvalidoException {
        if (dto.getNombreV().isBlank()) {
            throw new DatoInvalidoException("Debe ingresar un nombre para editar");
        }

        Veterinario existente = dao.buscarVeterinario(dto.getNombreV());

        if (existente == null) {
            throw new DatoInvalidoException("No se encontró un veterinario con ese nombre");
        }

        existente.setEspecialidad(dto.getEspecialidad());
        existente.setDisponible(dto.isDisponible());

        dao.editarVeterinario(existente);
    }
}
