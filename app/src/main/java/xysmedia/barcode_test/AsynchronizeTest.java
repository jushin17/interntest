package xysmedia.barcode_test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.loopj.android.http.*;

import java.util.List;

/**
 * Created by Jiung on 2016-02-16.
 */
public class AsynchronizeTest extends Activity{
    DatabaseHelper db = new DatabaseHelper(this);
    ProgressDialog prgDialog;
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asyncronizetest);


    }
}
