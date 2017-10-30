package services;

import model.SerializableNumbers;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import play.Logger;


/**
 * @author v.osepyan
 */
public class FibonachiAction {

    private ArrayList sequence;

    public ArrayList getSequence() {
        return sequence;
    }

    public FibonachiAction(int n) {

        sequence = play(n);
    }

    private ArrayList play(int number) {

        if (new File("FibonachiSequence.txt").exists()) {
            ArrayList sequence = getMassNumbers(number);

            if (number <= sequence.size()) {
                Logger.debug("Normal size ("+number+"), sequence get from file(size "+sequence.size()+");");
                ArrayList temp = new ArrayList();
                for (int i = 0; i < number; i++) {
                    temp.add(sequence.get(i));
                }
                return temp;
            } else {
                Logger.debug("New sequence, size too big.");

                getFibonachiSequence(number);

            }
        } else {
            Logger.debug("No file, create it");

            getFibonachiSequence(number);

        }
        return play(number);
    }

    private ArrayList getMassNumbers(int n) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("FibonachiSequence.txt"));
            SerializableNumbers ppp = (SerializableNumbers) is.readObject();
            is.close();
            return ppp.getMass();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getFibonachiSequence(int number) {

        ArrayList<BigInteger> mass = new ArrayList();

        if (number > 45) {

            for (int i = 0; i <= number; i++) {
                BigInteger tempFibonachiNumber = BigInteger.valueOf(i);
                mass.add(countFibonachiSequenceInBigInteger(tempFibonachiNumber));
               Logger.info("fibonachiBigInteger N" + i + " " + mass.get(i));
            }

            SerializableNumbers serializableNumbers = new SerializableNumbers();
            serializableNumbers.setSize(mass.size());
            serializableNumbers.setMass(mass);

            serialize(serializableNumbers);

        } else {
            for (int i = 0; i <= number; i++) {
                mass.add(BigInteger.valueOf(countFibonachiSequenceInInt(i)));
                Logger.info("fibonachi N" + i + " " + mass.get(i));
            }

            SerializableNumbers serializableNumbers = new SerializableNumbers();
            serializableNumbers.setSize(mass.size());
            serializableNumbers.setMass(mass);

            serialize(serializableNumbers);
        }
    }

    protected int countFibonachiSequenceInInt(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            int x = countFibonachiSequenceInInt(n - 1) + countFibonachiSequenceInInt(n - 2);
            return x;
        }
    }

    protected BigInteger countFibonachiSequenceInBigInteger(BigInteger n) {
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
            BigInteger x1 = countFibonachiSequenceInBigInteger(n.add(minOne));
            BigInteger x2 = countFibonachiSequenceInBigInteger(n.add(minTwo));

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
