package umg.ejercicios.DataBase.Service;

import umg.ejercicios.DataBase.Dao.UserDao;
import umg.ejercicios.DataBase.Model.User;
import umg.ejercicios.DataBase.db.DatabaseConnection;
import umg.ejercicios.DataBase.db.TransactionManager;

import java.sql.*;

public class UserService {
    private UserDao userDao = new UserDao();


    public boolean eliminarUser(String idtext) throws SQLException {
        return userDao.deleteUserById(idtext);
    }

    public boolean checkEmailDuplicated(String email) {
        return userDao.isEmailDuplicated(email);
    }

    public void createUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            TransactionManager tm = new TransactionManager(connection);
            tm.beginTransaction();
            try {
                userDao.insertUser(user);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }
    }
    public boolean actualizarUser(User user) throws SQLException {
        return userDao.updateUser(user);
    }


    public User getUserByCarne(String Carne) throws SQLException {
        return userDao.getUserByCarne(Carne);
    }
}