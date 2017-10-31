package services;

import model.SerializableNumbers;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

import play.Logger;

import javax.inject.Singleton;


/**
 * @author v.osepyan
 */
@Singleton
public class FibonachiLogic implements IntermediaryLogicService {

    private ArrayList sequence;

    @Override
    public ArrayList makeFibonachiSequence(int number) {
        sequence = play(number);
        return sequence;
    }

    private ArrayList play(int number) {

        if (new File("FibonachiSequence.txt").exists()) {
            ArrayList sequence = getMassNumbers(number);

            if (number <= sequence.size()) {
                Logger.debug("Normal size (" + number + "), sequence get from file(size " + sequence.size() + ");");
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

        long startTime = System.currentTimeMillis();
        ArrayList<BigInteger> mass = countFibonachiSequence(number);
        long timeSpent = System.currentTimeMillis() - startTime;
        Logger.info("Time of counting sequence is "+timeSpent+" ms");

            SerializableNumbers serializableNumbers = new SerializableNumbers();
            serializableNumbers.setSize(mass.size());
            serializableNumbers.setMass(mass);

            serialize(serializableNumbers);
        }


    public ArrayList countFibonachiSequence(int n) {
        ArrayList<BigInteger> sequenceFibonachi = new ArrayList<BigInteger>();

        if (n == 0) {
            return sequenceFibonachi;
        }
        BigInteger o = BigInteger.valueOf(0);
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);

        sequenceFibonachi.add(o);
        if (n == 1) {
            return sequenceFibonachi;
        }
        sequenceFibonachi.add(a);
        if (n == 2) {
            return sequenceFibonachi;
        }
        sequenceFibonachi.add(b);
        if (n == 3) {
            return sequenceFibonachi;
        }

        int i = 3;
        BigInteger fib;
        while (i < n) {
            fib = a.add(b);
            a = b;
            b = fib;
            sequenceFibonachi.add(fib);
            i++;
        }
        System.out.println();
        return sequenceFibonachi;
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
