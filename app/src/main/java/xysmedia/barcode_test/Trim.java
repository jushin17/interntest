package xysmedia.barcode_test;

/**
 * Created by Jiung on 2016-02-08.
 */
public class Trim {

    String trim;
    int quantity;

    // constructor
    public Trim() {
    }

    public Trim(String trim, int quantity) {
        this.trim = trim;
        this.quantity = quantity;
    }

    public void setTrim(String Trim) {
        this.trim = trim;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String gettrim() {
        return this.trim;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
