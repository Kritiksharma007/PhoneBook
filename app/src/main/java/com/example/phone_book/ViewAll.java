package com.example.phone_book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAll extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    DBHelper obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        listView=findViewById(R.id.lv1);
        obj=new DBHelper(this);
        ArrayList alist=obj.viewAll();
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,alist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String str=adapterView.getItemAtPosition(i).toString();
        ArrayList<String> record=obj.getSingleRecord(str);
        // Toast.makeText(this,""+record,Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,ViewNext.class);
        intent.putStringArrayListExtra("id",record);

        startActivity(intent);
    }
}
