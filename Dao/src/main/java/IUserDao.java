import exceptions.DaoException;

import java.sql.SQLException;

public interface IUserDao {

    int create(User user) throws  DaoException;
    int update(User user) throws DaoException;
    int delete(int userId) throws DaoException;
    User getById(int userId) throws DaoException;
    User getByLogin(String login) throws DaoException;



}
