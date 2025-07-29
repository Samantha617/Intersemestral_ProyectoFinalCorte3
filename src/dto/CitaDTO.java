/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.Mascota;
import modelo.Propietario;
import modelo.Veterinario;

/**
 *
 * @author MI PC
 */
public class CitaDTO  implements Serializable{
    //------atributos-------------------------------

    private String fecha;
    private String hora;
    private MascotaDTO mascota;
    private PropietarioDTO propietario;
    private VeterinarioDTO veterinario;
//..............................................................................
    //------------lista estatica----------
    public static ArrayList<CitaDTO> listaCitas = new ArrayList<>();
//..............................................................................

    //--------------------constructor---------------------------------

    public CitaDTO(String fecha, String hora, MascotaDTO mascota, 
            PropietarioDTO propietario, VeterinarioDTO veterinario) {
        this.fecha = fecha;
        this.hora = hora;
        this.mascota = mascota;
        this.propietario = propietario;
        this.veterinario = veterinario;
    }
    
    //------------getters and setters---------------------------

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public MascotaDTO getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDTO mascota) {
        this.mascota = mascota;
    }

    public PropietarioDTO getPropietario() {
        return propietario;
    }

    public void setPropietario(PropietarioDTO propietario) {
        this.propietario = propietario;
    }

    public VeterinarioDTO getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(VeterinarioDTO veterinario) {
        this.veterinario = veterinario;
    }

    public static ArrayList<CitaDTO> getListaCitas() {
        return listaCitas;
    }

    public static void setListaCitas(ArrayList<CitaDTO> listaCitas) {
        CitaDTO.listaCitas = listaCitas;
    }

    //---------metodo de la clase padre-----------
//    @Override
//    public String mostrarDetalle() {
//        return "-----------------Cita:----------------------\n"
//                + "Fecha: " + this.getFecha() + "\n"
//                + "Hora: " + this.getHora() + "\n"
//                + "Propietario: " + this.getPropietario().getNombreP()+ "\n"       
//                + "Veterinario: " + this.getVeterinario().getNombreV()+ "\n";
//    }
}

