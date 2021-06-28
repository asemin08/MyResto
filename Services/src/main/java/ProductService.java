import exceptions.DaoException;
import exceptions.ServiceException;

import java.util.HashSet;
import java.util.Set;

public class ProductService implements IProductService {

    private IProductDao productDao;

    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductService() {
        this.productDao = new ProductDao();
    }

    @Override
    public int createProduct(Product product) throws ServiceException {
        try {
            return productDao.createProduct(product);
        } catch (DaoException e) {
            throw new ServiceException(ProductDao.class.getName(), "createProduct", e.getMessage(), "Une erreur s'est produite lors de la récupération du produit");
        }
    }

    @Override
    public Set<ProductDto> getAllProducts() throws ServiceException {
        try {
            Set<ProductDto> productDtoSet = new HashSet<>();
            for (var product:productDao.getAllProducts()) {
                productDtoSet.add(convertProductToProductDto(product));
            }
            return productDtoSet;
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
    public ProductDto getOneProduct(int idProduct) throws ServiceException {
        try {
            return convertProductToProductDto(productDao.getOneProduct(idProduct));
        } catch (DaoException e) {
            throw new ServiceException(ProductDao.class.getName(), "getOneProduct", e.getMessage(), "Une erreur s'est produite lors de la récupération du produit");
        }
    }

    @Override
    public ProductDto convertProductToProductDto(Product Product) {
        return new ProductDto(Product.getId(), Product.getName(), Product.getPrice(), Product.getPicture(), Product.getDescription());
    }

    @Override
    public Product convertProductDtoToProduct(ProductDto ProductDto) {
        return new Product(ProductDto.getId(), ProductDto.getName(), ProductDto.getPrice(), ProductDto.getPicture(), ProductDto.getDescription());

    }
}
