package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Propietario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String nombreP;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String direccion;
    private String email;

    private ArrayList<Mascota> listaMascotas;

    public Propietario(String nombreP, String tipoDocumento, String numeroDocumento,
                       String telefono, String direccion, String email) {
        this.nombreP = nombreP;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.listaMascotas = new ArrayList<>();
    }

    // Getters y Setters

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

    
    // Lógica relacionada a mascotas

    public void agregarMascota(Mascota mascota) {
        listaMascotas.add(mascota);
    }

    public boolean existeMascota(String nombreMascota) {
        return listaMascotas.stream().anyMatch(m -> m.getNombreM().equalsIgnoreCase(nombreMascota));
    }

    public boolean eliminarMascotaPorNombre(String nombreMascota) {
        return listaMascotas.removeIf(m -> m.getNombreM().equalsIgnoreCase(nombreMascota));
    }

    public boolean editarMascota(String nombreM, String especie, int edad, String raza, int peso) {
        for (Mascota m : listaMascotas) {
            if (m.getNombreM().equalsIgnoreCase(nombreM)) {
                m.setEspecie(especie);
                m.setEdad(edad);
                m.setRaza(raza);
                m.setPeso(peso);
                return true;
            }
        }
        return false;
    }
}
