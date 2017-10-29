package services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author v.osepyan
 */
public class FibonachiLogic {
    public void makeDirty(int number) {

        ArrayList<BigInteger> mass = new ArrayList();

        if (number > 45) {

            for (int i = 0; i <= number; i++) {
                BigInteger ee = BigInteger.valueOf(i);
                mass.add(fibonachiBigInteger(ee));
                System.out.println("fibonachiBigInteger №" + i + " " + mass.get(i));
            }

            SerializableNumbers s = new SerializableNumbers();
            s.setSize(mass.size());
            s.setMass(mass);

            serialize(s);

        } else {
            for (int i = 0; i <= number; i++) {
                mass.add(BigInteger.valueOf(fibonachi(i)));
                System.out.println("fibonachi №" + i + " " + mass.get(i));
            }

            SerializableNumbers s = new SerializableNumbers();
            s.setSize(mass.size());
            s.setMass(mass);

            serialize(s);
        }
    }

    protected int fibonachi(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            int x = fibonachi(n - 1) + fibonachi(n - 2);
            return x;
        }
    }

    protected BigInteger fibonachiBigInteger(BigInteger n) {
        BigInteger zero = BigInteger.valueOf(0);
        BigInteger one = BigInteger.valueOf(1);

        BigInteger minOne = BigInteger.valueOf(-1);
        BigInteger minTwo = BigInteger.valueOf(-2);

        if (n.equals(zero)) {
            return zero;
        }
        if (n.equals(one)) {
            return one;
        } else {
            BigInteger x1 = fibonachiBigInteger(n.add(minOne));
            BigInteger x2 = fibonachiBigInteger(n.add(minTwo));

            BigInteger x = x1.add(x2);
            return x;

        }
    }

    protected void serialize(SerializableNumbers FibonachiSequenceArray) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("FibonachiSequence.txt"));
            os.writeObject(FibonachiSequenceArray);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
