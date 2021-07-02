package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.ServiceException;

import java.util.Set;

/**
 * The interface Order product service.
 */
public interface IOrderProductService {
    /**
     * Create order product int.
     *
     * @param orderProductDto the order product dto
     * @return the int
     * @throws ServiceException the service exception
     */
    int createOrderProduct(OrderProductDto orderProductDto) throws ServiceException;

    /**
     * Gets all order products for one user.
     *
     * @param idUser the id user
     * @return the all order products for one user
     * @throws ServiceException the service exception
     */
    Set<OrderProductDto> getAllOrderProductsForOneUser(int idUser) throws ServiceException;

    Set<OrderProductDto> getAllOrderProduct() throws ServiceException;

    /**
     * Update order product int.
     *
     * @param orderProductDto the order product dto
     * @return the int
     * @throws ServiceException the service exception
     */
    int updateOrderProduct(OrderProductDto orderProductDto) throws ServiceException;
    int updateOrderProductById(int id, String value) throws ServiceException;

    /**
     * Delete order product int.
     *
     * @param idOrderProductDto the id order product dto
     * @return the int
     * @throws ServiceException the service exception
     */
    int deleteOrderProduct(int idOrderProductDto) throws ServiceException;

    /**
     * Gets one order product.
     *
     * @param idOrderProductDto the id order product dto
     * @return the one order product
     * @throws ServiceException the service exception
     */
    OrderProductDto getOneOrderProduct(int idOrderProductDto) throws ServiceException;

    /**
     * Convert order product to order product dto order product dto.
     *
     * @param product the product
     * @return the order product dto
     */
    OrderProductDto convertOrderProductToOrderProductDto(OrderProduct product);

    /**
     * Convert order product dto to order product order product.
     *
     * @param productDto the product dto
     * @return the order product
     */
    OrderProduct convertOrderProductDtoToOrderProduct(OrderProductDto productDto);

}
