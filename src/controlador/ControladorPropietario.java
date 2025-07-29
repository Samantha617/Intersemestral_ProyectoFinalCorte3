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
    // Validar que ningún campo esté vacío o nulo
    if (dto.getNombreP().isBlank()
            || dto.getTipoDocumento().isBlank()
            || dto.getNumeroDocumento().isBlank()
            || dto.getTelefono().isBlank()
            || dto.getDireccion().isBlank()
            || dto.getEmail().isBlank()) {
        throw new DatoInvalidoException("No has llenado todos los campos, por favor llénalos.");
    }

    // Validar longitud del número de documento (mínimo 6 caracteres)
    if (dto.getNumeroDocumento().length() < 6) {
        throw new DatoInvalidoException("El número de documento debe tener al menos 6 caracteres.");
    }

    // Validar teléfono: exactamente 10 dígitos numéricos
    if (!dto.getTelefono().matches("\\d{10}")) {
        throw new DatoInvalidoException("El teléfono debe tener exactamente 10 dígitos numéricos.");
    }

    // Validar email: debe contener "@gmail.com"
    if (!dto.getEmail().endsWith("@gmail.com")) {
        throw new DatoInvalidoException("El correo electrónico debe ser de dominio @gmail.com.");
    }

    // Verificar si ya existe el propietario
    if (dao.existePropietario(dto.getNumeroDocumento(), dto.getNombreP())) {
        throw new DatoInvalidoException("Ya existe un propietario con ese número de documento.");
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
    public Propietario buscarPropietario(String numeroDocumento, String nombreP) throws DatoInvalidoException {
        if (numeroDocumento.isBlank() || nombreP.isBlank()) {
            throw new DatoInvalidoException("Debe ingresar un documento o nombre para buscar");
        }

        Propietario encontrado = dao.buscarPropietario(numeroDocumento, numeroDocumento);

        if (encontrado == null) {
            throw new DatoInvalidoException("No se encontro ningun propietario con ese documento y/o nombre");
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
