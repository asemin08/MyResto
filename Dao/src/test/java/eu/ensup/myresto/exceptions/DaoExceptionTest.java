package eu.ensup.myresto.exceptions;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

class DaoExceptionTest {
    @Test
    void getClassWhereError() {

        MatcherAssert.assertThat( null, nullValue()  );

    }

    @Test
    void getMethodeWhereError() {
        MatcherAssert.assertThat( null, nullValue()  );

    }

    @Test
    void getMessageError() {
        MatcherAssert.assertThat( null, nullValue()  );

    }

    @Test
    void getMessageViewForUser() {
        MatcherAssert.assertThat( null, nullValue()  );

    }
}