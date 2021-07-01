package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

import java.util.Set;

/**
 * The interface Product dao.
 */
public interface IProductDao {
    /**
     * Create product int.
     *
     * @param product the product
     * @return the int
     * @throws DaoException the dao exception
     */
    int createProduct(Product product) throws DaoException;

    /**
     * Gets all products.
     *
     * @return the all products
     * @throws DaoException the dao exception
     */
    Set<Product> getAllProducts() throws DaoException;

    /**
     * Update product int.
     *
     * @param product the product
     * @return the int
     * @throws DaoException the dao exception
     */
    int updateProduct(Product product) throws DaoException;

    /**
     * Delete product int.
     *
     * @param idProduct the id product
     * @return the int
     * @throws DaoException the dao exception
     */
    int deleteProduct(int idProduct) throws DaoException;

    /**
     * Gets one product.
     *
     * @param idProduct the id product
     * @return the one product
     * @throws DaoException the dao exception
     */
    Product getOneProduct(int idProduct) throws DaoException;

}