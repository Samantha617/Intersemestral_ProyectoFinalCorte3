package controlador;

import dao.MascotaDAO;
import dao.VacunaDAO;
import dto.MascotaDTO;
import dto.VacunaDTO;
import exception.DatoInvalidoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 *
 * @author MI PC
 */
public class ControladorVacuna {

    private VacunaDAO dao = new VacunaDAO();

    // Guarda una nueva vacuna con validación de campos
    public void guardarVacuna(String fechaVacuna, String lote, String nombreM, String tipo, String proxima) throws DatoInvalidoException {
       // Validar que ningún campo esté vacío o nulo
    if (fechaVacuna == null || fechaVacuna.isBlank() ||
        lote == null || lote.isBlank() ||
        nombreM == null || nombreM.isBlank() ||
        tipo == null || tipo.isBlank() ||
        proxima == null || proxima.isBlank()) {
        throw new DatoInvalidoException("Todos los campos son obligatorios.");
    }
        // Validar formato de fecha: dd/MM/yyyy
    if (!esFormatoFechaValido(fechaVacuna)) {
        throw new DatoInvalidoException("La fecha de vacunacion debe tener el formato dd/MM/aaaa");
    }

    if (!esFormatoFechaValido(proxima)) {
        throw new DatoInvalidoException("La proxima fecha de vacunacion debe tener el formato dd/MM/aaaa");
    }
    
        MascotaDAO mDao = new MascotaDAO();
        MascotaDTO mascota = mDao.buscarMascota(nombreM);
        if (mascota == null) {
            throw new DatoInvalidoException("No existe una mascota con ese nombre...Registralo Primero");
        }

        // Validar que no exista ya una vacuna registrada para esta mascota en la misma fecha
        for (VacunaDTO v : dao.listar()) {
        if (v.getMascota().getNombreM().equalsIgnoreCase(nombreM) &&
            v.getFechaVacuna().equals(fechaVacuna)) {
            throw new DatoInvalidoException("Ya existe una vacuna registrada para esta mascota en esa fecha");
        }
    }
        VacunaDTO vacuna = new VacunaDTO(fechaVacuna, mascota, lote, fechaVacuna, proxima);
        dao.guardarVacuna(vacuna); // Persistir la lista completa
    }
    
    // Metodo auxiliar para validar formato de fecha
    private boolean esFormatoFechaValido(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // No permitir fechas como 32/01/2025
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
        // Busca una vacuna por la fecha
    public VacunaDTO buscarVacuna(String fecha) throws DatoInvalidoException {
        if (fecha.isEmpty()) {
            throw new DatoInvalidoException("Debe ingresar una fecha para buscar");
        }

        VacunaDTO vacuna = dao.buscarVacuna(fecha);
        if (vacuna == null) {
            throw new DatoInvalidoException("No se encontró ninguna vacuna con esa fecha.");
        }

        return vacuna;
    }

    // Edita una vacuna existente
    public boolean editarVacuna(String fecha, String lote, String nombreM, String tipo, String proxima) throws DatoInvalidoException {
        VacunaDTO vacuna = buscarVacuna(fecha); // Lanza excepción si no existe

        // Conversión de String a objeto MascotaDTO
        MascotaDTO mascota = new MascotaDAO().buscarMascota(nombreM);
        if (mascota == null) {
            throw new DatoInvalidoException("No se encontro una mascota con el nombre: " + nombreM);
        }

        vacuna.setLote(lote);
        vacuna.setMascota(mascota);
        vacuna.setTipoDeVacuna(tipo);
        vacuna.setProximaDosis(proxima);

        return dao.editarVacuna(vacuna);
    }

    // Elimina una vacuna por fecha
    public boolean eliminarVacuna(String fecha) throws DatoInvalidoException {
        VacunaDTO vacuna = buscarVacuna(fecha); // Lanza excepción si no existe

        VacunaDTO.listaVacunas.remove(vacuna); // Eliminar de la lista en memoria
//        vacuna.getMascota().getHistorial().remove(vacuna); // Quitar del historial de la mascota

        return dao.eliminarVacuna(fecha); // Eliminar del archivo
    }

    // Retorna la lista actual de vacunas
    public ArrayList<VacunaDTO> getListaVacunas() {
        return VacunaDTO.listaVacunas;
    }
}
