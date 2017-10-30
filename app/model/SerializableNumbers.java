package model;

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

    private int size = 0;

    private ArrayList <BigInteger> mass = new ArrayList();

    public ArrayList<BigInteger> getMass() {
        return mass;
    }

    public void setMass(ArrayList<BigInteger> mass) {
        this.mass = mass;
    }
}
