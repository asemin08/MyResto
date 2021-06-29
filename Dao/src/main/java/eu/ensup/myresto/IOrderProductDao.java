package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

import java.util.Set;

public interface IOrderProductDao {
    int createOrderProduct(OrderProduct orderProduct) throws DaoException;

    Set<OrderProduct> getAllOrderProductsForOneUser(int idUser) throws DaoException;

    int updateOrderProduct(OrderProduct orderProduct) throws DaoException;

    int deleteOrderProduct(int idOrderProduct) throws DaoException;

    OrderProduct getOneOrderProduct(int idOrderProduct) throws DaoException;
}
