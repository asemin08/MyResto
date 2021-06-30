package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

 class UserDaoTest {

    private final UserDao userDao = new UserDao();
    private static final Logger log = LogManager.getLogger(UserDaoTest.class);

    @Test
    @Order(1)
    void createUser() {
        User user = new User(0, "mdazin", "maxime", "Dazin", "14 rue des boustiffailes 45000 Orléans", "client", "abcd", "12345", "c://");
        try {
            int result = userDao.create(user);
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            fail();
            log.error(e.getMessage());
        }

    }


    @Test
    @Order(2)
    void updateUser() {
        //TODO Implémentation de la récupération automatique de l'id créé
        User user = new User(100, "mdazin", "maxime", "Dazin", "NON RENSEIGNÉ", "client", "abcd", "12345", "c://");
        try {
            int result = userDao.update(user);
            MatcherAssert.assertThat(result, equalTo(1));
        } catch (DaoException e) {
            fail();
            log.error(e.getMessage());
        }
    }

    @Test
    @Order(3)
    void getUserById() {
        try {
            User user = userDao.getById(100);
            MatcherAssert.assertThat(user.getLastName(), equalTo("Dazin"));

        } catch (DaoException e) {
            fail();
            log.error(e.getMessage());

        }
    }

    @Test
    @Order(4)
    void getUserByLogin() {
        try {
            User user = userDao.getByLogin("d");
            MatcherAssert.assertThat(user.getLastName(), equalTo("test"));
        } catch (DaoException e) {
            fail();
            log.error(e.getMessage());
        }
    }


    @Test
    @Order(5)
    void deleteUser() {
        try {
            int result = userDao.delete(100);
            MatcherAssert.assertThat(result, equalTo(1));

        } catch (DaoException e) {
            fail();
            log.error(e.getMessage());
        }
    }


}
