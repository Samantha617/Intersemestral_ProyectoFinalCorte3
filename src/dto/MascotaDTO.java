
package dto;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.EventoClinico_SuperClase;
import modelo.Propietario;

/**
 *
 * @author MI PC
 */
public class MascotaDTO implements Serializable{
  
    //-------Creo los atributos---------
    private String nombreM;
    private String especie;
    private int edad;
    private String raza;
    private int peso;
     private Propietario propietario;

    private ArrayList<EventoClinico_SuperClase> historial;

//............................................................................    
    // Lista estatica que guarda todas las mascotas registradas
    public static ArrayList<MascotaDTO> listaMascotas = new ArrayList<>();

//..............................................................................
    
    //------Creo constructor------------
    
    public MascotaDTO(String nombreM, String especie, int edad,
            String raza, int peso,Propietario propietario) { 
        //pasar el arraylist----
        this.nombreM = nombreM;
        this.especie = especie;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
        this.propietario = propietario;
        this.historial = new ArrayList<>();
    }

    public MascotaDTO() {
    }
    
    
    //------Creo getters and setters--------

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public ArrayList<EventoClinico_SuperClase> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<EventoClinico_SuperClase> historial) {
        this.historial = historial;
    }

    public static ArrayList<MascotaDTO> getListaMascotas() {
        return listaMascotas;
    }

    public static void setListaMascotas(ArrayList<MascotaDTO> listaMascotas) {
        MascotaDTO.listaMascotas = listaMascotas;
    }
   
}
