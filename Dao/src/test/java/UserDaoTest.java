import eu.ensup.myresto.domaine.User;
import exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserDaoTest {

    private final UserDao userDao = new UserDao();

    @Test
    @Order(1)
    void createUserTest() {
        User user = new User(0, "maxime", "Dazin", "14 rue des boustiffailes 45000 Orléans", "client", "abcd", "12345", "c://");
        try {
            int result = userDao.create(user);
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            //TODO exception
        }

    }


    @Test
    @Order(2)
    void updateUserTest() {
        //TODO Implémentation de la récupération automatique de l'id créé
        User user = new User(103, "maxime", "Dazin", "NON RENSEIGNÉ", "client", "abcd", "12345", "c://");
        try {
            int result = userDao.update(user);
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            //TODO exception
        }
    }

    @Test
    @Order(3)
    void getUserByIdTest() {
        try {
            User user = userDao.getById(103);
            MatcherAssert.assertThat(user.getLastName(), equalTo("Dazin"));

        } catch (DaoException e) {
            //TODO exception

        }
    }


    @Test
    @Order(4)
    void deleteUserTest() {
        try {
            int result = userDao.delete(103);
            MatcherAssert.assertThat(result, equalTo(1));

        } catch (DaoException e) {
            //TODO exception
        }
    }


}
