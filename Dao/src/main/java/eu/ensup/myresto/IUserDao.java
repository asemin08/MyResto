package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

public interface IUserDao {

    int create(User user) throws DaoException;

    int update(User user) throws DaoException;

    int delete(int userId) throws DaoException;

    User getById(int userId) throws DaoException;

    User getByLogin(String login) throws DaoException;


}
