/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package controlador;
//
//import dao.CitaDAO;
//import dao.MascotaDAO;
//import dao.PropietarioDAO;
//import dao.VeterinarioDAO;
//import dto.CitaDTO;
//import dto.MascotaDTO;
//import dto.PropietarioDTO;
//import dto.VeterinarioDTO;
//import exception.DatoInvalidoException;
//import modelo.Veterinario;
//
///**
// *
// * @author MI PC
// */
//public class ControladorCita {
//    
//    private CitaDAO dao = new CitaDAO();
//    
//    // Guarda una nueva cita con validación de campos
//    public void guardarVacuna(String fecha, String hora, String nombreM, 
//            String nombreP, boolean disponible) throws DatoInvalidoException {
//       // Validar que ningún campo esté vacío o nulo
//    if (fecha == null || fecha.isBlank() ||
//        hora == null || hora.isBlank() ||
//        nombreM == null || nombreM.isBlank() ||
//        nombreP == null || nombreP.isBlank()) {
//        throw new DatoInvalidoException("Todos los campos son obligatorios.");
//    }
//        // Validar formato de fecha: dd/MM/yyyy
//    if (!esFormatoFechaValido(fecha)) {
//        throw new DatoInvalidoException("La fecha de cita debe tener el formato dd/MM/aaaa");
//    }
//    
//        MascotaDAO mDao = new MascotaDAO();
//        MascotaDTO mascota = mDao.buscarMascota(nombreM);
//        if (mascota == null) {
//            throw new DatoInvalidoException("No existe una mascota con ese nombre...Registralo Primero");
//        }
//        
//        PropietarioDAO pDao = new PropietarioDAO();
//        PropietarioDTO mascota = mDao.buscarMascota(nombreM);
//        if (mascota == null) {
//            throw new DatoInvalidoException("No existe una mascota con ese nombre...Registralo Primero");
//        }
//
//        // Validar que no exista ya una vacuna registrada para esta mascota en la misma fecha
//        for (VacunaDTO v : dao.listar()) {
//        if (v.getMascota().getNombreM().equalsIgnoreCase(nombreM) &&
//            v.getFechaVacuna().equals(fechaVacuna)) {
//            throw new DatoInvalidoException("Ya existe una vacuna registrada para esta mascota en esa fecha");
//        }
//    }
//        VacunaDTO vacuna = new VacunaDTO(fechaVacuna, mascota, lote, fechaVacuna, proxima);
//        dao.guardarVacuna(vacuna); // Persistir la lista completa
//    }
//    
//    // Metodo auxiliar para validar formato de fecha
//    private boolean esFormatoFechaValido(String fecha) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        sdf.setLenient(false); // No permitir fechas como 32/01/2025
//        try {
//            sdf.parse(fecha);
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
//    }
//        // Busca una cita por la fecha
//    public CitaDTO buscarCita(String fecha) throws DatoInvalidoException {
//        if (fecha.isEmpty()) {
//            throw new DatoInvalidoException("Debe ingresar una fecha para buscar");
//        }
//
//        CitaDTO vacuna = dao.buscarVacuna(fecha);
//        if (vacuna == null) {
//            throw new DatoInvalidoException("No se encontró ninguna vacuna con esa fecha.");
//        }
//
//        return vacuna;
//    }
//
//    // Edita una vacuna existente
//    public boolean editarCita(String fecha, String hora, String nombreM, 
//            String nombreP, boolean disponible) throws DatoInvalidoException {
//        CitaDTO cita = buscarCita(fecha); // Lanza excepción si no existe
//
//        // Conversión de String a objeto MascotaDTO
//        MascotaDTO mascota = new MascotaDAO().buscarMascota(nombreM);
//        if (mascota == null) {
//            throw new DatoInvalidoException("No se encontro una mascota con el nombre: " + nombreM);
//        }
//        PropietarioDTO propietario = new PropietarioDAO().buscarPropietario(nombreP, nombreP);
//        if (propietario == null) {
//            throw new DatoInvalidoException("No se encontro un Propietario con el nombre: " + nombreP);
//        }
//        
//      
//
//        cita.setFecha(fecha);
//        cita.getHora();
//        cita.setMascota(mascota);
//        cita.setPropietario(propietario);
//       
//        
//        return dao.editarVacuna(vacuna);
//    }
//
//    // Elimina una vacuna por fecha
//    public boolean eliminarCita(String fecha) throws DatoInvalidoException {
//        CitaDTO cita = buscarCita(fecha); // Lanza excepción si no existe
//
//        CitaDTO.listaCitas.remove(cita); // Eliminar de la lista en memoria
////        cita.getMascota().getHistorial().remove(cita); // Quitar del historial de la mascota
//
//        return dao.eliminarVacuna(fecha); // Eliminar del archivo
//    }
//
//    // Retorna la lista actual de vacunas
//    public ArrayList<VacunaDTO> getListaVacunas() {
//        return VacunaDTO.listaVacunas;
//    }
//}
//
//}
