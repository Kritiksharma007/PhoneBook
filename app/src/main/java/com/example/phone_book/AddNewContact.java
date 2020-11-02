package com.example.phone_book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContact extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        e3=findViewById(R.id.et3);
        e4=findViewById(R.id.et4);
        e5=findViewById(R.id.et5);

    }

    public void reset()
    {
        e1.setText(null);
        e2.setText(null);
        e3.setText(null);
        e4.setText(null);
        e5.setText(null);
    }
    public void onPress(View view)
    {
        if(view.getId()==R.id.b1)
        {   DBHelper obj=new DBHelper(this);
            String s1= e1.getText().toString();
            String s2=e2.getText().toString();
            String s3=e3.getText().toString();
            String s4=e4.getText().toString();
            String s5=e5.getText().toString();
            long count=obj.save(s1,s2,s3,s4,s5);
            Toast.makeText(this,count+"item inserted",Toast.LENGTH_LONG).show();
            reset();
        }
       /* if(view.getId()==R.id.b7)
        {
            Intent intent=new Intent(this, OpenCamera.class);
            startActivity(intent);

        }*/
        else
        {
            reset();
        }
    }
}
