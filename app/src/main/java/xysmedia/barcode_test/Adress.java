package xysmedia.barcode_test;


public class Adress {
    String order_no;
    String b_fname;
    String b_lname;
    String b_company;
    String b_addr;
    String b_addr2;
    String b_city;
    String b_state;
    String b_country;
    String b_zip;
    String b_tel;

    String s_fname;
    String s_lname;
    String s_company;
    String s_addr;
    String s_addr2;
    String s_city;
    String s_state;
    String s_country;
    String s_zip;
    String s_tel;

    // constructors
    public Adress() {
    }

    public Adress(String order_no, String b_fname, String b_lname, String b_company,
            String b_addr, String b_addr2, String b_city, String b_state, String b_country,
            String b_zip, String b_tel, String s_fname, String s_lname, String s_company,
            String s_addr, String s_addr2, String s_city, String s_state, String s_country,
            String s_zip, String s_tel) {
        this.order_no = order_no;
        this.b_fname = b_fname;
        this.b_lname = b_lname;
        this.b_company = b_company;
        this.b_addr = b_addr;
        this.b_addr2 = b_addr2;
        this.b_city = b_city;
        this.b_state = b_state;
        this.b_country = b_country;
        this.b_zip = b_zip;
        this.b_tel = b_tel;
        this.s_fname = s_fname;
        this.s_lname = s_lname;
        this.s_company = s_company;
        this.s_addr = s_addr;
        this.s_addr2 = s_addr2;
        this.s_city = s_city;
        this.s_state = s_state;
        this.s_country = s_country;
        this.s_zip = s_zip;
        this.s_tel = s_tel;
    }

}
