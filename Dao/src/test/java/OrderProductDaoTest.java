import eu.ensup.myresto.OrderProduct;
import eu.ensup.myresto.OrderProductDao;
import eu.ensup.myresto.exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class OrderProductDaoTest {

    private OrderProductDao orderProductDao = new OrderProductDao();

    @Test
    void createOrderProductTest() {
        try {
            List<Integer> tabIdsProducts = new ArrayList<>();
            tabIdsProducts.add(2);
            tabIdsProducts.add(3);
            tabIdsProducts.add(4);
//            tabIdsProducts.add(1);
            var result = orderProductDao.createOrderProduct(new OrderProduct(2, tabIdsProducts, OrderProduct.Status.NEW.toString(), null));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            //TODO
        }
    }

    @Test
    void getAllOrderProductsForOneUserTest() {
        try {
            var result = orderProductDao.getAllOrderProductsForOneUser(100);
            MatcherAssert.assertThat(result.size(), equalTo(1));

        } catch (DaoException e) {
            //TODO
        }
    }

    @Test
    void deleteOrderProductTest() {
        try {
           var result =  orderProductDao.deleteOrderProduct(49);
            MatcherAssert.assertThat(result, equalTo(0));
        } catch (DaoException e) {
            //TODO
        }
    }

    @Test
    void getOneOrderProductTest() {
        try {
            var result = orderProductDao.getOneOrderProduct(91);
            MatcherAssert.assertThat(result, notNullValue());
        } catch (DaoException e) {
            //TODO
        }
    }

//    @Test
//    void updateOrderProductTest() {
//    }


}