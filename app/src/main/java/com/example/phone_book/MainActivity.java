package com.example.phone_book;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPress(View v)
    {
        if(v.getId()==R.id.button)
        {
            Intent intent=new Intent(this,AddNewContact.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button2)
        {
            Intent intent=new Intent(this,DeleteSingleContact.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button3)
        {
            Intent intent=new Intent(this,DeleteAll.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button4)
        {
            Intent intent=new Intent(this,UpdateContact.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button5)
        {
            Intent intent=new Intent(this,ViewAll.class);
            startActivity(intent);
        }
      if(v.getId()==R.id.button6)
        {
            Intent intent=new Intent(this,SearchContact.class);
            startActivity(intent);
        }

    }
}
