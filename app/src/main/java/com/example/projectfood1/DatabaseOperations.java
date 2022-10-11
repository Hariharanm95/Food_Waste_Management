package com.example.projectfood1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version=1;
    public String CREATE_QUERY = "CREATE TABLE "+ Upload.TableData.TableInfo.TABLE_NAME+"(" + Upload.TableData.TableInfo.USER_NAME+" TEXT,"+ Upload.TableData.TableInfo.USER_PASS+" TEXT );";

    public DatabaseOperations(@Nullable Context context) {
        super(context, Upload.TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations","Database Created");


    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void putInformation(DatabaseOperations dop,String name,String pass){

        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Upload.TableData.TableInfo.USER_NAME,name);
        cv.put(Upload.TableData.TableInfo.USER_PASS,pass);
        long k=SQ.insert(Upload.TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations","Row inserted");


    }

    public Cursor getInformation(DatabaseOperations dop){
        SQLiteDatabase SQ= dop.getReadableDatabase();
        String[] columns={Upload.TableData.TableInfo.USER_NAME, Upload.TableData.TableInfo.USER_PASS};
        Cursor CR=SQ.query(Upload.TableData.TableInfo.TABLE_NAME,columns,null,null,null,null,null);

        return CR;

    }

}
