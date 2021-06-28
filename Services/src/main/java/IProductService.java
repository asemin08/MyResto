import com.google.protobuf.ServiceException;
import eu.ensup.myresto.domaine.Product;

import java.util.Set;

public interface IProductService {
    int createProduct(Product product) throws ServiceException, exceptions.ServiceException;
    Set<Product> getAllProducts() throws ServiceException, exceptions.ServiceException;
    int updateProduct(Product product) throws ServiceException, exceptions.ServiceException;
    int deleteProduct(int idProduct) throws ServiceException, exceptions.ServiceException;
    Product getOneProduct(int idProduct) throws ServiceException, exceptions.ServiceException;
}
