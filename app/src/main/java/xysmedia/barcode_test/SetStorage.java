package xysmedia.barcode_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jiung on 2016-02-04.
 */

//public class SetStorage extends Activity {
//    List<Storage> storages;
//    ArrayList<String> storagenames = new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.setstorage);
//
//        // preparing listview
//        final ListView listView = (ListView) findViewById(R.id.storagelist);
//
//
//        final CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(prepareList());
//        listView.setAdapter(customListViewAdapter);
//
//        final EditText storagename = (EditText) findViewById(R.id.putstoragename);
//        Button storageadd = (Button) findViewById(R.id.storageaddbtn);
//        storageadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Storage item = new Storage();
//                item.setStorage(storagename.getText().toString());
//                item.setQuantity(0);
//                storages.add(item);
//                listView.setAdapter(new CustomListViewAdapter(storages));
//            }
//        });
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Storage storage = (Storage) parent.getAdapter().getItem(position);
//                Toast.makeText(SetStorage.this, storage.getStorage(), Toast.LENGTH_SHORT).show();
//                Intent i = getIntent();
//                i.putExtra("storagename", storage.getStorage());
//                setResult(RESULT_OK, i);
//                finish();
//            }
//
//        });
//
//
//    }
//
//    private List<Storage> prepareList() {
//        // Open database
//        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
//        storages = new ArrayList<>();
//        //storages = db.getStorageFromInventory();
//
//        List<Storage> temp = new ArrayList<>();
//        temp = db.getStorageFromInventory();
//
//        // variable for save storage names
//
//
//
//        ListIterator<Storage> it = temp.listIterator();
//        while(it.hasNext()) {
//            Storage test = new Storage();
//            test = it.next();
//            Storage put = new Storage();
//            put.setStorage(test.getStorage());
//            put.setQuantity(test.getQuantity());
//            storages.add(put);
//        }
//        /*
//        for(Storage storage : storages) {
//            Storage test = new Storage();
//            test.setStorage(storage.getStorage());
//            test.setQuantity(storage.getQuantity());
//            storages.add(test);
//        }
//       */
//       // Log.e("Storagetest",storages.get(0).getStorage() + " " +storages.get(1).getStorage());
//        return storages;
//    }
//}
