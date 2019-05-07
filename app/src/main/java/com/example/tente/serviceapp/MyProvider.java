package com.example.tente.serviceapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tente on 2/5/2018.
 */

public class MyProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] protection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String action = uri.getLastPathSegment();
        Log.d("TEST","action: "+action);
        String rasp = "Nu Exista";

        switch (action){
            case "Time":
                Intent intS = new Intent(getContext(),MyService.class);
                intS.putExtra("teste",selection);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                rasp = sdf.format(new Date());
                getContext().startService(intS);
                break;
            case "collected":
                Log.d("TEST","in collected case action in service in content provider");

                intS = new Intent(getContext(),MyService.class);
                intS.putExtra(action,selectionArgs);
                getContext().startService(intS);

                rasp="ok";
                break;
            default:
                rasp = "Nu Exista";
                break;
        }


        MatrixCursor cursor = new MatrixCursor(new String[]{rasp},1);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
