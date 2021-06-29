import eu.ensup.myresto.*;
import eu.ensup.myresto.exceptions.DaoException;
import eu.ensup.myresto.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest
{
    private static final Logger log = LogManager.getLogger(CategoryServiceTest.class);

    @Mock
    ICategoryDao categoryDao;

    @InjectMocks
    CategoryService categoryService;

    @Test
    @DisplayName("Test get")
    public void getTest()
    {
        CategoryDto category = new CategoryDto(1, "Entrée", null);
        try{
            when(categoryDao.get(1)).thenReturn(CategoryMapper.convertDtoDomaine(category));
            MatcherAssert.assertThat(categoryService.get(1).toString(), equalTo(category.toString()));
            verify(categoryDao).get(1);
        }
        catch (DaoException | ServiceException e) {
            log.info(e.getMessage());
        }
    }

    @Test
    @DisplayName("Test create")
    public void createTest()
    {
        CategoryDto categoryDto = new CategoryDto(1, "Entrée", null);
        try{
            when(categoryDao.create(any(Category.class))).thenReturn(1);
            MatcherAssert.assertThat(categoryService.create(categoryDto), equalTo(1));
            verify(categoryDao).create(any(Category.class));
        }
        catch (ServiceException | DaoException e) {
            log.info(e.getMessage());
        }
    }

    @Test
    @DisplayName("Test update")
    public void updateTest()
    {
        CategoryDto categoryDto = new CategoryDto(1, "Entrée", "image.png");
        try{
            when(categoryDao.update(any(Category.class))).thenReturn(1);
            MatcherAssert.assertThat(categoryService.update(categoryDto), equalTo(1));
            verify(categoryDao).update(any(Category.class));
        }
        catch (ServiceException | DaoException e) {
            log.info(e.getMessage());
        }
    }

    @Test
    @DisplayName("Test delete")
    public void deleteTest()
    {
        CategoryDto categoryDto = new CategoryDto(1, "Entrée", "image.png");
        try{
            when(categoryDao.delete(any(Category.class))).thenReturn(1);
            MatcherAssert.assertThat(categoryService.delete(categoryDto), equalTo(1));
            verify(categoryDao).delete(any(Category.class));
        }
        catch (ServiceException | DaoException e) {
            log.info(e.getMessage());
        }
    }
}
