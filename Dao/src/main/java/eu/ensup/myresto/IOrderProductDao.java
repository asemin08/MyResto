package eu.ensup.myresto;

import com.google.protobuf.ServiceException;
import eu.ensup.myresto.exceptions.DaoException;

import java.util.Set;

/**
 * The interface Order product dao.
 */
public interface IOrderProductDao {
    /**
     * Create order product int.
     *
     * @param orderProduct the order product
     * @return the int
     * @throws DaoException the dao exception
     */
    int createOrderProduct(OrderProduct orderProduct) throws DaoException;

    /**
     * Gets all order products for one user.
     *
     * @param idUser the id user
     * @return the all order products for one user
     * @throws DaoException the dao exception
     */
    Set<OrderProduct> getAllOrderProductsForOneUser(int idUser) throws DaoException;

    /**
     * Gets all order product.
     *
     * @return the all order product
     * @throws DaoException the dao exception
     */
    Set<OrderProduct> getAllOrderProduct() throws DaoException;

    /**
     * Update order product int.
     *
     * @param orderProduct the order product
     * @return the int
     * @throws DaoException the dao exception
     */
    int updateOrderProduct(OrderProduct orderProduct) throws DaoException;

    /**
     * Update order product by id int.
     *
     * @param id    the id
     * @param value the value
     * @return the int
     * @throws DaoException the dao exception
     */
    int updateOrderProductById(int id, String value) throws DaoException;

    /**
     * Delete order product int.
     *
     * @param idOrderProduct the id order product
     * @return the int
     * @throws DaoException the dao exception
     */
    int deleteOrderProduct(int idOrderProduct) throws DaoException;

    /**
     * Gets one order product.
     *
     * @param idOrderProduct the id order product
     * @return the one order product
     * @throws DaoException the dao exception
     */
    OrderProduct getOneOrderProduct(int idOrderProduct) throws DaoException;
}
