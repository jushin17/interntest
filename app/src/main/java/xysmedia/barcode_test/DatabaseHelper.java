package xysmedia.barcode_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiung on 2016-02-04.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 14;

    // Database Name
    private static final String DATABASE_NAME = "InventoryManager";

    // Table Names
    private static final String TABLE_INVENTORY = "inventory";
    // Column Names
    private static final String KEY_ID = "id";
    private static final String BARCODE = "barcode";
    private static final String ACTIVE = "active";
    private static final String REGISTERED = "registered";
    private static final String MODIFIED = "modified";
    private static final String SIZE = "size";
    private static final String PACK = "pack";
    private static final String EXPECTED_DATE = "expected_date";
    private static final String PRICE = "price";
    private static final String SALE_PRICE = "sale_price";

    // Table create statement
    private static final String CREATE_TABLE_INVENTORY = "CREATE TABLE "
            + TABLE_INVENTORY + "(" + KEY_ID + " TEXT PRIMARY KEY, "
            + BARCODE + " INTEGER, " + ACTIVE + " TEXT, " + REGISTERED + " TEXT, "
            + MODIFIED + " TEXT, " + SIZE + " TEXT, " + PACK + " TEXT, "
            + EXPECTED_DATE + " TEXT, " + PRICE + " NUMERIC, " + SALE_PRICE + " NUMERIC );";


    // Table name of Order Product
    private static final String TABLE_ORDER_PRODUCT = "order_product_table";
    private static final String ORDER_NO = "order_no";
    private static final String STYLE_NUMBER = "style_number";
    private static final String PACK_QUANTITY = "pack_quantity";
    private static final String PROMOTION = "promotion";
    private static final String AMOUNT = "amount";
    private static final String COLOR = "color";
    private static final String QTY_1 = "qty_1";
    private static final String QTY_2 = "qty_2";
    private static final String QTY_3 = "qty_3";
    private static final String QTY_4 = "qty_4";

    private static final String CREATE_TABLE_ORDER_PRODUCT = "CREATE TABLE "
            + TABLE_ORDER_PRODUCT + "(" + "no" + " INTEGER PRIMARY KWY,"
            + ORDER_NO + " TEXT," + STYLE_NUMBER + " TEXT,"
            + PRICE + " NUMERIC," + PROMOTION + " NUMERIC," + SIZE + " TEXT,"
            + PACK + " TEXT," + PACK_QUANTITY + " INTEGER," + COLOR + " TEXT,"
            + AMOUNT + " INTEGER," + QTY_1 + " INTEGER," + QTY_2 + " INTEGER,"
            + QTY_3 + " INTEGER," + QTY_4 + " INTEGER" + ");";


    private static final String TABLE_ORDER_PAY = "order_pay_table";
    private static final String CARD_TYPE = "card_type";
    private static final String CARD_NUMBER = "card_number";
    private static final String EX_MONTH = "ex_month";
    private static final String EX_YEAR = "ex_year";
    private static final String CVN = "cvn";


    private static final String CREATE_TABLE_ORDER_PAY = "CREATE TABLE "
            + TABLE_ORDER_PAY + "(" + "no" + " INTEGER PRIMARY KET,"
            + CARD_TYPE + " TEXT," + CARD_NUMBER + " INTEGER,"
            + EX_MONTH + " INTEGER," + EX_YEAR + " INTEGER,"
            + CVN + " INTEGER" + ");";


    private static final String TABLE_ORDER_ADDRESS = "order_address_table";
    private static final String B_FNAME = "b_fname";
    private static final String B_LNAME = "b_lname";
    private static final String B_COMPANY = "b_company";
    private static final String B_ADDR = "b_addr1";
    private static final String B_ADDR2 = "b_addr2";
    private static final String B_CITY = "b_city";
    private static final String B_COUNTRY = "b_country";
    private static final String B_ZIP = "b_zip";
    private static final String B_TEL = "b_tel";
    private static final String S_FNAME = "s_fname";
    private static final String S_LNAME = "s_lname";
    private static final String S_COMPANY = "s_company";
    private static final String S_ADDR = "s_addr1";
    private static final String S_ADDR2 = "s_addr2";
    private static final String S_CITY = "s_city";
    private static final String S_COUNTRY = "s_country";
    private static final String S_ZIP = "s_zip";
    private static final String S_TEL = "s_tel";

    private static final String CREATE_TABLE_ORDER_ADDRESS = "CREATE TABLE "
            + TABLE_ORDER_ADDRESS + "(" + "no" + " INTEGER PRIMARY KEY,"
            + ORDER_NO + " TEXT," + B_FNAME + " TEXT," + B_LNAME + " TEXT,"
            + B_COMPANY + " TEXT," + B_ADDR + " TEXT," + B_ADDR2 + " TEXT,"
            + B_CITY + " TEXT," + B_COUNTRY + " TEXT," + B_ZIP + " TEXT,"
            + B_TEL + " TEXT," + S_FNAME + " TEXT," + S_LNAME + " TEXT,"
            + S_COMPANY + " TEXT," + S_ADDR + " TEXT," + S_ADDR2 + " TEXT,"
            + S_CITY + " TEXT," + S_COUNTRY + " TEXT," + S_ZIP + " TEXT,"
            + S_TEL + " TEXT," + ");";


    private static final String TABLE_CUSTOMER = "customer_table";
    private static final String FNAME = "fname";
    private static final String LNAME = "lname";
    private static final String COMPANY = "company";
    private static final String ADDR = "addr1";
    private static final String ADDR2 = "addr2";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String ZIP = "zip";
    private static final String TEL = "tel";

    private static final String CREATE_TABLE_CUSTOMER = "CREATE TABLE "
            + TABLE_CUSTOMER + "(" + "no" + " INTEGER PRIMARY KEY,"
            + FNAME + " TEXT," + LNAME + " TEXT,"
            + COMPANY + " TEXT," + ADDR + " TEXT," + ADDR2 + " TEXT,"
            + CITY + " TEXT," + COUNTRY + " TEXT," + ZIP + " TEXT,"
            + TEL + " TEXT," + ");";


    public void createCustomer(String b_fname, String b_lname, String b_company,
                               String b_addr, String b_addr2, String b_city, String b_state, String b_country,
                               String b_zip, String b_tel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FNAME, b_fname);
        values.put(LNAME, b_lname);
        values.put(COMPANY, b_company);
        values.put(ADDR, b_addr);
        values.put(ADDR2, b_addr2);
        values.put(CITY, b_city);
        values.put(COUNTRY, b_country);
        values.put(ZIP, b_zip);
        values.put(TEL, b_tel);


        db.insert(TABLE_CUSTOMER, null, values);
        Log.e("database", "insert address success");
    }


    public void createAdress(String order_no, String b_fname, String b_lname, String b_company,
                             String b_addr, String b_addr2, String b_city, String b_state, String b_country,
                             String b_zip, String b_tel, String s_fname, String s_lname, String s_company,
                             String s_addr, String s_addr2, String s_city, String s_state, String s_country,
                             String s_zip, String s_tel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_NO, order_no);
        values.put(B_FNAME, b_fname);
        values.put(B_LNAME, b_lname);
        values.put(B_COMPANY, b_company);
        values.put(B_ADDR, b_addr);
        values.put(B_ADDR2, b_addr2);
        values.put(B_CITY, b_city);
        values.put(B_COUNTRY, b_country);
        values.put(B_ZIP, b_zip);
        values.put(B_TEL, b_tel);
        values.put(S_FNAME, s_fname);
        values.put(S_LNAME, s_lname);
        values.put(S_COMPANY, s_company);
        values.put(S_ADDR, s_addr);
        values.put(S_ADDR2, s_addr2);
        values.put(S_CITY, s_city);
        values.put(S_COUNTRY, s_country);
        values.put(S_ZIP, s_zip);
        values.put(S_TEL, s_tel);


        db.insert(TABLE_ORDER_ADDRESS, null, values);
        Log.e("database", "insert address success");
    }

    public void createPay(String order_no, String card_type, String card_number,
                          String ex_month, String ex_year, String cvn) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_NO, order_no);
        values.put(CARD_TYPE, card_type);
        values.put(CARD_NUMBER, card_number);
        values.put(EX_MONTH, ex_month);
        values.put(EX_YEAR, ex_year);
        values.put(CVN, cvn);

        db.insert(TABLE_ORDER_PAY, null, values);
        Log.e("database", "insert pay success");

    }


    public void createOrderProduct(List<ItemForOrder> items, String order_no) {
        SQLiteDatabase db = this.getWritableDatabase();

        String order_no_for_server = order_no;
        for (ItemForOrder item : items) {
            ContentValues values = new ContentValues();
            values.put(ORDER_NO, order_no);
            values.put(STYLE_NUMBER, item.getId());
            values.put(PRICE, item.getPrice());
            values.put(SIZE, item.getSize());
            values.put(PACK, item.getPack());
            values.put(PACK_QUANTITY, item.getPack_qty());
            values.put(PROMOTION, item.getPack());
            values.put(COLOR, item.getColor());
            values.put(AMOUNT, item.getAmount());
            values.put(QTY_1, item.getQty_1());
            values.put(QTY_2, item.getQty_2());
            values.put(QTY_3, item.getQty_3());
            values.put(QTY_4, item.getQty_4());

            db.insert(TABLE_ORDER_PRODUCT, null, values);
            Log.e("database", "insert order product " + item.getId().toString());
        }
    }


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_INVENTORY);
        db.execSQL(CREATE_TABLE_ORDER_PRODUCT);
        db.execSQL(CREATE_TABLE_ORDER_ADDRESS);
        db.execSQL(CREATE_TABLE_ORDER_PAY);
        db.execSQL(CREATE_TABLE_CUSTOMER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVENTORY);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_ADDRESS);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_PAY);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CUSTOMER);

        // create new tables
        onCreate(db);
    }

    /*
     * Creating a Item
     */
    public void createItems(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, item.getId());
        values.put(ACTIVE, item.getActive());
        values.put(REGISTERED, item.getRegistered());
        values.put(MODIFIED, item.getModified());
        values.put(SIZE, item.getSize());
        values.put(PACK, item.getPack());
        values.put(EXPECTED_DATE, item.getExpect_date());
        values.put(PRICE, item.getPrice());
        values.put(SALE_PRICE, item.getSale_price());


        db.insert(TABLE_INVENTORY, null, values);
        Log.e("database", "insert success");
    }




    /*
     * getting all Items
     */


    public List<Item> getAllItems() {
        // open database
        SQLiteDatabase db = this.getWritableDatabase();

        List<Item> items = new ArrayList<Item>();
        String selectQuery = "SELECT * FROM " + TABLE_INVENTORY;

        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(c.getString((c.getColumnIndex(KEY_ID))));
                item.setActive(c.getString(c.getColumnIndex(ACTIVE)));
                item.setRegistered(c.getString(c.getColumnIndex(REGISTERED)));
                item.setModified(c.getString(c.getColumnIndex(MODIFIED)));
                item.setSize(c.getString(c.getColumnIndex(SIZE)));
                item.setPack(c.getString(c.getColumnIndex(PACK)));
                item.setExpect_date(c.getString(c.getColumnIndex(EXPECTED_DATE)));
                item.setPrice(c.getFloat(c.getColumnIndex(PRICE)));
                item.setSale_price(c.getFloat(c.getColumnIndex(SALE_PRICE)));

                items.add(item);
            } while (c.moveToNext());
        }
        return items;
    }


    /*
     * getting one item
     */
    public Item getItem(String stylenum) {
        // open database
        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_INVENTORY + " WHERE "
                + KEY_ID + " = '" + stylenum + "'";

        Log.e("LOG", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Item item = new Item();
        item.setId(c.getString((c.getColumnIndex(KEY_ID))));
        item.setActive(c.getString(c.getColumnIndex(ACTIVE)));
        item.setRegistered(c.getString(c.getColumnIndex(REGISTERED)));
        item.setModified(c.getString((c.getColumnIndex(MODIFIED))));
        item.setSize(c.getString(c.getColumnIndex(SIZE)));
        item.setPack(c.getString(c.getColumnIndex(PACK)));
        item.setExpect_date(c.getString(c.getColumnIndex(EXPECTED_DATE)));
        item.setPrice(c.getFloat(c.getColumnIndex(PRICE)));
        item.setSale_price(c.getFloat(c.getColumnIndex(SALE_PRICE)));

        return item;
    }

    public void deleteItem(String stylenum) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_INVENTORY + " WHERE " + KEY_ID + " = '" + stylenum + "'";
        Log.e("query test ", query);
        db.execSQL(query);
    }

    public void updateItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, item.getId());
        values.put(ACTIVE, item.getActive());
        values.put(REGISTERED, item.getRegistered());
        values.put(MODIFIED, item.getModified());
        values.put(SIZE, item.getSize());
        values.put(PACK, item.getPack());
        values.put(EXPECTED_DATE, item.getExpect_date());
        values.put(PRICE, item.getPrice());
        values.put(SALE_PRICE, item.getSale_price());

        db.update(TABLE_INVENTORY, values, KEY_ID + " = ?", new String[]{String.valueOf(item.getId())});
    }

    public boolean checkItem(String stylenum) {
        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_INVENTORY + " WHERE "
                + KEY_ID + " = '" + stylenum + "'";

        Log.e("LOG", selectQuery);


        Cursor c = db.rawQuery(selectQuery, null);
        Log.e("LOG", String.valueOf(c.getCount()));
        if (c.getCount() <= 0) {
            return false;
        }
        c.close();
        return true;
    }
}