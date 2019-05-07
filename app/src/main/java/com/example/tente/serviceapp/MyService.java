package com.example.tente.serviceapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tente on 1/29/2018.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    DatabaseHelper myDb;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"SERVICE",Toast.LENGTH_LONG).show();
        Log.d("TEST","I######N THE SERVICE");

        myDb = new DatabaseHelper(this);

        if(intent.hasExtra("teste")){
            String cv = intent.getExtras().getString("teste");
            Log.d("TEST","---------------->>>>>>>>>>>");


        }
        if(intent.hasExtra("collected")){
            Log.d("TEST","in service in collected extra");
            //get string[]extra si apeleaza baza de data sa inserezi datele
            //verifica daca datele sunt  sunt egale cu 0
            String[] s = intent.getStringArrayExtra("collected");
            for(int i=0;i<s.length;i++)
                Log.d("TEST","continut pentru baza de date in servici "+s[i]);


            ArrayList date = new ArrayList();
            date.add(s[0]);
            date.add(s[1]);
            date.add(s[2]);
            date.add(s[3]);
            boolean reusit = myDb.insertCollectedData("collected_gps_data",date);//insert data


            Log.d("TEST","-----> insert="+reusit);


        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("TEST","service stop");
        super.onDestroy();
    }

}
