/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.MascotaDAO;
import dao.PropietarioDAO;
import dto.MascotaDTO;
import exception.DatoInvalidoException;
import modelo.Propietario;

/**
 *
 * @author MI PC
 */
public class ControladorMascota {
     private MascotaDAO dao = new MascotaDAO();

    public void guardarMascota(String nombreM, String especie, int edad, String raza, int peso,
                               String documento, String nombrePropietario) throws DatoInvalidoException {
        
        // Validaciones de los campos
        if (nombreM == null || nombreM.trim().isEmpty())
            throw new DatoInvalidoException("El nombre de la mascota es obligatorio.");
        if (especie == null || especie.trim().isEmpty())
            throw new DatoInvalidoException("La especie es obligatoria.");
        if (edad < 0 || edad > 50)
            throw new DatoInvalidoException("La edad debe estar entre 0 y 50 años.");
        if (raza == null || raza.trim().isEmpty())
            throw new DatoInvalidoException("La raza es obligatoria.");
        if (peso <= 0 || peso > 100)
            throw new DatoInvalidoException("El peso debe ser mayor que 0 y menor a 100 kg.");

        // Buscar propietario en el DAO
        PropietarioDAO pDao = new PropietarioDAO();
        Propietario propietario = pDao.buscarPropietario(documento, nombrePropietario);

        if (propietario == null)
            throw new DatoInvalidoException("No existe un propietario con ese nombre y documento...Registralo Primero");

        // Crear DTO y guardar
        MascotaDTO dto = new MascotaDTO(nombreM, especie, edad, raza, peso, propietario);
        dao.guardarMascota(dto);
    }

    public MascotaDTO buscarMascota(String nombreM) {
        return dao.buscarMascota(nombreM);
    }

    public boolean eliminarMascota(String nombreM) {
        return dao.eliminarMascota(nombreM);
    }
    
    public boolean editarMascota(String nombreM, String especie, int edad, String raza, int peso,
                                 String documento, String nombrePropietario) throws DatoInvalidoException {
        
        // Validaciones
        if (nombreM == null || nombreM.trim().isEmpty())
            throw new DatoInvalidoException("El nombre de la mascota es obligatorio.");
        if (especie == null || especie.trim().isEmpty())
            throw new DatoInvalidoException("La especie es obligatoria.");
        if (edad < 0 || edad > 50)
            throw new DatoInvalidoException("La edad debe estar entre 0 y 50 años.");
        if (raza == null || raza.trim().isEmpty())
            throw new DatoInvalidoException("La raza es obligatoria.");
        if (peso <= 0 || peso > 100)
            throw new DatoInvalidoException("El peso debe ser mayor que 0 y menor a 100 kg.");

        // Verificar existencia del propietario
        PropietarioDAO pDao = new PropietarioDAO();
        Propietario propietario = pDao.buscarPropietario(documento, nombrePropietario);

        if (propietario == null)
            throw new DatoInvalidoException("No existe un propietario con ese nombre y documento.");

        // Crear nuevo objeto con datos actualizados
        MascotaDTO mascotaActualizada = new MascotaDTO(nombreM, especie, edad, raza, peso, propietario);

        // Llamar al DAO para editar
        return dao.editarMascota(mascotaActualizada);
    }
}
