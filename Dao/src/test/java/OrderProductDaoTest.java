import eu.ensup.myresto.OrderProduct;
import eu.ensup.myresto.OrderProductDao;
import eu.ensup.myresto.exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

class OrderProductDaoTest {

    private OrderProductDao orderProductDao = new OrderProductDao();

    @Test
    void createOrderProductTest() {
        try {
            List<Integer> tabIdsProducts = new ArrayList<>();
            tabIdsProducts.add(1);
            tabIdsProducts.add(1);
//            tabIdsProducts.add(1);
            var result = orderProductDao.createOrderProduct(new OrderProduct(100, tabIdsProducts, OrderProduct.Status.NEW.toString(), null));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            //TODO
        }
    }

    @Test
    void getAllOrderProductsForOneUserTest() {
        try {
            var result = orderProductDao.getAllOrderProductsForOneUser(100);
            for (var res : result) {
                System.out.println(res);
            }
        } catch (DaoException e) {
            //TODO
        }
    }

    @Test
    void deleteOrderProductTest() {
        try {
            orderProductDao.deleteOrderProduct(49);
        } catch (DaoException e) {
            //TODO
        }
    }

    @Test
    void getOneOrderProductTest() {
        try {
            var result = orderProductDao.getOneOrderProduct(91);
            System.out.println(result);
        } catch (DaoException e) {
            //TODO
        }
    }

    @Test
    void updateOrderProductTest() {
    }


}