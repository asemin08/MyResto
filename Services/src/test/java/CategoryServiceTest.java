import exceptions.DaoException;
import exceptions.ServiceException;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest
{
    @Mock
    ICategoryDao categoryDao;

    @InjectMocks
    CategoryService categoryService;

    @Test
    public void getAllTest()
    {
        List<CategoryDto> listCategory = new ArrayList<CategoryDto>();
        listCategory.add(new CategoryDto(1, "Entrée", null));
        listCategory.add(new CategoryDto(2, "Plat", null));
        listCategory.add(new CategoryDto(3, "Dessert", null));

        try{
            when(categoryDao.getAll().size()).thenReturn(3);
            MatcherAssert.assertThat(categoryService.getAll().size(), equalTo(3));
            verify(categoryDao).getAll();
        }
        catch (ServiceException | DaoException e) {
            fail(e.getMessage());
        }
    }
}
