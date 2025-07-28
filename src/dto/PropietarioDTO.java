package dto;

//-------importamos---------
import modelo.*;
import java.util.ArrayList;

//-----Declaro la clase-------------
public class PropietarioDTO {

//----creo los atributos--------
    private String nombreP;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String direccion;
    private String email;
    private ArrayList<Mascota> listaMascotas;
//................................................................................   
    //lista estatica que guarda todos los propietarios de las mascotas registradas
    public static ArrayList<PropietarioDTO> listaPropietarios = new ArrayList<>();
//................................................................................

//----Creo metodo constructor-------
    public PropietarioDTO(String nombreP, String tipoDocumento, String numeroDocumento, String telefono, String direccion, String email) {
        this.nombreP = nombreP;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        
        this.listaMascotas = new ArrayList<>();
    }

    public PropietarioDTO() {
    }

//----Creo getters and setters--------

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
}