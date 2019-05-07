package com.example.tente.serviceapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();

        myDb = new DatabaseHelper(this);

        Date timp = new Date();
        Cursor c = myDb.getAllData("collected_gps_data");//read from database
        if(c.getCount()>0){
            while(c.moveToNext()){
                Log.d("TEST","---->>>id="+c.getString(0)+
                        "\nlat="+c.getString(1)+
                        "\n long="+c.getString(2)+
                        "\n timestamp="+c.getString(3)+
                        "\n acceleration="+c.getString(4));
            }
        }

    }


}
