import eu.ensup.myresto.BaseDao;
import eu.ensup.myresto.exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.Matchers.equalTo;


class ConnectTest  {

    private static final Logger log = LogManager.getLogger(ConnectTest.class);


    private BaseDao baseDao = new BaseDao();


    @Test
     void testConnection() {
        MatcherAssert.assertThat( baseDao.connexion(), equalTo(0) );
    }
}
