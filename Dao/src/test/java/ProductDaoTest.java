import eu.ensup.myresto.Product;
import eu.ensup.myresto.ProductDao;
import eu.ensup.myresto.exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.Matchers.equalTo;

  class ProductDaoTest {

    private ProductDao productDao = new ProductDao();
    private static final Logger log = LogManager.getLogger(ProductDaoTest.class);

    @Test
    @Order(1)
      void ProductCreateTest() {
        try {
            var result = productDao.createProduct(new Product("Coca", 3.5f, "", "C'est du coca",0));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    @Order(5)
      void ProductgetAllTest() {
        try {
            var result = productDao.getAllProducts();
            MatcherAssert.assertThat(result.size(), equalTo(1));
        } catch (DaoException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    @Order(2)
      void ProductDeleteTest() {
        try {
            var result = productDao.deleteProduct(1);
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    @Order(3)
      void ProductGetOneTest() {
        Product result;
        try {
            result = productDao.getOneProduct(1);
            MatcherAssert.assertThat(result.getId(), equalTo(1));
            MatcherAssert.assertThat(result.getName(), equalTo("Coca"));
        } catch (DaoException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    @Order(4)
      void ProductUpdateTest() {
        try {
            int result = productDao.updateProduct(new Product(1, "Coca", 3.5f, "", "C'est du coca haha",0));
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            log.error(e.getMessage());
        }
    }
}
