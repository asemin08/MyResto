import exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;


class ConnectTest  {

    private BaseDao baseDao = new BaseDao();


    @Test
     void testConnection() {
        try {
            MatcherAssert.assertThat( baseDao.connexion(), equalTo(0) );
        } catch (DaoException e) {
           //TODO
        }
    }
}
