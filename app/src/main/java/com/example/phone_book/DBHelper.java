package com.example.phone_book;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    public static String dbName="phonebook.db";
    public static String tableName="contactsentry";
    public static String column1="firstname";
    public static String column2="lastname";
    public static String column3="mobile";
    public static String column4="email";
    public static String column5="city";
    public static int dbVersion=1;
    public static String query="create table contactsentry(_id integer primary key autoincrement,firstname text,lastname text,mobile text,email text,city text)";

    public DBHelper(Context c)
    {
        super(c,dbName,null,dbVersion);
        //it will create ur database automatically
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(query);
        //it will create a table automatically
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long save(String fn,String ln,String m,String e,String c)
    {
        SQLiteDatabase db=getWritableDatabase(); //database opened
        ContentValues cv=new ContentValues();
        cv.put(column1,fn);
        cv.put(column2,ln);
        cv.put(column3,m);
        cv.put(column4,e);
        cv.put(column5,c);
        long count=db.insert(tableName,null,cv);

        db.close();
        return count;
    }
    public ArrayList viewAll()
    {
        SQLiteDatabase db=getReadableDatabase();

        Cursor c=db.query(tableName,null,null,null,null,null,"firstname");
        ArrayList alist=new ArrayList();
        while(c.moveToNext())
        {
            String str=c.getString(1);
            alist.add(str);
        }
        c.close();
        db.close();
        return alist;

    }
    public ArrayList getSingleRecord(String nm)
    {
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.query(tableName,null,"firstname=?",new String[]{nm},null,null,null);
        ArrayList<String> alist=new ArrayList<>();
        while(c.moveToNext())
        {
            alist.add(c.getString(0));
            alist.add(c.getString(1));
            alist.add(c.getString(2));
            alist.add(c.getString(3));
            alist.add(c.getString(4));
            alist.add(c.getString(5));
        }
        c.close();
        db.close();
        return alist;

    }
    public int deleteSingle(String fn)
    {
        SQLiteDatabase db=getWritableDatabase();
        int i=db.delete(tableName,"firstname=?",new String[]{fn});
        db.close();
        return i;
    }

    public int deleteAll() {
        SQLiteDatabase db=getWritableDatabase();
        int i=db.delete(tableName,null,null);
        db.close();
        return i;
    }
    public int updateValue(String id,String  nm,String mb,String em,String un,String ps)
    {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(column1,nm);
        cv.put(column2,mb);
        cv.put(column3,em);
        cv.put(column4,un);
        cv.put(column5,ps);
        int count=db.update(tableName,cv,"_id=?",new String[]{id});

        db.close();
        return count;
    }
}
