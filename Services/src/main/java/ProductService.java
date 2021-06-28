import eu.ensup.myresto.domaine.Product;
import exceptions.DaoException;
import exceptions.ServiceException;
import exceptions.ServiceException;

import java.util.Set;

public class ProductService implements IProductService{

    private final IProductDao productDao = new ProductDao();

    @Override
    public int createProduct(Product product) throws ServiceException {
        try {
            return productDao.createProduct(product);
        } catch (DaoException e) {
            throw new ServiceException(ProductDao.class.getName(), "createProduct", e.getMessage(), "Une erreur s'est produite lors de la récupération du produit");
        }
    }

    @Override
    public Set<Product> getAllProducts() throws ServiceException {
        try {
            return productDao.getAllProducts();
        } catch (DaoException e) {
            throw new ServiceException(ProductDao.class.getName(), "getAllProducts", e.getMessage(), "Une erreur s'est produite lors de la récupération de tout les produits");
        }
    }

    @Override
    public int updateProduct(Product product) throws ServiceException {
        try {
            return productDao.updateProduct(product);
        } catch (DaoException e) {
            throw new ServiceException(ProductDao.class.getName(), "updateProduct", e.getMessage(), "Une erreur s'est produite lors de la mise à jour du produit");
        }
    }

    @Override
    public int deleteProduct(int idProduct) throws ServiceException {
        try {
            return productDao.deleteProduct(idProduct);
        } catch (DaoException e) {
            throw new ServiceException(ProductDao.class.getName(), "deleteProduct", e.getMessage(), "Une erreur s'est produite lors de la suppression du produit");
        }
    }

    @Override
    public Product getOneProduct(int idProduct) throws ServiceException {
        try {
            return productDao.getOneProduct(idProduct);
        } catch (DaoException e) {
            throw new ServiceException(ProductDao.class.getName(), "getOneProduct", e.getMessage(), "Une erreur s'est produite lors de la récupération du produit");
        }
    }
}
