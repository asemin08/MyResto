import eu.ensup.myresto.domaine.Product;
import exceptions.DaoException;

import java.util.Set;

public interface IProductDao {
    int createProduct(Product product) throws DaoException;
    Set<Product> getAllProducts() throws DaoException;
    int updateProduct(Product product) throws DaoException;
    int deleteProduct(int idProduct) throws DaoException;
    Product getOneProduct(int idProduct) throws DaoException;

}
