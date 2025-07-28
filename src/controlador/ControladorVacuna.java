
package controlador;

import dao.VacunaDAO;
import java.util.ArrayList;
import modelo.Mascota;
import modelo.Vacuna;

/**
 *
 * @author MI PC
 */
public class ControladorVacuna {
  private VacunaDAO dao;

    public ControladorVacuna() {
        dao = new VacunaDAO();
        Vacuna.listaVacunas = dao.listar(); // Carga las vacunas al iniciar
    }

    public void guardarVacuna(String fecha, String lote, Mascota mascota, String tipo, String proxima) {
        Vacuna vacuna = new Vacuna(fecha, lote, mascota, tipo, proxima);
        Vacuna.listaVacunas.add(vacuna);
        mascota.guardarEvento(vacuna);
        dao.guardarLista(Vacuna.listaVacunas); // guarda toda la lista
    }

    public Vacuna buscar(String fecha) {
        return dao.buscarVacuna(fecha);
    }

    public boolean editar(String fecha, String lote, Mascota mascota, String tipo, String proxima) {
        Vacuna vacuna = buscar(fecha);
        if (vacuna != null) {
            vacuna.setLote(lote);
            vacuna.setMascota(mascota);
            vacuna.setTipoDeVacuna(tipo);
            vacuna.setProximaDosis(proxima);
            dao.editarVacuna(vacuna);
            return true;
        }
        return false;
    }

    public boolean eliminar(String fecha) {
        Vacuna vacuna = buscar(fecha);
        if (vacuna != null) {
            Vacuna.listaVacunas.remove(vacuna);
            vacuna.getMascota().getHistorial().remove(vacuna);
            dao.eliminarVacuna(fecha);
            return true;
        }
        return false;
    }

    public ArrayList<Vacuna> getListaVacunas() {
        return Vacuna.listaVacunas;
    }
}
