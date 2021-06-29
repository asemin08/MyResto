package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class OrderProductDao extends BaseDao implements IOrderProductDao {

    @Override
    public int createOrderProduct(OrderProduct orderProduct) throws DaoException {
        try {
            connexion();
            var idOrder = new Random().nextInt(100000);
            String sql = "INSERT INTO `order_product`(`id`, `idUser`, `date`, `status`) VALUES (?,?,?,?)";
            setPs(getCn().prepareStatement(sql));
            getPs().setLong(1, idOrder);
            getPs().setInt(2,orderProduct.getIdUser());
            getPs().setDate(3, new Date(2021,1,12));
            getPs().setString(4,orderProduct.getStatus());
            setResult(getPs().executeUpdate());
            
            for (var idProducts:orderProduct.getIdProduct()) {
                String sqlListproducts = "INSERT INTO `listproducts`(`id_product`, `id_order`) VALUES (?,?)";
                setPs(getCn().prepareStatement(sqlListproducts));
                getPs().setInt(1, idProducts);
                getPs().setInt(2,idOrder);
                setResult(getPs().executeUpdate());
            }
            setResult(getPs().executeUpdate());
        } catch (SQLException e) {
            throw new DaoException(OrderProductDao.class.getName(), "createOrderProduct", e.getMessage(), "Une erreur s'est produite lors de la création de la commande");
        }
        return getResult();
    }

    @Override
    public Set<OrderProduct> getAllOrderProductsForOneUser(int idUser) throws DaoException {
        Set<OrderProduct> OrderProducts = new HashSet<>();
        try {
            connexion();
            String sql = "SELECT * FROM `order_product` where idUser = ?";
            setPs(getCn().prepareStatement(sql));
            getPs().setInt(1, idUser);
            setRs(getPs().executeQuery());
            var result = getRs();
            while (result.next()) {
                List<Integer> tabIdsProducts = new ArrayList<>();
                String sql2 = "SELECT * FROM `listproducts` where id_order = ?";
                setPs(getCn().prepareStatement(sql2));
                getPs().setInt(1, result.getInt("id"));
                setRs(getPs().executeQuery());
                while (getRs().next()) {
                    tabIdsProducts.add(getRs().getInt("id_product"));
                }
               OrderProducts.add(new OrderProduct(result.getInt("id"), result.getInt("idUser") ,tabIdsProducts,result.getDate("date"), result.getString("status")));
            }
        } catch (SQLException e) {
            throw new DaoException(OrderProductDao.class.getName(), "getAllOrderProducts", e.getMessage(), "Une erreur s'est produite lors de la récupération de tout les commande");
        }
        return OrderProducts;
    }

    @Override
    public int updateOrderProduct(OrderProduct orderProduct) throws DaoException {
        try {
            connexion();
            String sql = "UPDATE `order_product` SET `idUser`=?,`idProduct`=?,`date`=?,`status`=?, WHERE `id`= ?";
            setPs(getCn().prepareStatement(sql));
            getPs().setInt(1, orderProduct.getIdUser());
//            getPs().setArray(2, getCn().createArrayOf("integer", orderProduct.getIdProduct()));
            getPs().setDate(3, orderProduct.getDateCreated());
            getPs().setString(4, orderProduct.getStatus());
            getPs().setInt(5, orderProduct.getId());
            setResult(getPs().executeUpdate());
            disconnect();
        } catch (SQLException e) {
            throw new DaoException(OrderProductDao.class.getName(), "updateOrderProduct", e.getMessage(), "Une erreur s'est produite lors de la mise à jour de la commande");
        }
        return getResult();
    }

    @Override
    public int deleteOrderProduct(int idOrderProduct) throws DaoException {
        try {
            connexion();
            String sql = "DELETE FROM `order_product` WHERE `id`=? ";
            setPs(getCn().prepareStatement(sql));
            getPs().setInt(1, idOrderProduct);
            setResult(getPs().executeUpdate());
        } catch (SQLException e) {
            throw new DaoException(OrderProductDao.class.getName(), "deleteOrderProduct", e.getMessage(), "Une erreur s'est produite lors de la suppression de la commande");
        }
        return getResult();
    }

    @Override
    public OrderProduct getOneOrderProduct(int idOrderProduct) throws DaoException {
        try {
            connexion();
            String sql = "SELECT * FROM `order_product` where id = ?";
            setPs(getCn().prepareStatement(sql));
            getPs().setInt(1, idOrderProduct);
            setRs(getPs().executeQuery());
            var result = getRs();
            while (result.next()) {
                List<Integer> tabIdsProducts = new ArrayList<>();
                String sql2 = "SELECT * FROM `listproducts` where id_order = ?";
                setPs(getCn().prepareStatement(sql2));
                getPs().setInt(1, idOrderProduct);
                setRs(getPs().executeQuery());
                while (getRs().next()) {
                    tabIdsProducts.add(getRs().getInt("id_product"));
                }
                return new OrderProduct(result.getInt("id"), result.getInt("idUser") ,tabIdsProducts,result.getDate("date"), result.getString("status"));
            }
        } catch (SQLException e) {
            throw new DaoException(OrderProductDao.class.getName(), "getAllOrderProducts", e.getMessage(), "Une erreur s'est produite lors de la récupération de tout les commande");
        }
        return null;
    }
}