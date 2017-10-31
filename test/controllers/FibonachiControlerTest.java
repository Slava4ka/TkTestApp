package controllers;

import org.junit.Test;
import play.mvc.Result;
import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.route;
import static play.test.Helpers.running;

/**
 * @author v.osepyan
 */
public class FibonachiControlerTest {

    @Test
    public void testIt200() {
        running(fakeApplication(), () -> { // runnable
            Result result = route(routes.FibonachiControler.count(4));
            assertEquals(200, result.status());
        });
    }
}
