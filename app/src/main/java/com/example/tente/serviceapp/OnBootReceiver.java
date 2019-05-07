package com.example.tente.serviceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by tente on 1/29/2018.
 */

public class OnBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){

            Log.d("TEST","#######in broadcast");
        }
        Log.d("TEST","#######in broadcast");
    }
}
