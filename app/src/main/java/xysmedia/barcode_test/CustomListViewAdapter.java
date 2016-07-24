package xysmedia.barcode_test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jiung on 2016-02-10.
 */
public class CustomListViewAdapter extends BaseAdapter {
    private Context context;
    private final List<Item> items;
    private LayoutInflater mLayoutInflater;
    private HashMap<String, Integer> pos_quantity;

    public CustomListViewAdapter(List<Item> values,HashMap<String, Integer> pos_quantity) {
        this.items = values;
        this.pos_quantity = pos_quantity;
    }
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Object getItem(int pos) {
        return items.get(pos);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.pos_item, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.pos_stylenum);
        name.setText(items.get(position).getId());

        TextView price = (TextView) view.findViewById(R.id.pos_price);
        price.setText(String.valueOf(items.get(position).getSale_price()));
        Log.e("price확인",String.valueOf(items.get(position).getSale_price()));

        TextView quantity = (TextView) view.findViewById(R.id.pos_quantity);
        quantity.setText(String.valueOf(pos_quantity.get(items.get(position).getId())));

        return view;
    }
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }

}
