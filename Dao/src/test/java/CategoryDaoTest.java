import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.fail;

import exceptions.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryDaoTest
{
    private static CategoryDao dao = new CategoryDao();
    private Integer id = null;
    private String name = "Image";
    private String image = null;


    @Test
    @DisplayName("Test create")
    @Order(1)
    public void testCreate()
    {
        try{
            int nbCategoryBeforeCreate = dao.getAll().size();

            dao.create(new Category(this.name, this.image));

            assertThat(dao.getAll().size(), equalTo(nbCategoryBeforeCreate+1));

            this.id = dao.get(nbCategoryBeforeCreate).getId();
        }
        catch (DaoException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @DisplayName("Test getAll")
    @Order(2)
    public void testGetAll()
    {
        try{
            List<Category> listCategory = dao.getAll();

            assertThat(listCategory, notNullValue());
        }
        catch (DaoException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @DisplayName("Test get")
    @Order(2)
    public void testGet()
    {
        try{
            Category category = dao.get(id);
            assertThat(category.getName(), equalTo(name));
            assertThat(category.getImage(), equalTo(image));
        }
        catch (DaoException e) {
            fail(e.getMessage());
        }
    }

	@Test
	@DisplayName("Test delete")
	@Order(4)
	public void testDelete()
	{
        try{
            int nbCategoryBeforeDelete = dao.getAll().size();

            dao.delete(id);

            assertThat(dao.getAll().size(), equalTo(nbCategoryBeforeDelete));
		}
		catch (DaoException e) {
			fail(e.getMessage());
		}
	}
}
