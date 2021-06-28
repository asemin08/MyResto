import exceptions.DaoException;
import exceptions.ServiceException;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Base64;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    @Mock
    IUserDao userDao;

    @InjectMocks
    UserService userService;

    @Test
    public void createUserTest() {
        try {
            when(userDao.create(any(User.class))).thenReturn(1);
            int result = userService.create(new RegisterUserDto(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "ensup", "", "///"));
            MatcherAssert.assertThat(result, equalTo(1));
            verify(userDao).create(any(User.class));
        } catch (DaoException | ServiceException e) {
            //TODO LOGGER
        }
    }

    @Test
    public void updateUserTest() {
        try {
            when(userDao.update(any(User.class))).thenReturn(1);
            int result = userService.update(new UserDto(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "///"));
            MatcherAssert.assertThat(result, equalTo(1));
            verify(userDao).update(any(User.class));
        } catch (DaoException | ServiceException e) {
            //TODO LOGGER
        }

    }


    @Test
    public void getByIdTest() {
        try {
            when(userDao.getById(100)).thenReturn(new User(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "///"));
            UserDto userDto = userService.getById(100);
            MatcherAssert.assertThat(userDto.getFirstName(), equalTo("maxime"));
            verify(userDao).getById(100);
        } catch (DaoException | ServiceException e) {
            //TODO LOGGER
        }
    }

    @Test
    public void getByLoginTest() {
        try {

            when(userDao.getByLogin("mdazin")).thenReturn(new User(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "///"));
            UserDto userDto = userService.getByLogin("mdazin");
            MatcherAssert.assertThat(userDto.getFirstName(), equalTo("maxime"));
            verify(userDao).getByLogin("mdazin");
        } catch (DaoException | ServiceException e) {
            //TODO LOGGER
        }
    }

    @Test
    public void deleteTest(){
        try {
            when(userDao.delete(100)).thenReturn(1);
            MatcherAssert.assertThat(userService.delete(100),equalTo(1));
            verify(userDao).delete(100);
        } catch (DaoException | ServiceException e) {
            //TODO LOGGER
        }
    }

    @Test
    public void validateUserTest(){
        try {
            when(userDao.getByLogin("mdazin")).thenReturn(new User(100, "mdazin", "maxime", "dazin", "14 rue des boustifailles", "admin", "oNqPeGXHfDg6X3ZRO2btnLGAGMfdyENqW+y67B95cKg=", "123456", "///"));
            int result = userService.validateUser(new LoginUserDto("mdazin","ensup"));
            MatcherAssert.assertThat(result,equalTo(1));
            verify(userDao).getByLogin("mdazin");
        } catch (DaoException | ServiceException e) {
            //TODO LOGGER

        }
    }


}
