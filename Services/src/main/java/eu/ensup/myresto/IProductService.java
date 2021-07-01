package eu.ensup.myresto;

import com.google.protobuf.ServiceException;

import java.util.Set;

/**
 * The interface Product service.
 */
public interface IProductService {
    /**
     * Create product int.
     *
     * @param product the product
     * @return the int
     * @throws ServiceException the service exception
     * @throws ServiceException the service exception
     */
    int createProduct(ProductDto product) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    /**
     * Gets all products.
     *
     * @return the all products
     * @throws ServiceException the service exception
     * @throws ServiceException the service exception
     */
    Set<ProductDto> getAllProducts() throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    /**
     * Update product int.
     *
     * @param product the product
     * @return the int
     * @throws ServiceException the service exception
     * @throws ServiceException the service exception
     */
    int updateProduct(Product product) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    /**
     * Delete product int.
     *
     * @param idProduct the id product
     * @return the int
     * @throws ServiceException the service exception
     * @throws ServiceException the service exception
     */
    int deleteProduct(int idProduct) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    /**
     * Gets one product.
     *
     * @param idProduct the id product
     * @return the one product
     * @throws ServiceException the service exception
     * @throws ServiceException the service exception
     */
    ProductDto getOneProduct(int idProduct) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    /**
     * Convert product dto to product product.
     *
     * @param productDto the product dto
     * @return the product
     */
    Product convertProductDtoToProduct(ProductDto productDto);

    /**
     * Convert product to product dto product dto.
     *
     * @param product the product
     * @return the product dto
     */
    ProductDto convertProductToProductDto(Product product);
}
