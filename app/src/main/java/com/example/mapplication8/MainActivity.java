package com.example.mapplication8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    final int imglist[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry,
            R.drawable.grape, R.drawable.kiwi, R.drawable.orange, R.drawable.watermelon};
    ArrayList<Fruit>  fruit = new ArrayList<Fruit>();
    GridView gridView;
    gridAdapter adapter;
    AddFruit addFruit;
    ArrayAdapter<String> autoAdapter;
    AutoCompleteTextView tv_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        tv_Name = (AutoCompleteTextView)findViewById(R.id.f_name);

        //어뎁터랑 그리드 뷰 연결
        adapter = new gridAdapter(fruit,this);
        gridView = (GridView)findViewById(R.id.grid);
        gridView.setAdapter(adapter);

        //자동완성
        final String[] data = getResources().getStringArray(R.array.fruit);
        autoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data);
        tv_Name.setAdapter(autoAdapter);


        //addFruit 사용하여 추가하기
        addFruit = (AddFruit)findViewById(R.id.addFruit);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
                @Override
            public void onAdd(String name, String price, int imgno) {
                Toast.makeText(getApplicationContext(), "추가되었습니다", Toast.LENGTH_SHORT).show();
                fruit.add(new Fruit(name,price,imgno));

                adapter.notifyDataSetChanged();
            }
        });

        //체크박스 사용하여 가격 visible/invisible
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked()) adapter.visiblePrice();
                else adapter.invisiblePrice();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Fruit one = fruit.get(i);
                final AutoCompleteTextView f_name = (AutoCompleteTextView)findViewById(R.id.f_name);
                final EditText f_price = (EditText)findViewById(R.id.f_price);
                final ImageView iv = (ImageView)findViewById(R.id.image1);
                Button b_add = (Button)findViewById(R.id.b_add);

                f_name.setText(fruit.get(i).name);
                f_price.setText(fruit.get(i).price);
                iv.setImageResource(fruit.get(i).imgno);
                b_add.setText("M");

                addFruit.setOnChangeListener(new AddFruit.OnChangeListener() {
                    @Override
                    public void onChange(String name, String price, int imano) {
                        Toast.makeText(getApplicationContext(), "수정되었습니다", Toast.LENGTH_SHORT).show();
                        one.name = name;
                        one.price = price;
                        one.imgno = imano;
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }
}
