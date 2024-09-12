package umg.ejercicios.DataBase.Service;

import umg.ejercicios.DataBase.Dao.TbDatosDAO;
import umg.ejercicios.DataBase.Model.TbDatos;

import java.sql.SQLException;
import java.util.List;

public class TbDatosService {

    private TbDatosDAO tbDatosDAO = new TbDatosDAO();

    public boolean insertarDato(TbDatos dato) {
        return tbDatosDAO.insertar(dato);
    }

    public List<TbDatos> obtenerTodosLosDatos() {
        return tbDatosDAO.obtenerTodos();
    }
    public TbDatos obtenerPorId(int id) throws SQLException {
        return tbDatosDAO.obtenerPorId(id);
    }

    public boolean actualizarDato(TbDatos dato) {
        return tbDatosDAO.actualizar(dato);
    }

    public boolean eliminarDato(int codigo) {
        return tbDatosDAO.eliminar(codigo);
    }
}