import com.google.protobuf.ServiceException;

import java.util.Set;

public interface IProductService {
    int createProduct(ProductDto product) throws ServiceException, exceptions.ServiceException;

    Set<ProductDto> getAllProducts() throws ServiceException, exceptions.ServiceException;

    int updateProduct(Product product) throws ServiceException, exceptions.ServiceException;

    int deleteProduct(int idProduct) throws ServiceException, exceptions.ServiceException;

    ProductDto getOneProduct(int idProduct) throws ServiceException, exceptions.ServiceException;

    Product convertProductDtoToProduct(ProductDto ProductDto);

    ProductDto convertProductToProductDto(Product Product);
}
