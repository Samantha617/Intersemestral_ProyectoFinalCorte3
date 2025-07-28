package modelo;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author MI PC
 */
public class Vacuna extends EventoClinico_SuperClase implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //--------atributos---------
    private String lote;
    private String tipoDeVacuna;
    private String proximaDosis;
//..............................................................................
    // Lista estatica que guarda todas las vacunas registradas
    public static ArrayList<Vacuna> listaVacunas = new ArrayList<>();
//..............................................................................    

    //-------constructor----------
    public Vacuna(String fecha,String lote, Mascota mascota, String tipoDeVacuna, String proximaDosis) {
        super(fecha, mascota);//llamo constructor de la clase padre
        this.lote = lote;
        this.tipoDeVacuna = tipoDeVacuna;
        this.proximaDosis = proximaDosis;
    }
    
     //-------getters and setters----- 
    
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
   
    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getTipoDeVacuna() {
        return tipoDeVacuna;
    }

    public void setTipoDeVacuna(String tipoDeVacuna) {
        this.tipoDeVacuna = tipoDeVacuna;
    }

    public String getProximaDosis() {
        return proximaDosis;
    }

    public void setProximaDosis(String proximaDosis) {
        this.proximaDosis = proximaDosis;
    }

    public static ArrayList<Vacuna> getListaVacunas() {
        return listaVacunas;
    }

    public static void setListaVacunas(ArrayList<Vacuna> listaVacunas) {
        Vacuna.listaVacunas = listaVacunas;
    }

    //--------metodo heredado cambiamos evento por vacuna de tipo--------------------
   @Override
public String mostrarDetalle() {
    return "---------------Vacuna:------------------\n"
         + "Fecha: " + this.getFecha() + "\n"
         + "Tipo: " + this.getTipoDeVacuna() + "\n"
         + "Proxima dosis: " + this.getProximaDosis() + "\n";
}

//    //----------CRUD-----------------------------------
//    //-----------Metodo para guardar y agregar al historial de la mascota ----------
//    public static void guardarVacuna(Vacuna vacuna) {
//        listaVacunas.add(vacuna);
//        vacuna.getMascota().guardarEvento(vacuna); // agrega al historial
//    }
//    
//    // ---------- Buscar vacuna por fecha ----------
//    public static Vacuna buscarVacuna(String fecha) {
//        for (Vacuna v : listaVacunas) {
//            if (v.getFecha().equalsIgnoreCase(fecha)) {
//                return v;
//            }
//        }
//        return null;
//    }
//    
//    //----------metodo de editar vacuna------------
//    public static boolean editarVacuna(String fecha,String lote, 
//            Mascota mascota, String tipoDeVacuna, String proximaDosis){
//        
//        Vacuna vacuna = buscarVacuna(fecha);
//        if(vacuna != null){
//            
//            vacuna.setTipoDeVacuna(tipoDeVacuna);
//            vacuna.setMascota(mascota);
//            vacuna.setTipoDeVacuna(tipoDeVacuna);
//            vacuna.setLote(lote);
//            vacuna.setProximaDosis(proximaDosis);
//            return true;
//        }
//        return false;
//    }
//    //------------Eliminar vacuna--------------
//    public static boolean eliminarVacuna(String fecha) {
//        Vacuna vacuna = buscarVacuna(fecha);
//        if (vacuna != null) {
//            listaVacunas.remove(vacuna);
//            vacuna.getMascota().getHistorial().remove(vacuna); // elimina del historial también
//            return true;
//        }
//        return false;
//    }
}
