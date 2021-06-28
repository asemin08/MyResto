import eu.ensup.myresto.domaine.Product;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    IProductDao productDao;

    @InjectMocks
    ProductService productService;

    @Test
    public void CreateProductTest(){
        try{
            Product product = new Product("CocaService", 3.5f, "", "C'est du coca");
            var res = productService.createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
            when(res).thenReturn(1);
            MatcherAssert.assertThat(res, equalTo(1));
            verify(productDao).createProduct(new Product("CocaService", 3.5f, "", "C'est du coca"));
        }catch (Exception e ){

        }
    }
}
