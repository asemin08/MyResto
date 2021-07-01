package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.ServiceException;

import java.util.List;

/**
 * The interface Category service.
 */
public interface ICategoryService {
    /**
     * Gets all.
     *
     * @return the all
     * @throws ServiceException the service exception
     */
    List<CategoryDto> getAll() throws ServiceException;

    /**
     * Gets by id.
     *
     * @param idCategory the id category
     * @return the by id
     * @throws ServiceException the service exception
     */
    CategoryDto getById(int idCategory) throws ServiceException;

    /**
     * Gets by name.
     *
     * @param nameCategory the name category
     * @return the by name
     * @throws ServiceException the service exception
     */
    CategoryDto getByName(String nameCategory) throws ServiceException;

    /**
     * Create int.
     *
     * @param category the category
     * @return the int
     * @throws ServiceException the service exception
     */
    int create(CategoryDto category) throws ServiceException;

    /**
     * Update int.
     *
     * @param category the category
     * @return the int
     * @throws ServiceException the service exception
     */
    int update(CategoryDto category) throws ServiceException;

    /**
     * Delete int.
     *
     * @param category the category
     * @return the int
     * @throws ServiceException the service exception
     */
    int delete(CategoryDto category) throws ServiceException;

    /**
     * Delete int.
     *
     * @param idCategory the id category
     * @return the int
     * @throws ServiceException the service exception
     */
    int delete(int idCategory) throws ServiceException;
}
