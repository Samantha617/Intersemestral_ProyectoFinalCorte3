/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MI PC
 */
public class VacunaDTO implements Serializable {
   //--------atributos---------
    private String fechaVacuna;
    private MascotaDTO mascota;
    private String lote;
    private String tipoDeVacuna;
    private String proximaDosis;
//..............................................................................
    // Lista estatica que guarda todas las vacunas registradas
    public static ArrayList<VacunaDTO> listaVacunas = new ArrayList<>();
//..............................................................................    

    //-------constructor----------

    public VacunaDTO(String fechaVacuna, MascotaDTO mascota, String lote, String tipoDeVacuna, String proximaDosis) {
        this.fechaVacuna = fechaVacuna;
        this.mascota = mascota;
        this.lote = lote;
        this.tipoDeVacuna = tipoDeVacuna;
        this.proximaDosis = proximaDosis;
    }

    public VacunaDTO() {
    }
    

    //-------getters and setters----- 

    public String getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(String fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public MascotaDTO getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDTO mascota) {
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

    public static ArrayList<VacunaDTO> getListaVacunas() {
        return listaVacunas;
    }

    public static void setListaVacunas(ArrayList<VacunaDTO> listaVacunas) {
        VacunaDTO.listaVacunas = listaVacunas;
    }
    
}