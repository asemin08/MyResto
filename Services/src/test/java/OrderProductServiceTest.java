import eu.ensup.myresto.IOrderProductDao;
import eu.ensup.myresto.OrderProduct;
import eu.ensup.myresto.OrderProductDto;
import eu.ensup.myresto.OrderProductService;
import eu.ensup.myresto.exceptions.DaoException;
import eu.ensup.myresto.exceptions.ServiceException;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderProductServiceTest {

    @Mock
    IOrderProductDao OrderproductDao;

    @InjectMocks
    OrderProductService OrderproductService;

    @Test
    public void createOrderProductTest() {
        try {
            List<Integer> tabIdsProducts = new ArrayList<>();
            tabIdsProducts.add(1);
            tabIdsProducts.add(1);

            OrderProductDto productDto = new OrderProductDto(1, 100, tabIdsProducts, null, OrderProduct.Status.NEW.toString());
            when(OrderproductDao.createOrderProduct(any(OrderProduct.class))).thenReturn(0);
            MatcherAssert.assertThat(OrderproductService.createOrderProduct(productDto), equalTo(0));
            verify(OrderproductDao).createOrderProduct(any(OrderProduct.class));
        } catch (ServiceException | DaoException e) {
            //TODO
        }
    }

    @Test
    public void getAllOrderProductsForOneUser() {
        try {
            Set<OrderProduct> products = new HashSet<>();
            for (int i = 0; i < 3; i++)
                products.add(new OrderProduct(1, 100, null, null, OrderProduct.Status.NEW.toString()));

            when(OrderproductDao.getAllOrderProductsForOneUser(100)).thenReturn(products);
            MatcherAssert.assertThat(OrderproductService.getAllOrderProductsForOneUser(100).size(), equalTo(3));
            verify(OrderproductDao).getAllOrderProductsForOneUser(100);

        } catch (DaoException | ServiceException e) {
            //TODO
        }
    }

    @Test
    public void updateOrderProduct() {
    }

    @Test
    public void deleteOrderProduct() {
        try {
            when(OrderproductDao.deleteOrderProduct(1)).thenReturn(1);
            MatcherAssert.assertThat(OrderproductService.deleteOrderProduct(1), equalTo(1));
            verify(OrderproductDao).deleteOrderProduct(1);
        } catch (ServiceException | DaoException e) {
            //TODO
        }
    }

    @Test
    public void getOneOrderProduct() {
        try {
            var orderNotMock = new OrderProduct(1, 100, null, null, OrderProduct.Status.NEW.toString());
            when(OrderproductDao.getOneOrderProduct(1)).thenReturn(orderNotMock);
            var orderMock = OrderproductService.getOneOrderProduct(1);
            MatcherAssert.assertThat(orderNotMock.getId(), equalTo(orderMock.getId()));
            verify(OrderproductDao).getOneOrderProduct(1);
        } catch (ServiceException | DaoException e) {
            //TODO
        }
    }
}