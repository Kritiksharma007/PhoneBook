package com.example.phone_book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteSingleContact extends AppCompatActivity {

        AutoCompleteTextView autoCompleteTextView;
        DBHelper obj;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_delete_single_contact);
            autoCompleteTextView=findViewById(R.id.auto);

            obj=new DBHelper(this);
            ArrayList arrayList=obj.viewAll();
            ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,arrayList);
            autoCompleteTextView.setAdapter(adapter);
            autoCompleteTextView.setThreshold(3);
        }


    public void onPress(View view) {
        String s1=autoCompleteTextView.getText().toString();
        int count=obj.deleteSingle(s1);
        Toast.makeText(this,count+" record deleted!!",Toast.LENGTH_LONG).show();
        autoCompleteTextView.setText(null);
    }

}
