package com.example.mapplication8;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by 박남주 on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener{
    AutoCompleteTextView etName;
    int imgno;
    EditText  etPrice;
    ImageView iv1;
    Button b_add,b_next;


    public AddFruit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context c) {
        LayoutInflater.from(c).inflate(R.layout.add_fruit,this);
        etName = (AutoCompleteTextView) findViewById(R.id.f_name);
        etPrice = (EditText)findViewById(R.id.f_price);
        iv1 = (ImageView)findViewById(R.id.image1);
        b_add =(Button)findViewById(R.id.b_add);
        b_next =(Button)findViewById(R.id.b_next);
        b_add.setOnClickListener(this);
        b_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == b_add){
            if(b_add.getText().toString().equals("ADD")){
                onAddListener.onAdd(etName.getText().toString(),etPrice.getText().toString(), Fruit.imglist[imgno]);

            }
            else{
                onChangeListener.onChange(etName.getText().toString(),etPrice.getText().toString(), Fruit.imglist[imgno]);
                b_add.setText("ADD");
            }
        }
        else if(view == b_next){
            if(imgno == 0){
                imgno++;
                iv1.setImageResource(Fruit.imglist[imgno]);
            }
            else if(imgno < 7){
                imgno++;
                iv1.setImageResource(Fruit.imglist[imgno]);
            }
            else{
                imgno = 0;
                iv1.setImageResource(Fruit.imglist[imgno]);
            }

        }
    }

    interface OnAddListener{
        void onAdd(String name, String price, int imano);
    }
    public OnAddListener onAddListener;
    public  void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }

    interface OnChangeListener{
        void onChange(String name, String price, int imano);
    }
    public OnChangeListener onChangeListener;
    public  void setOnChangeListener(OnChangeListener onChangeListener){
        this.onChangeListener = onChangeListener;
    }
}
