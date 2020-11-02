package com.example.phone_book;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DeleteAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_all);
    }

    public void onPress(View v)
    {
        Toast.makeText(this,"Testing",Toast.LENGTH_LONG).show();
        final  DBHelper obj=new DBHelper(this);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete all??");
        builder.setMessage("Do u really want to erase all the records!!");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int count=obj.deleteAll();
                Toast.makeText(DeleteAll.this,count+" record delted!!",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}
