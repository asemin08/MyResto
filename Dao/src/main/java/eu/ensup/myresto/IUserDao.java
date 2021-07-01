package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

/**
 * The interface User dao.
 */
public interface IUserDao {

    /**
     * Create int.
     *
     * @param user the user
     * @return the int
     * @throws DaoException the dao exception
     */
    int create(User user) throws DaoException;

    /**
     * Update int.
     *
     * @param user the user
     * @return the int
     * @throws DaoException the dao exception
     */
    int update(User user) throws DaoException;

    /**
     * Delete int.
     *
     * @param userId the user id
     * @return the int
     * @throws DaoException the dao exception
     */
    int delete(int userId) throws DaoException;

    /**
     * Gets by id.
     *
     * @param userId the user id
     * @return the by id
     * @throws DaoException the dao exception
     */
    User getById(int userId) throws DaoException;

    /**
     * Gets by login.
     *
     * @param login the login
     * @return the by login
     * @throws DaoException the dao exception
     */
    User getByLogin(String login) throws DaoException;


}
