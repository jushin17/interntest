package xysmedia.barcode_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.util.Log;
/**
 * Created by Jiung on 2016-02-04.
 */


/*********************************보류
public class AddItem extends Activity {

    Button storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);

        Intent intent = getIntent();
        final String beforeactivity = intent.getStringExtra("activityname");


        final EditText stylenumber,  quantity;
        final Spinner status, category;


        stylenumber = (EditText) findViewById(R.id.editTextStyle);
        quantity = (EditText) findViewById(R.id.editTextQuantity);
        status = (Spinner) findViewById(R.id.spinnerStatus);
        category = (Spinner) findViewById(R.id.spinnerCategory);
        storage = (Button) findViewById(R.id.storagebtn);


        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddItem.this, SetStorage.class);
                startActivityForResult(intent, 1);
            }
        });





        Button submit = (Button) findViewById(R.id.submit_item);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open database
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                // set data for adding item
                Item item = new Item();
                item.setQuantity(Integer.parseInt(quantity.getText().toString()));
                item.setId(stylenumber.getText().toString());
                item.setStatus(String.valueOf(status.getSelectedItem()));
                item.setCategory(String.valueOf(category.getSelectedItem()));
                item.setStorage(storage.getText().toString());

                Log.e("왜안돼?", storage.getText().toString());

                if(db.checkStorage(storage.getText().toString())) {
                    Storage storagefromDB = db.getStorage(storage.getText().toString());
                    int beforequantity = storagefromDB.getQuantity();
                    int afterquantity = beforequantity+Integer.parseInt(quantity.getText().toString());

                    Storage newStorage = new Storage();
                    newStorage.setStorage(storage.getText().toString());
                    newStorage.setQuantity(afterquantity);
                    Log.e("Storage table test", "기존테이블존재O");
                    db.updateStorage(newStorage);
                }
                else {
                    Storage newStorage = new Storage();
                    newStorage.setStorage(storage.getText().toString());
                    newStorage.setQuantity(Integer.parseInt(quantity.getText().toString()));
                    db.createStorage(newStorage);
                    Log.e("Storage table test", "기존테이블존재X");
                }


               // Log.e("item", item.getCategory() + " " + item.getId() + " " + item.getStatus() + " " + item.getQuantity() + " " + item.getStorage());
                db.createItems(item);

                db.close();

                if (beforeactivity.equals("Items")) {
                    Intent a = new Intent(AddItem.this, ExpandableListForItems.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(a);
                }
                else {
                    Intent a = new Intent(AddItem.this, ExpandableListForStorage.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(a);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                storage.setText(data.getStringExtra("storagename"));
            }
        }
    }
}

 *//////////////////
