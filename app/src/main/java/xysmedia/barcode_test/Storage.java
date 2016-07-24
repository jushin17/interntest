package xysmedia.barcode_test;

/**
 * Created by Jiung on 2016-02-08.
 */
public class Storage {

    String storage;
    int quantity;

    // constructor
    public Storage() {
    }

    public Storage(String storage, int quantity) {
        this.storage = storage;
        this.quantity = quantity;
    }

    // setter
    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStorage() {
        return this.storage;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
