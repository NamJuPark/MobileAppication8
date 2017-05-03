package com.example.mapplication8;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 박남주 on 2017-05-01.
 */

public class gridAdapter extends BaseAdapter{

    ArrayList<Fruit> fruit = new ArrayList<Fruit>();
    Context context;

    public gridAdapter(ArrayList<Fruit> fruit, Context context){
        this.fruit = fruit;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int i) {
        return fruit.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) view = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
        Fruit one = fruit.get(i);

        TextView f_name = (TextView)view.findViewById(R.id.tvName);
        TextView f_price = (TextView)view.findViewById(R.id.tvPrice);
        ImageView iv = (ImageView)view.findViewById(R.id.ivFuite);

        f_name.setText(one.name);
        f_price.setText(one.price);
        iv.setImageResource(one.imgno);
        one.tvPrice = f_price;

        return view;
    }

    public void visiblePrice(){
        for(int i = 0; i < fruit.size(); i++){
            fruit.get(i).tvPrice.setVisibility(View.VISIBLE);
            this.notifyDataSetChanged();
        }
    }

    public void invisiblePrice() {
        for(int i = 0; i < fruit.size(); i++){
            fruit.get(i).tvPrice.setVisibility(View.INVISIBLE);
            this.notifyDataSetChanged();
        }
    }


}
