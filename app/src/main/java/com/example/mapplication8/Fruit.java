package com.example.mapplication8;

import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by 박남주 on 2017-04-27.
 */

public class Fruit {
    final static int imglist[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry,
            R.drawable.grape, R.drawable.kiwi, R.drawable.orange, R.drawable.watermelon};
    int imgno;
    String name, price;
    TextView tvPrice;

    public  Fruit(String name , String price, int imgno){
        this.name = name;
        this.price = price;
        this.imgno = imgno;
    }
}
