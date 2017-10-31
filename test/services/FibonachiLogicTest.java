package services;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author v.osepyan
 */
public class FibonachiLogicTest {
    InterfaceLogic interfaceLogic = new FibonachiLogic();

    @Test
    public void makeFibonachiSequence() throws Exception {
        ArrayList arrayList = interfaceLogic.makeFibonachiSequence(5);
        int extend = 5;
        int actual = arrayList.size();
        assertEquals(extend,actual);

        arrayList = interfaceLogic.makeFibonachiSequence(33);
        extend = 33;
        actual = arrayList.size();
        assertEquals(extend,actual);

        arrayList = interfaceLogic.makeFibonachiSequence(13);
        extend = 144;
        BigInteger bigInteger = (BigInteger) arrayList.get(12);
        actual = bigInteger.intValue();
        assertEquals(extend,actual);


        arrayList = interfaceLogic.makeFibonachiSequence(10);
        extend = 55;
        BigInteger bigInteger1 = (BigInteger) arrayList.get(9);
        actual = bigInteger1.intValue();
        assertEquals(extend,actual);
    }
}