package com.example.phone_book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewNext extends AppCompatActivity
{
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_next);
        listView=findViewById(R.id.listview1);

        Intent intent=getIntent();
        ArrayList record=intent.getStringArrayListExtra("id");
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,record);
        listView.setAdapter(adapter);
    }
}
