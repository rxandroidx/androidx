package com.jetpack.rxandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "Netpaisa";

    // Contacts table name
    private static final String TABLE_USERS = "netpaisa";

    // User Table Columns names
    private static final String KEY_USER_ID         = "userid";
    private static final String KEY_USER_NAME       = "user_name";
    private static final String KEY_USER_EMAIL      = "email_id";
    private static final String KEY_PHONE           = "mobile";
    private static final String KEY_BALANCE         = "wallet_balance";
    private static final String KEY_ADDRESS         = "address";
    private static final String KEY_TOKEN           = "token";
    private static final String KEY_USER_TYPE       = "usertype";
    private static final String KEY_RETAILER_ID     = "retailer_id";
    private static final String KEY_SESSION         = "mobile_session_key";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    } //  KEY_ID + " INTEGER PRIMARY KEY,"


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_USER_ID + " INTEGER," + KEY_USER_NAME + " TEXT," + KEY_USER_EMAIL + " TEXT," + KEY_PHONE + " TEXT,"
                + KEY_BALANCE + " TEXT," + KEY_ADDRESS + " TEXT," + KEY_TOKEN + " TEXT," + KEY_USER_TYPE + " TEXT," + KEY_SESSION + " TEXT,"+ KEY_RETAILER_ID + " TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        if (newVersion > oldVersion) {
            onCreate(db);
        }
    }

    // Adding new shop
    public void addProfileData(ProfileModel model) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, String.valueOf(model.getUserId()));
        values.put(KEY_USER_NAME, model.getUserName());
        values.put(KEY_USER_EMAIL, model.getEmailId());
        values.put(KEY_PHONE, model.getMobile());
        values.put(KEY_BALANCE, model.getWalletBalance());
        values.put(KEY_ADDRESS, model.getAddress());
        values.put(KEY_TOKEN, model.getToken());
        values.put(KEY_USER_TYPE, model.getUserType());
        values.put(KEY_SESSION,model.getMobile_session_key());
        values.put(KEY_RETAILER_ID, model.getRetailerId());
        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        // Closing database connection
        // Log.d(TAG, "New user inserted into sqlite: "+id);
        db.close();
    }

    // Getting All data
    public ProfileModel getAllData() {
        ProfileModel model = null;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_USER_ID, KEY_USER_NAME,
                    KEY_USER_EMAIL, KEY_PHONE, KEY_BALANCE, KEY_ADDRESS,KEY_TOKEN,KEY_USER_TYPE,KEY_SESSION,KEY_RETAILER_ID}, null, null, null, null, null);
            model = new ProfileModel();
            if (cursor.moveToFirst()) {
                model.setUserId((cursor.getString(0)));
                model.setUserName(cursor.getString(1));
                model.setEmailId(cursor.getString(2));
                model.setMobile(cursor.getString(3));
                model.setWalletBalance(cursor.getString(4));
                model.setAddress(cursor.getString(5));
                model.setToken(cursor.getString(6));
                model.setUserType(cursor.getString(7));
                model.setMobile_session_key(cursor.getString(8));
                model.setRetailerId(cursor.getString(9));
            }
            cursor.close();
        } catch (SQLiteException se) {
            se.printStackTrace();
        }
        return model;
    }



    @Override
    public synchronized void close() {
        SQLiteDatabase db = this.getWritableDatabase();
        if(db != null){
            db.close();
            super.close();
        }
    }

    // Deleting all data
    public void deleteProfileData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, null, null);
        db.close();
    }
}




