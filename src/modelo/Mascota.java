package modelo;

//-------Declaro la clase-----------
import java.io.Serializable;
import java.util.ArrayList;
import modelo.EventoClinico_SuperClase;

public class Mascota implements Serializable{

    private static final long serialVersionUID = 1L;
    
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
    public static ArrayList<Mascota> listaMascotas = new ArrayList<>();

//..............................................................................
//------Creo constructor------------
    public Mascota(String nombreM, String especie, int edad,
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

//----------------ANTES:Metodo de agregar consulta------------    
    //-----------AHORA: guarda cualquier objeto que hereden de 
    //EventoClinico_SuperClase en el historial de la mascota-------------
    public void guardarEvento(EventoClinico_SuperClase evento) {
        historial.add(evento);
    }

    // Metodo para mostrar el historial de eventos clinicos
    //forma polimorfica de registrar diferentes tipos de eventos en un solo metodo
    public String mostrarHistorial() {

        //Se crea un objeto vacio de tipo StringBuilder, llamado sb
        
      //Aqui se iran acumulando los detalles de los eventos clinicos 
      //(consultas,vacunas,citas,etc)
        StringBuilder sb = new StringBuilder();
        
        for (EventoClinico_SuperClase evenCli : historial) {
            sb.append(evenCli.mostrarDetalle()).append("\n");
        }
        return sb.toString();
    }

}
