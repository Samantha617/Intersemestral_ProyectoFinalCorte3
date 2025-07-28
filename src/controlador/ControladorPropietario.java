package controlador;

import dao.PropietarioDAO;
import dto.PropietarioDTO;
import exception.DatoInvalidoException;
import modelo.Propietario;

/**
 *
 * @author MI PC
 */
public class ControladorPropietario {

    private PropietarioDAO dao = new PropietarioDAO();

//     Guarda un propietario 
    public void guardarPropietario(PropietarioDTO dto) throws DatoInvalidoException {
        // Validar que ningun campo este vacio o nulo
        if (dto.getNombreP().isBlank()
                || dto.getTipoDocumento().isBlank()
                || dto.getNumeroDocumento().isBlank()
                || dto.getTelefono().isBlank()
                || dto.getDireccion().isBlank()
                || dto.getEmail().isBlank()) {

            throw new DatoInvalidoException("No has llenado todos los campos por favor llenalos");
        }

        if (dao.existePropietario(dto.getNumeroDocumento(), dto.getNombreP())){
            throw new DatoInvalidoException("Ya existe un propietario con ese numero de documento");
        }

        // Convertir DTO a modelo
        Propietario nuevo = new Propietario(
                dto.getNombreP(),
                dto.getTipoDocumento(),
                dto.getNumeroDocumento(),
                dto.getTelefono(),
                dto.getDireccion(),
                dto.getEmail()
        );

        dao.guardar(nuevo);
    }

//     Busca un propietario por número de documento
    public Propietario buscarPropietario(String documento) throws DatoInvalidoException {
        if (documento.isBlank()) {
            throw new DatoInvalidoException("Debe ingresar un documento para buscar");
        }

        Propietario encontrado = dao.buscarPropietario(documento, documento);

        if (encontrado == null) {
            throw new DatoInvalidoException("No se encontro ningun propietario con ese documento.");
        }

        return encontrado;
    }

//     Elimina un propietario por su documento
    public void eliminarPropietario(String documento) throws DatoInvalidoException {
        if (documento.isBlank()) {
            throw new DatoInvalidoException("Debe ingresar un documento para eliminar");
        }

        boolean eliminado = dao.eliminarPropietario(documento);

        if (!eliminado) {
            throw new DatoInvalidoException("No se encontro ningun propietario con ese documento");
        }
    }

//    Edita los datos de un propietario existente
    public void editarPropietario(PropietarioDTO dto) throws DatoInvalidoException {
        if (dto.getNumeroDocumento().isBlank()) {
            throw new DatoInvalidoException("Debe ingresar numero de documento para editar");
        }

        Propietario existente = dao.buscarPropietario(dto.getNumeroDocumento(),dto.getNombreP());

        if (existente == null) {
            throw new DatoInvalidoException("No se encontro un propietario con ese documento");
        }

        // Actualizamos los datos del propietario
        existente.setNombreP(dto.getNombreP());
        existente.setTipoDocumento(dto.getTipoDocumento());
        existente.setTelefono(dto.getTelefono());
        existente.setDireccion(dto.getDireccion());
        existente.setEmail(dto.getEmail());

        // Reescribimos la lista completa con el objeto actualizado
        dao.eliminarPropietario(dto.getNumeroDocumento());
        dao.guardar(existente);
    }
}
