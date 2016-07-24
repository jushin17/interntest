package xysmedia.barcode_test;

/**
 * Created by Jiung on 2016-02-04.
 */
public class Item {
    String id;
    String active;
    String registered;
    String modified;
    String size;
    String pack;
    String expect_date;
    float price;
    float sale_price;


    // constructors
    public Item() {
    }

    public Item(String id, String active, String registered,
                String modified, String size, String pack, String expect_date,
                float price, float sale_price) {
        this.id = id;
        this.active = active;
        this.registered = registered;
        this.modified = modified;
        this.size = size;
        this.pack = pack;
        this.expect_date = expect_date;
        this.price = price;
        this.sale_price = sale_price;
    }

    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setActive(String active) { this.active = active; }

    public void setRegistered(String registered) { this.registered = registered; }

    public void setModified(String modified) { this.modified = modified; }

    public void setSize(String size) { this.size = size; }

    public void setPack(String pack) { this.pack = pack; }

    public void setExpect_date(String expect_date) { this.expect_date = expect_date; }

    public void setPrice(float price) { this.price = price; }

    public void setSale_price(float sale_price) { this.sale_price = sale_price; }


    // getters
    public String getId() {
        return this.id;
    }

    public String getActive() { return this.active; }

    public String getRegistered() { return this.registered; }

    public String getModified() { return this.modified; }

    public String getSize() { return this.size; }

    public String getPack() { return this.pack; }

    public String getExpect_date() { return this.expect_date; }

    public float getPrice() { return this.price; }

    public float getSale_price() { return this.sale_price; }

}
