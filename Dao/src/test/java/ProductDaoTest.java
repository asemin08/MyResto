import exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ProductDaoTest {

    private ProductDao productDao = new ProductDao();

    @Test
    @Order(1)
    public void ProductCreateTest() {
        try {
            var result = productDao.createProduct(new Product("Coca", 3.5f, "", "C'est du coca",0));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    @Order(5)
    public void ProductgetAllTest() {
        try {
            var result = productDao.getAllProducts();
            MatcherAssert.assertThat(result.size(), equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    @Order(2)
    public void ProductDeleteTest() {
        try {
            var result = productDao.deleteProduct(1);
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    @Order(3)
    public void ProductGetOneTest() {
        Product result;
        try {
            result = productDao.getOneProduct(1);
            MatcherAssert.assertThat(result.getId(), equalTo(1));
            MatcherAssert.assertThat(result.getName(), equalTo("Coca"));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    @Order(4)
    public void ProductUpdateTest() {
        try {
            int result = productDao.updateProduct(new Product(1, "Coca", 3.5f, "", "C'est du coca haha",0));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }
}
