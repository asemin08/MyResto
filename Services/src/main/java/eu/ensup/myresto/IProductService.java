package eu.ensup.myresto;

import com.google.protobuf.ServiceException;
import eu.ensup.myresto.Product;
import eu.ensup.myresto.ProductDto;

import java.util.Set;

public interface IProductService {
    int createProduct(ProductDto product) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    Set<ProductDto> getAllProducts() throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    int updateProduct(Product product) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    int deleteProduct(int idProduct) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    ProductDto getOneProduct(int idProduct) throws ServiceException, eu.ensup.myresto.exceptions.ServiceException;

    Product convertProductDtoToProduct(ProductDto ProductDto);

    ProductDto convertProductToProductDto(Product Product);
}
