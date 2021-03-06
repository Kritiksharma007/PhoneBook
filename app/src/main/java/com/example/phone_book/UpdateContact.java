package com.example.phone_book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateContact extends AppCompatActivity {

    EditText e,e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);
        e=findViewById(R.id.edittext1);
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        e3=findViewById(R.id.et3);
        e4=findViewById(R.id.et4);
        e5=findViewById(R.id.et5);


    }
    public void reset()
    {
        e.setText(null);
        e1.setText(null);
        e2.setText(null);
        e3.setText(null);
        e4.setText(null);
        e5.setText(null);
    }
    public void onPress(View v)
    {
        if(v.getId()==R.id.b)//search
        {
            String fn=e1.getText().toString();
            DBHelper obj=new DBHelper(this);
            ArrayList<String> alist=obj.getSingleRecord(fn);
            if(alist.size()==0)
            {
                Toast.makeText(this,"No record found",Toast.LENGTH_LONG).show();
            }
            else
            {
                e.setText(alist.get(0));
                e1.setText(alist.get(1));
                e2.setText(alist.get(2));
                e3.setText(alist.get(3));
                e4.setText(alist.get(4));
                e5.setText(alist.get(5));
            }
        }
        if(v.getId()==R.id.b1)
        {
            String s1=e.getText().toString();
            String s2=e1.getText().toString();
            String s3=e2.getText().toString();
            String s4=e3.getText().toString();
            String s5=e4.getText().toString();
            String s6=e5.getText().toString();
            DBHelper obj=new DBHelper(this);
            int count=obj.updateValue(s1,s2,s3,s4,s5,s6);
            Toast.makeText(this,count+" record updated!!",Toast.LENGTH_LONG).show();
            reset();
        }
        if(v.getId()==R.id.b2)
        {
            reset();
        }
    }
}
