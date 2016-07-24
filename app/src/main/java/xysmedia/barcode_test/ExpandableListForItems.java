package xysmedia.barcode_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;

public class ExpandableListForItems extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listChildQuantity;
    HashMap<String, List<String>> listDataChild;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.explistforitems);

        Log.e("checkcheck", "1");
        ImageButton addbtn = (ImageButton) findViewById(R.id.plusicon);
        addbtn.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(ExpandableListForItems.this, AddItem.class);
                // intent.putExtra("activityname","Items");
                //startActivity(intent);
            }


        });

        // preparing list data
        prepareListData();

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.items_list);
        Log.e("checkcheck", "2");

        Log.e("checkcheck", "3");
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, listChildQuantity);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        Log.e("checkcheck", "4");

        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String stylenum = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                //Intent intent = new Intent(ExpandableListForItems.this, ModifyItem.class);
                //intent.putExtra("stylenumber",stylenum);
                //startActivity(intent);
                return false;
            }

        });
    }

    /*
     * Preparing the list data
     */

    private void prepareListData() {
        // Database Helper
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listChildQuantity = new HashMap<String, List<String>>();


        List<Item> items = new ArrayList<Item>();
        items = db.getAllItems();
        listDataHeader.add("Items");

        Log.e("찍히나", "0");

        List<String> Style = new ArrayList<String>();
        List<String> Price = new ArrayList<String>();
        for (Item item : items) {
            Style.add(item.getId().toString());
            Price.add(String.valueOf(item.getPrice()));

        }
        listDataChild.put(listDataHeader.get(0), Style);
        listChildQuantity.put(listDataHeader.get(0), Price);

        db.close();
    }

    /*****************************************보류
     private void prepareListData() {
     // Database Helper
     DatabaseHelper db = new DatabaseHelper(getApplicationContext());

     listDataHeader = new ArrayList<String>();
     listDataChild = new HashMap<String, List<String>>();
     listChildQuantity = new HashMap<String, List<String>>();

     String[] category = {"Outwear","Bottom","Top","Dress"};
     for(int i=0; i<category.length;i++) {
     List<Item> items= new ArrayList<Item>();
     items = db.getItemsFromCategory(category[i]);
     listDataHeader.add(category[i]);

     Log.e("찍히나","0");

     List<String> Style = new ArrayList<String>();
     List<String> Quantity = new ArrayList<String>();
     for(Item item : items) {
     Style.add(item.getId().toString());
     Quantity.add(String.valueOf(item.getQuantity()));
     Log.e("check", item.getId().toString() + " " + String.valueOf(item.getQuantity())
     + " " + item.getCategory().toString() + " " +item.getStorage());
     }
     listDataChild.put(listDataHeader.get(i),Style);
     listChildQuantity.put(listDataHeader.get(i),Quantity);
     }
     db.close();
     }
     ****************************************************************/


}
