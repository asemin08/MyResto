import exceptions.DaoException;
import exceptions.ServiceException;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    IProductDao productDao;

    @InjectMocks
    ProductService productService;

    @Test
    public void ProductCreateTest(){
        try{
            Product product = new Product("CocaService", 3.5f, "", "C'est du coca");
            when(productDao.createProduct(product)).thenReturn(1);
            MatcherAssert.assertThat(productService.createProduct(product), equalTo(1));
            verify(productDao).createProduct(product);
        } catch (DaoException | ServiceException e) {
            //TODO
        }
    }
    @Test
    public void ProductgetAllTest(){
        try{
            var res = productService.getAllProducts();
//            when(res).thenReturn(new HashSet<Product>(new Product("CocaService", 3.5f, "", "C'est du coca")));
            MatcherAssert.assertThat(res, equalTo(1));
            verify(productDao).createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));

        } catch (ServiceException | DaoException e) {
            //TODO
        }
    }
//    @Test
//    public void ProductDeleteTest(){
//
//        try{
//            Product product = new Product("CocaService", 3.5f, "", "C'est du coca");
//            var res = productService.createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
//            when(res).thenReturn(1);
//            MatcherAssert.assertThat(res, equalTo(1));
//            verify(productDao).createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
//        } catch (ServiceException | DaoException e) {
//            //TODO
//        }
//    }
//    @Test
//    public void ProductGetOneTest(){
//
//        try{
//            Product product = new Product("CocaService", 3.5f, "", "C'est du coca");
//            var res = productService.createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
//            when(res).thenReturn(1);
//            MatcherAssert.assertThat(res, equalTo(1));
//            verify(productDao).createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
//        } catch (ServiceException | DaoException e) {
//            //TODO
//        }
//    }
//    @Test
//    public void ProductUpdateTest(){
//
//        try{
//            Product product = new Product("CocaService", 3.5f, "", "C'est du coca");
//            var res = productService.createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
//            when(res).thenReturn(1);
//            MatcherAssert.assertThat(res, equalTo(1));
//            verify(productDao).createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
//        } catch (ServiceException | DaoException e) {
//            //TODO
//        }
//    }

}
