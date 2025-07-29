/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.Mascota;

/**
 *
 * @author MI PC
 */
public class ConsultaDTO implements Serializable {
    
   //--------------- Atributos -----------------
    private String codigo;
    private String fecha;
    private MascotaDTO mascota;
    private String diagnostico;
    private String tratamiento;
    private String medicamentos;

//..............................................................................
    // Lista estática para registrar todas las consultas
    public static ArrayList<ConsultaDTO> listaConsultas = new ArrayList<>();

//..............................................................................
//-------Creo metodo constructor-------

    public ConsultaDTO(String codigo, String fecha, MascotaDTO mascota, 
            String diagnostico, String tratamiento, String medicamentos) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.mascota = mascota;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public MascotaDTO getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDTO mascota) {
        this.mascota = mascota;
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

    public static ArrayList<ConsultaDTO> getListaConsultas() {
        return listaConsultas;
    }

    public static void setListaConsultas(ArrayList<ConsultaDTO> listaConsultas) {
        ConsultaDTO.listaConsultas = listaConsultas;
    }
   

    //---------metodo de la clase padre-----------------
//    @Override
//    public String mostrarDetalle() {
//        return "----------------Consulta:--------------\n"
//                + "Codigo: " + this.getCodigo() + "\n"
//                + "Fecha: " + this.getFecha() + "\n"
//                + "Diagnostico: " + this.getDiagnostico() + "\n"
//                + "Tratamiento: " + this.getTratamiento() + "\n"
//                + "Medicamentos: " + this.getMedicamentos() + "\n";
//    }
}


