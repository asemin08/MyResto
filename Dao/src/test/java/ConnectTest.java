import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ConnectTest {
    private final BaseDao baseDao = new BaseDao();

    @Test
    public void testConnection() {
        MatcherAssert.assertThat( baseDao.connexion(), equalTo(0) );
    }
}
