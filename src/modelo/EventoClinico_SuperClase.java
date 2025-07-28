package modelo;

/**
 *
 * @author MI PC
 */
//---------declaro la clase padre--------------
public class EventoClinico_SuperClase {
    
    //----creo atributos que van a hacer heredados---------
    protected String fecha;
    protected Mascota mascota;

    //-------constructor-------------
    public EventoClinico_SuperClase(String fecha, Mascota mascota) {    
        this.fecha = fecha;
        this.mascota = mascota;
    }

    //-------getters and setters-------------

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
    
    
    //-------metodo que sera heredado------------
    public String mostrarDetalle() {
        return "Evento el " + fecha + " para la mascota " + mascota.getNombreM();
    }
}