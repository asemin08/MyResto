import eu.ensup.myresto.*;
import eu.ensup.myresto.exceptions.DaoException;
import eu.ensup.myresto.exceptions.ServiceException;
import eu.ensup.myresto.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * The type User service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static final Logger log = LogManager.getLogger(UserServiceTest.class);

    /**
     * The User dao.
     */
    @Mock
    IUserDao userDao;

    /**
     * The User service.
     */
    @InjectMocks
    UserService userService;

    /**
     * Create user test.
     */
    @Test
    public void createUserTest() {
        try {
            when(userDao.create(any(User.class))).thenReturn(1);
            int result = userService.create(new RegisterUserDto(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "ensup", "", "///"));
            MatcherAssert.assertThat(result, equalTo(1));
            verify(userDao).create(any(User.class));
        } catch (DaoException | ServiceException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Update user test.
     */
    @Test
    public void updateUserTest() {
        try {
            when(userDao.update(any(User.class))).thenReturn(1);
            int result = userService.update(new UserDto(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "///"));
            MatcherAssert.assertThat(result, equalTo(1));
            verify(userDao).update(any(User.class));
        } catch (DaoException | ServiceException e) {
            log.error(e.getMessage());
        }

    }


    /**
     * Gets by id test.
     */
    @Test
    public void getByIdTest() {
        try {
            when(userDao.getById(100)).thenReturn(new User(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "///"));
            UserDto userDto = userService.getById(100);
            MatcherAssert.assertThat(userDto.getFirstName(), equalTo("maxime"));
            verify(userDao).getById(100);
        } catch (DaoException | ServiceException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Gets by login test.
     */
    @Test
    public void getByLoginTest() {
        try {

            when(userDao.getByLogin("mdazin")).thenReturn(new User(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "///"));
            UserDto userDto = userService.getByLogin("mdazin");
            MatcherAssert.assertThat(userDto.getFirstName(), equalTo("maxime"));
            verify(userDao).getByLogin("mdazin");
        } catch (DaoException | ServiceException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Delete test.
     */
    @Test
    public void deleteTest(){
        try {
            when(userDao.delete(100)).thenReturn(1);
            MatcherAssert.assertThat(userService.delete(100),equalTo(1));
            verify(userDao).delete(100);
        } catch (DaoException | ServiceException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Validate user test.
     */
    @Test
    public void validateUserTest(){
        try {
            User user = new User(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "oNqPeGXHfDg6X3ZRO2btnLGAGMfdyENqW+y67B95cKg=", "123456", "///");
            when(userDao.getByLogin("mdazin")).thenReturn(user);
            UserDto userDto = userService.validateUser(new LoginUserDto("mdazin","ensup"));
            MatcherAssert.assertThat(userDto.getFirstName(),equalTo(user.getFirstName()));
            verify(userDao).getByLogin("mdazin");
        } catch (DaoException | ServiceException e) {
            log.error(e.getMessage());
        }
    }


}
