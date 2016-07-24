package xysmedia.barcode_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListForStorage extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listChildQuantity;
    HashMap<String, List<String>> listDataChild;

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.explistforstorage);

        ImageButton addbtn = (ImageButton)findViewById(R.id.plusicon);


        /*******************************보류
        addbtn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpandableListForStorage.this, AddItem.class);
                intent.putExtra("activityname","Storage");
                startActivity(intent);
            }


        });

         ********************************/
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.items);

        Log.e("testtest", "123123");
        // preparing list data
        //prepareListData();
        Log.e("testtest", "456456");
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, listChildQuantity);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String stylenum = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                //Intent intent = new Intent(ExpandableListForStorage.this, ModifyItem.class);
                //intent.putExtra("stylenumber", stylenum);
                //startActivity(intent);
                return false;
            }

        });
    }

    /*
     * Preparing the list data
     */



    /***********************************보류****************
    private void prepareListData() {
        // Database Helper
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        listChildQuantity = new HashMap<>();

        List<String> categoryNames = new ArrayList<String>();
        List<Integer> categoryQuantity = new ArrayList<Integer>();


        List<Storage> storages = new ArrayList<>();
        storages = db.getStorageFromInventory();
        Log.e("storagetest", String.valueOf(storages));

        int count =0;
        for(Storage storage : storages ) {
            Log.e("storagetest",storage.getStorage());
            categoryNames.add(storage.getStorage());
            categoryQuantity.add(storage.getQuantity());

            List<Item> items= new ArrayList<>();
            items = db.getItemsFromStorage(storage.getStorage());
            listDataHeader.add(storage.getStorage());

            List<String> Style = new ArrayList<>();
            List<String> Quantity = new ArrayList<>();
            for(Item item : items) {
                Style.add(item.getId().toString());
                Quantity.add(String.valueOf(item.getQuantity()));
                Log.e("check", item.getId().toString() + " " + String.valueOf(item.getQuantity())
                        + " " + item.getCategory().toString());
            }
            listDataChild.put(listDataHeader.get(count), Style);
            listChildQuantity.put(listDataHeader.get(count), Quantity);
            count++;
        }
        db.close();
    }

     **************************************************************************/
}
