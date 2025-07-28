package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MI PC
 */
//--------Declaro la clase---------
public class Consulta extends EventoClinico_SuperClase implements Serializable {

    private static final long serialVersionUID = 1L;

//--------------- Atributos -----------------
    private String codigo;
    private String diagnostico;
    private String tratamiento;
    private String medicamentos;

//..............................................................................
    // Lista estática para registrar todas las consultas
    public static ArrayList<Consulta> listaConsultas = new ArrayList<>();

//..............................................................................
//-------Creo metodo constructor-------
    public Consulta(String codigo, String fecha, Mascota mascota,
            String diagnostico, String tratamiento, String medicamentos) {
        super(fecha, mascota);
        this.codigo = codigo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.medicamentos = medicamentos;
    }

//-------Creo getters and setters---------
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public static ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public static void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        Consulta.listaConsultas = listaConsultas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    //---------metodo de la clase padre-----------------
    @Override
    public String mostrarDetalle() {
        return "----------------Consulta:--------------\n"
                + "Codigo: " + this.getCodigo() + "\n"
                + "Fecha: " + this.getFecha() + "\n"
                + "Diagnostico: " + this.getDiagnostico() + "\n"
                + "Tratamiento: " + this.getTratamiento() + "\n"
                + "Medicamentos: " + this.getMedicamentos() + "\n";
    }

//...............................................................................
    //CRUD
    //---------Metodo de Guardar una consulta-----------
    public static void guardarConsulta(Consulta nueva) {
        listaConsultas.add(nueva);
        nueva.getMascota().guardarEvento(nueva); // Añade al historial de la mascota
    }

    //-----------metodo de buscar consulta por codigo--------------
    public static Consulta buscarConsulta(String codigo) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getCodigo().equalsIgnoreCase(codigo)) {
                return consulta;
            }
        }
        return null; // No encontrada
    }

    //---------------Metodo de Editar consulta---------------------- 
    public static boolean editarConsulta(String codigo, String fecha, Mascota mascota,
            String diagnostico, String tratamiento, String medicamentos) {

        Consulta consulta = buscarConsulta(codigo);

        if (consulta != null) {

            // Actualizar datos
            consulta.setFecha(fecha);
            consulta.setMascota(mascota);
            consulta.setDiagnostico(diagnostico);
            consulta.setTratamiento(tratamiento);
            consulta.setMedicamentos(medicamentos);

            return true;
        }
        return false;
    }

    //---------------Eliminar consulta
    public static boolean eliminarConsulta(String codigo) {
        Consulta consulta = buscarConsulta(codigo);
        if (consulta != null) {
            listaConsultas.remove(consulta);
            // Tambien la quitamos del historial de la mascota
            consulta.getMascota().getHistorial().remove(consulta);
            return true;
        }
        return false;
    }
}
