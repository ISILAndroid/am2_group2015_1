package com.isil.am2.am2examplesqlite.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {


	public static final int DATABASE_VERSION = 1;
 
	public static final String DATABASE_NAME = "MyBDContact";
 
    public static final String TABLE_CONTACTS = "tb_contacts";
    
    //Columnas de la Tabla Contacts
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    
    
    public MyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql= "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PHONE_NUMBER + " TEXT" + ")";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql= "DROP TABLE IF EXISTS " + TABLE_CONTACTS;
		db.execSQL(sql);
	}

}
