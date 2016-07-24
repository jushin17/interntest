package xysmedia.barcode_test;

/**
 * Created by Jiung on 2016-02-04.
 */
public class ItemForOrder {
    String id;
    float promotion;
    String size;
    String pack;
    float price;
    int pack_qty;
    String color;
    float amount;
    int qty_1;
    int qty_2;
    int qty_3;
    int qty_4;


    // constructors
    public ItemForOrder() {
    }

    public ItemForOrder(String id, float promotion, String size,
                        String pack, float price, int pack_qty,
                        String color, float amount, int qty_1,
                        int qty_2, int qty_3, int qty_4) {
        this.id = id;
        this.promotion = promotion;
        this.size = size;
        this.pack = pack;
        this.price = price;
        this.pack_qty = pack_qty;
        this.color = color;
        this.amount = amount;
        this.qty_1 = qty_1;
        this.qty_2 = qty_2;
        this.qty_3 = qty_3;
        this.qty_4 = qty_4;
    }

    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setPromotion(float promotion) { this.promotion = promotion; }

    public void setSize(String size) { this.size = size; }

    public void setPack(String pack) { this.pack = pack; }

    public void setPrice(float price) { this.price = price; }

    public void setPack_qty(int pack_qty) { this.pack_qty = pack_qty; }

    public void setColor(String color) { this.color = color; }

    public void setAmount(float amount) { this.amount = amount; }

    public void setQty_1(int qty_1) { this.qty_1 = qty_1; }

    public void setQty_2(int qty_2) { this.qty_2 = qty_2; }

    public void setQty_3(int qty_3) { this.qty_2 = qty_3; }

    public void setQty_4(int qty_4) { this.qty_2 = qty_4; }

    // getters
    public String getId() {
        return this.id;
    }

    public float getPromotion() { return this.promotion; }

    public String getSize() { return this.size; }

    public String getPack() { return this.pack; }

    public float getPrice() { return this.price; }

    public int getPack_qty() { return this.pack_qty; }

    public String getColor() { return this.color; }

    public float getAmount() { return this.amount; }

    public int getQty_1() { return this.qty_1; }

    public int getQty_2() { return this.qty_2; }

    public int getQty_3() { return this.qty_3; }

    public int getQty_4() { return this.qty_4; }


}
