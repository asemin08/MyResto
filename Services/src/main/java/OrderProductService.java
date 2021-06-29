import eu.ensup.myresto.IOrderProductDao;
import eu.ensup.myresto.OrderProductDao;
import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.HashSet;
import java.util.Set;

public class OrderProductService implements IOrderProductService{

    private IOrderProductDao orderProduct;

    public OrderProductService(IOrderProductDao productDao) {
        this.orderProduct = productDao;
    }

    public OrderProductService() {
        this.orderProduct = new OrderProductDao();
    }
    @Override
    public int createOrderProduct(OrderProductDto orderProductDto) throws ServiceException {
        try {
            return orderProduct.createOrderProduct(convertOrderProductDtoToOrderProduct(orderProductDto));
        } catch (DaoException e) {
            throw new ServiceException(OrderProductService.class.getName(), "createOrderProduct", e.getMessage(), "Une erreur s'est produite lors de la récupération de la commande");
        }
    }

    @Override
    public Set<OrderProductDto> getAllOrderProductsForOneUser(int idUser) throws ServiceException {
        try {
            Set<OrderProductDto> productDtoSet = new HashSet<>();
            for (var product: orderProduct.getAllOrderProductsForOneUser(idUser)) {
                productDtoSet.add(convertOrderProductToOrderProductDto(product));
            }
            return productDtoSet;
        } catch (DaoException e) {
            throw new ServiceException(OrderProductService.class.getName(), "getAllOrderProductsForOneUser", e.getMessage(), "Une erreur s'est produite lors de la récupération de tout les commandes");
        }
    }

    @Override
    public int updateOrderProduct(OrderProductDto orderProductDto) throws ServiceException {
        try {
            return orderProduct.updateOrderProduct(convertOrderProductDtoToOrderProduct(orderProductDto));
        } catch (DaoException e) {
            throw new ServiceException(OrderProductService.class.getName(), "updateOrderProduct", e.getMessage(), "Une erreur s'est produite lors de la mise à jour du produit");
        }
    }

    @Override
    public int deleteOrderProduct(int idOrderProductDto) throws ServiceException {
        try {
            return orderProduct.deleteOrderProduct(idOrderProductDto);
        } catch (DaoException e) {
            throw new ServiceException(OrderProductService.class.getName(), "deleteOrderProduct", e.getMessage(), "Une erreur s'est produite lors de la suppression du produit");
        }
    }

    @Override
    public OrderProductDto getOneOrderProduct(int idOrderProductDto) throws ServiceException {
        try {
            return convertOrderProductToOrderProductDto(orderProduct.getOneOrderProduct(idOrderProductDto));
        } catch (DaoException e) {
            throw new ServiceException(OrderProductService.class.getName(), "getOneOrderProduct", e.getMessage(), "Une erreur s'est produite lors de la récupération du produit");
        }
    }

    @Override
    public OrderProductDto convertOrderProductToOrderProductDto(OrderProduct Product) {
        return new OrderProductDto(Product.getId(), Product.getIdUser(), Product.getIdProduct(), Product.getDateCreated(), Product.getStatus());
    }

    @Override
    public OrderProduct convertOrderProductDtoToOrderProduct(OrderProductDto ProductDto) {
        return new OrderProduct(ProductDto.getId(), ProductDto.getIdUser(), ProductDto.getIdProduct(), ProductDto.getDateCreated(), ProductDto.getStatus());

    }
}
