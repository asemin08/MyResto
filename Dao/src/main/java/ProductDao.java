import exceptions.DaoException;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ProductDao extends BaseDao implements IProductDao {

    @Override
    public int createProduct(Product product) throws DaoException {
        try {
            connexion();
            String sql = "INSERT INTO `product`(name,price, description,image) VALUES (?,?,?,?)";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setString(1,product.getName());
            BaseDao.getPs().setFloat(2,product.getPrice());
            BaseDao.getPs().setString(3,product.getDescription() );
            BaseDao.getPs().setString(4, product.getPicture());
            BaseDao.setResult(BaseDao.getPs().executeUpdate());
        }catch (SQLException e) {
            throw new DaoException(ProductDao.class.getName(),"createProduct",e.getMessage(),"Une erreur s'est produite lors de la récupération du produit");
        }
        return BaseDao.getResult();
    }

    @Override
    public Set<Product> getAllProducts() throws DaoException {
        Set<Product> products = new HashSet<>();
        try {
            connexion();
            String sql = "SELECT * FROM `product`";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            while (BaseDao.getRs().next()) {
                products.add(new Product(BaseDao.getRs().getInt("id"),BaseDao.getRs().getString("name"),BaseDao.getRs().getFloat("price"),BaseDao.getRs().getString("description"),BaseDao.getRs().getString("image")));
            }
        } catch (SQLException e) {
            throw new DaoException(ProductDao.class.getName(),"getAllProducts",e.getMessage(),"Une erreur s'est produite lors de la récupération de tout les produits");
        }
        return products;
    }

    @Override
    public int updateProduct(Product product) throws DaoException {
        try {
            connexion();
            String sql = "UPDATE `product` SET `name`= ?,`price`= ?,`description`= ?,`image`= ? WHERE `id`= ?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setString(1, product.getName());
            BaseDao.getPs().setFloat(2, product.getPrice());
            BaseDao.getPs().setString(3, product.getDescription());
            BaseDao.getPs().setString(4, product.getPicture());
            BaseDao.getPs().setInt(5, product.getId());
            BaseDao.setResult(BaseDao.getPs().executeUpdate());
            disconnect();

        } catch (SQLException e) {
            throw new DaoException(ProductDao.class.getName(),"updateProduct",e.getMessage(),"Une erreur s'est produite lors de la mise à jour du produit");
        }
        return BaseDao.getResult();
    }

    @Override
    public int deleteProduct(int idProduct) throws DaoException {
        try {
            connexion();
            String sql = "DELETE FROM `product` WHERE id=?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1,idProduct);
            BaseDao.setResult(BaseDao.getPs().executeUpdate());
        } catch (SQLException | DaoException e) {
            throw new DaoException(ProductDao.class.getName(),"deleteProduct",e.getMessage(),"Une erreur s'est produite lors de la suppression du produit");
        }
        return BaseDao.getResult();
    }

    @Override
    public Product getOneProduct(int idProduct) throws DaoException{
        try {
            connexion();
            String sql = "SELECT * FROM `product` WHERE id=?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1,idProduct);
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            while (getRs().next()) {
                return new Product(BaseDao.getRs().getInt("id"),BaseDao.getRs().getString("name"),BaseDao.getRs().getFloat("price"),BaseDao.getRs().getString("description"),BaseDao.getRs().getString("image"));
            }
        } catch (SQLException | DaoException e) {
            throw new DaoException(ProductDao.class.getName(),"getOneProduct",e.getMessage(),"Une erreur s'est produite lors de la récuperation du produit");
        }
        return null;

}
