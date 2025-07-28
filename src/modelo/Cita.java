package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MI PC
 */
public class Cita extends EventoClinico_SuperClase implements Serializable{
    
    private static final long serialVersionUID = 1L;
//------atributos-------------------------------

    private String hora;
    private Propietario propietario;
    private Veterinario veterinario;
//..............................................................................
    //------------lista estatica----------
    public static ArrayList<Cita> listaCitas = new ArrayList<>();
//..............................................................................

    //--------------------constructor---------------------------------
    public Cita(String fecha, String hora, Mascota mascota, Propietario propietario,
            Veterinario veterinario) {

        super(fecha, mascota);
        this.hora = hora;
        this.propietario = propietario;
        this.veterinario = veterinario;
    }

    //------------getters and setters---------------------------
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public static ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public static void setListaCitas(ArrayList<Cita> listaCitas) {
        Cita.listaCitas = listaCitas;
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

    //---------metodo de la clase padre-----------
    @Override
    public String mostrarDetalle() {
        return "-----------------Cita:----------------------\n"
                + "Fecha: " + this.getFecha() + "\n"
                + "Hora: " + this.getHora() + "\n"
                + "Propietario: " + this.getPropietario().getNombreP()+ "\n"       
                + "Veterinario: " + this.getVeterinario().getNombreV()+ "\n";
    }

    //---------------CRUD-------------------------------
    // Guardar cita (validando que no se repita fecha+hora)
    public static boolean guardarCita(Cita cita) {
        for (Cita c : listaCitas) {
            if (c.getFecha().equals(cita.getFecha())
                    && c.getHora().equalsIgnoreCase(cita.getHora())) {
                return false; // ya existe una cita en esa fecha y hora
            }
        }
        listaCitas.add(cita);
        // Tambien se agrega al historial de la mascota
        cita.getMascota().guardarEvento(cita);
        return true;
    }

    // Buscar por fecha y hora
    public static Cita buscarCita(String fecha, String hora) {
        for (Cita c : listaCitas) {
            if (c.getFecha().equalsIgnoreCase(fecha) && c.getHora().equalsIgnoreCase(hora)) {
                return c;
            }
        }
        return null;
    }

    // Editar cita
    public static boolean editarCita(String fecha, String hora, Mascota mascota,
            Propietario propietario, Veterinario veterinario) {

        Cita cita = buscarCita(fecha, hora);
        if (cita != null) {
            cita.setFecha(fecha);
            cita.setHora(hora);
            cita.setMascota(mascota);
            cita.setPropietario(propietario);
            cita.setVeterinario(veterinario);
            return true;
        }
        return false;
    }

    //-------------Eliminar cita-------------------
    public static boolean eliminarCita(String fecha, String hora) {
        Cita cita = buscarCita(fecha, hora);
        if (cita != null) {
            listaCitas.remove(cita);
            // Eliminar tambien del historial clinico de la mascota
            cita.getMascota().getHistorial().remove(cita);
            return true;
        }
        return false;
    }
}
