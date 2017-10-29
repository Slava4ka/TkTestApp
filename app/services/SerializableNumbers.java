package services;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author v.osepyan
 */
public class SerializableNumbers implements Serializable{

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // переменная со значением n (длина)
    private int size = 0;

    // коллекция с числами до n
    private ArrayList <BigInteger> mass = new ArrayList();

    public ArrayList<BigInteger> getMass() {
        return mass;
    }

    public void setMass(ArrayList<BigInteger> mass) {
        this.mass = mass;
    }
}
