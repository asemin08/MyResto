import exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ProductTests {

    private ProductDao productDao = new ProductDao();

    @Test
    public void ProductCreateTest() {
        try {
            var result = productDao.createProduct(new Product("Coca", 3.5f, "", "C'est du coca"));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    public void ProductgetAllTest() {
        try {
            var result = productDao.getAllProducts();
            MatcherAssert.assertThat(result.size(), equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    public void ProductDeleteTest() {
        try {
            var result = productDao.deleteProduct(102);
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    public void ProductGetOneTest() {
        Product result;
        try {
            result = productDao.getOneProduct(100);
            MatcherAssert.assertThat(result.getId(), equalTo(100));
            MatcherAssert.assertThat(result.getName(), equalTo("Coca"));
        } catch (DaoException e) {
           //TODO
        }
    }

    @Test
    public void ProductUpdateTest() {
        try {
            int result = productDao.updateProduct(new Product(100, "Coca", 3.5f, "", "C'est du coca haha"));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
           //TODO
        }
    }
}
