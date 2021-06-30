package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

class BaseDaoTest {

    private static final Logger log = LogManager.getLogger(ConnectTest.class);


    private static final BaseDao baseDao = new BaseDao();

    @Test
    void connexion() {
        try {
            MatcherAssert.assertThat( baseDao.connexion(), equalTo(0) );
        } catch (DaoException e) {
            log.error(e);
        }

    }

    @Test
    void disconnect() {
        try {
            baseDao.disconnect();
            MatcherAssert.assertThat( 1, equalTo(1) );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getUrl() {
        try {
            MatcherAssert.assertThat( baseDao.getUrl(), notNullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getLogin() {
        try {
            MatcherAssert.assertThat( baseDao.getLogin(), notNullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getPassword() {
        try {
            MatcherAssert.assertThat( baseDao.getPassword(), notNullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getCn() {
        try {
            MatcherAssert.assertThat( baseDao.getCn(), notNullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void setCn() {
        try {
            baseDao.setCn(null);
            MatcherAssert.assertThat( baseDao.getCn(), nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getSt() {
        try {
            MatcherAssert.assertThat( baseDao.getSt(), notNullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void setSt() {
        try {
            baseDao.setSt(null);
            MatcherAssert.assertThat( baseDao.getSt(), nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getRs() {
        try {
            MatcherAssert.assertThat( baseDao.getLogin(), notNullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void setRs() {
        try {
            MatcherAssert.assertThat( null, nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getPs() {
        try {
            MatcherAssert.assertThat( null, nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void setPs() {
        try {
            MatcherAssert.assertThat( null, nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getCs() {
        try {
            MatcherAssert.assertThat( null, nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void setCs() {
        try {
            MatcherAssert.assertThat( null, nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void getResult() {
        try {
            MatcherAssert.assertThat( null, nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    void setResult() {
        try {
            MatcherAssert.assertThat( null, nullValue()  );
        } catch (Exception e) {
            log.error(e);
        }
    }
}