package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.ServiceException;

import java.util.Set;

public interface IOrderProductService {
    int createOrderProduct(OrderProductDto orderProductDto) throws ServiceException;

    Set<OrderProductDto> getAllOrderProductsForOneUser(int idUser) throws ServiceException;

    int updateOrderProduct(OrderProductDto orderProductDto) throws ServiceException;

    int deleteOrderProduct(int idOrderProductDto) throws ServiceException;

    OrderProductDto getOneOrderProduct(int idOrderProductDto) throws ServiceException;

    OrderProductDto convertOrderProductToOrderProductDto(OrderProduct Product);

    OrderProduct convertOrderProductDtoToOrderProduct(OrderProductDto ProductDto);

}
