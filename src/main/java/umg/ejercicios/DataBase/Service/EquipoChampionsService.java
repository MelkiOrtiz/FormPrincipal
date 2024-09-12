package umg.ejercicios.DataBase.Service;


import umg.ejercicios.DataBase.Dao.EquipoChampionsDAO;
import umg.ejercicios.DataBase.Model.EquipoChampions;

import java.util.List;

public class EquipoChampionsService {

    private EquipoChampionsDAO equipoDAO = new EquipoChampionsDAO();

    public boolean insertarEquipo(EquipoChampions equipo) {
        return equipoDAO.insertar(equipo);
    }

    public List<EquipoChampions> obtenerTodosLosEquipos() {
        return equipoDAO.obtenerTodos();
    }

    public boolean actualizarEquipo(EquipoChampions equipo) {
        return equipoDAO.actualizar(equipo);
    }

    public boolean eliminarEquipo(int idEquipo) {
        return equipoDAO.eliminar(idEquipo);
    }
}