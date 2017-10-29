package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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
                ArrayList temp = new ArrayList();
                for (int i = 0; i < number; i++) {
                    temp.add(sequence.get(i));
                }
                return temp;
            } else {
                FibonachiLogic o = new FibonachiLogic();
                o.makeDirty(number);

                System.out.println("1st Else OK");

            }
        } else {
            FibonachiLogic o = new FibonachiLogic();
            o.makeDirty(number);
            System.out.println("2nd Else OK");
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

}
