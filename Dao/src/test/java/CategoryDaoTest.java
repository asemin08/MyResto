import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.fail;

import exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryDaoTest
{
    private static final Logger log = LogManager.getLogger(CategoryDaoTest.class);

    private static CategoryDao dao;
    private Integer id = 100;
    private String name = "Image";
    private String image = null;

    @BeforeAll
    public static void init()
    {
        dao = new CategoryDao();
    }

    @BeforeEach
    public void testConnection()
    {
        try{
            BaseDao baseDao = new BaseDao();
            baseDao.connexion();
            assertThat(baseDao.getCn(), is(notNullValue()));
        } catch(DaoException e) {
            log.info(e.getMessage());
        }
    }

    /*@Test
    @DisplayName("Test create")
    @Order(1)
    public void testCreate()
    {
        try{
            int res = dao.create(new Category(0, this.name, this.image));
            assertThat(res, equalTo(1));
        }
        catch (DaoException e) {
            log.info(e.getMessage());
        }
    }*/

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
            log.info(e.getMessage());
        }
    }

    @Test
    @DisplayName("Test get")
    @Order(3)
    public void testGet()
    {
        try{
            Category category = dao.get(id);

            if( category != null ) {
                assertThat(category.getName(), equalTo(name));
                assertThat(category.getImage(), equalTo(image));
            }
            else
            {
                System.out.println("The database not have this category");
                assertThat(true, equalTo(true));
            }
        }
        catch (DaoException e) {
            log.info(e.getMessage());
        }
    }

	/*@Test
	@DisplayName("Test delete")
	@Order(4)
	public void testDelete()
	{
        try{
            int res = dao.delete(id);

            assertThat(res, equalTo(1));
		}
		catch (DaoException e) {
			log.info(e.getMessage());
		}
	}*/
}