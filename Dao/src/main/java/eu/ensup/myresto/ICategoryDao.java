package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

import java.util.List;

/**
 * The interface Category dao.
 */
public interface ICategoryDao {
    /**
     * Gets all.
     *
     * @return the all
     * @throws DaoException the dao exception
     */
    List<Category> getAll() throws DaoException;

    /**
     * Gets by id.
     *
     * @param idCategory the id category
     * @return the by id
     * @throws DaoException the dao exception
     */
    Category getById(int idCategory) throws DaoException;

    /**
     * Gets by name.
     *
     * @param nameCategory the name category
     * @return the by name
     * @throws DaoException the dao exception
     */
    Category getByName(String nameCategory) throws DaoException;

    /**
     * Create int.
     *
     * @param category the category
     * @return the int
     * @throws DaoException the dao exception
     */
    int create(Category category) throws DaoException;

    /**
     * Update int.
     *
     * @param category the category
     * @return the int
     * @throws DaoException the dao exception
     */
    int update(Category category) throws DaoException;

    /**
     * Delete int.
     *
     * @param category the category
     * @return the int
     * @throws DaoException the dao exception
     */
    int delete(Category category) throws DaoException;

    /**
     * Delete int.
     *
     * @param idCategory the id category
     * @return the int
     * @throws DaoException the dao exception
     */
    int delete(int idCategory) throws DaoException;
}
