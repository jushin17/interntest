package xysmedia.barcode_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

/**
 * Created by Jiung on 2016-02-04.
 */

/***************************************보류
public class ModifyItem extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifyitem);

        Intent intent = getIntent();
        final String stylenum = intent.getStringExtra("stylenumber");

        final TextView stylenumber;
        final EditText quantity;
        final Spinner status, category;
        final String quantityHint;

        stylenumber = (TextView) findViewById(R.id.TextStyle);
        quantity = (EditText) findViewById(R.id.editTextQuantity);
        status = (Spinner) findViewById(R.id.spinnerStatus);
        category = (Spinner) findViewById(R.id.spinnerCategory);

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        final Item item = db.getItem(stylenum);

        stylenumber.setText(stylenum, TextView.BufferType.NORMAL);

        quantityHint = String.valueOf(item.getQuantity());
        quantity.setText(quantityHint);
        Log.e("check", quantityHint);

        ArrayAdapter myAdap = (ArrayAdapter) status.getAdapter();
        int spinnerPosition = myAdap.getPosition(String.valueOf(item.getStatus()));
        status.setSelection(spinnerPosition);

        myAdap = (ArrayAdapter) category.getAdapter();
        spinnerPosition = myAdap.getPosition(String.valueOf(item.getCategory()));
        category.setSelection(spinnerPosition);






        Button modify = (Button) findViewById(R.id.submit_item);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                Item item = new Item();
                Log.e("test", String.valueOf(quantity.getText()));
                String check = null;
                if (quantity.getText().toString() != null && quantity.getText().toString().isEmpty())
                    item.setQuantity(Integer.parseInt(quantityHint));
                    //item.setQuantity(Integer.parseInt(quantity.getText().toString()));
                else
                    item.setQuantity(Integer.parseInt(quantity.getText().toString()));
                //item.setQuantity(Integer.parseInt(quantityHint));

                item.setId(stylenumber.getText().toString());
                item.setStatus(String.valueOf(status.getSelectedItem()));
                item.setCategory(String.valueOf(category.getSelectedItem()));

                Log.e("item", item.getCategory() + " " + item.getId() + " " + item.getStatus() + " " + item.getQuantity());
                db.updateItem(item);

                Intent a = new Intent(ModifyItem.this, ExpandableListForItems.class);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
            }
        });

        Button delete = (Button) findViewById(R.id.delete_item);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                db.deleteItem(stylenum);

                Intent a = new Intent(ModifyItem.this, ExpandableListForItems.class);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
            }
        });

        ImageButton plusbtn = (ImageButton) findViewById(R.id.plusbutton);
        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity.setText(String.valueOf(Integer.parseInt(quantity.getText().toString())+1));

            }
        });

        ImageButton minusbtn = (ImageButton) findViewById(R.id.minusbutton);
        minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity.setText(String.valueOf(Integer.parseInt(quantity.getText().toString()) - 1));

            }
        });
    }
}

 */

