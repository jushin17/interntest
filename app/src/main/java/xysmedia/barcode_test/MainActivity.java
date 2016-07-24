package xysmedia.barcode_test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ProgressDialog prgDialog;
    DatabaseHelper db = new DatabaseHelper(this);
    private View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prgDialog = new ProgressDialog(this);
        prgDialog.setMessage("Transferring Data from Remote MySQL DB Syncing SQLite. Please wait....");
        prgDialog.setCancelable(false);

        Button itembtn = (Button)findViewById(R.id.itembtn);
        itembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExpandableListForItems.class);
                startActivity(intent);
            }
        });

        Button storagebtn = (Button)findViewById(R.id.storagebtn);
        storagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExpandableListForStorage.class);
                startActivity(intent);
            }
        });

        Button posbtn = (Button)findViewById(R.id.posbtn);
        posbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PosActivity.class);
                startActivity(intent);
            }
        });

        Button syncbtn = (Button) findViewById(R.id.syncbtn);
        syncbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                syncSQLiteMySQLDB();
            }
        });

        Button pdfbtn = (Button) findViewById(R.id.pdf_btn);
        pdfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PrintActivity.class);
                startActivity(intent);
            }
        });
    }


    // Method to Sync MySQL to SQLite DB

    public void syncSQLiteMySQLDB() {
        // Create AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        // Http Request Params Object
        RequestParams params = new RequestParams();
        // Show ProgressBar
        prgDialog.show();
        // Make Http call to product_info.php

        client.post("http://192.168.1.8/final/admin/android/product_info.php", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                for (int i=0; i < response.length() ; i++) {
                    try {
                        JSONObject jsonobject = response.getJSONObject(i);
                        Item item = new Item();
                        item.setId(jsonobject.getString("style_number"));
                        item.setActive(jsonobject.getString("active"));
                        item.setRegistered(jsonobject.getString("registered"));
                        item.setModified(jsonobject.getString("modified"));
                        item.setSize(jsonobject.getString("size"));
                        item.setPack(jsonobject.getString("pack"));
                        item.setExpect_date(jsonobject.getString("expect_date"));
                        item.setPrice(Float.parseFloat(jsonobject.getString("price_1")));
                        item.setSale_price(Float.parseFloat(jsonobject.getString("sale_price")));

                        db.createItems(item);
                        String style_number = jsonobject.getString("style_number");

                        Log.e("logtest", String.valueOf(item.getSale_price()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                prgDialog.hide();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                if (statusCode == 404) {
                    Toast.makeText(getApplicationContext(), "404 - Error", Toast.LENGTH_SHORT).show();
                } else if (statusCode == 500) {
                    Toast.makeText(getApplicationContext(), "500 - Error", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "When Http response code other than 404,500", Toast.LENGTH_SHORT).show();
                }
                prgDialog.hide();
            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}


