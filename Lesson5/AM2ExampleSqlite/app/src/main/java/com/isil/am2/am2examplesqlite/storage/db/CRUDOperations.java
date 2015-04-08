package com.isil.am2.am2examplesqlite.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.isil.am2.am2examplesqlite.model.entity.ContactEntity;

import java.util.ArrayList;
import java.util.List;

public class CRUDOperations {

	private MyDatabase helper;
	public CRUDOperations(SQLiteOpenHelper _helper) {
		super();
		// TODO Auto-generated constructor stub
		helper =(MyDatabase)_helper;
	}

	public void addContact(ContactEntity contact)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		 ContentValues values = new ContentValues();
		 values.put(MyDatabase.KEY_NAME, contact.getName());
		 values.put(MyDatabase.KEY_PHONE_NUMBER, contact.getPhone_number());
		 
		 db.insert(MyDatabase.TABLE_CONTACTS, null, values);
		 db.close();
	}
	
	public ContactEntity getContact(int id)
	{
		SQLiteDatabase db = helper.getReadableDatabase(); //modo lectura
		Cursor cursor = db.query(MyDatabase.TABLE_CONTACTS,
				new String[]{MyDatabase.KEY_ID,MyDatabase.KEY_NAME,
				MyDatabase.KEY_PHONE_NUMBER},
				MyDatabase.KEY_ID+"=?", 
				new String[]{String.valueOf(id)}, null, null, null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
		}
		int nid = Integer.parseInt(cursor.getString(0));
		String name = cursor.getString(1);
		String phone_number = cursor.getString(2);
		
		ContactEntity contact= new ContactEntity(
				nid, name, phone_number);
		return contact;
	}
	
	public List<ContactEntity> getAllContacts()
	{
		List<ContactEntity> lst =new ArrayList<ContactEntity>();
		String sql= "SELECT  * FROM " + MyDatabase.TABLE_CONTACTS;
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		if(cursor.moveToFirst())
		{
			do
			{
				ContactEntity contact =new ContactEntity();
				contact.setId(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setPhone_number(cursor.getString(2));
				
				lst.add(contact);
			}while(cursor.moveToNext());
		}
		return lst;
	}
	
	public int getContactsCount()
	{
		String sql= "SELECT * FROM "+MyDatabase.TABLE_CONTACTS;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		cursor.close();
		
		return cursor.getCount();
	}
	
	//--------------------------------------------
	
	public int updateContact(ContactEntity contact)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(MyDatabase.KEY_NAME, contact.getName());
		values.put(MyDatabase.KEY_PHONE_NUMBER, contact.getPhone_number());
		
		return db.update(MyDatabase.TABLE_CONTACTS,
				values,
				MyDatabase.KEY_ID+"=?",
				new String[]{String.valueOf(contact.getId())});
	}
	//--------------------------------------------
	
	public int deleteContact(ContactEntity contact)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); 
		 int row= db.delete(MyDatabase.TABLE_CONTACTS,
				 MyDatabase.KEY_ID+"=?", 
				 new String[]{String.valueOf(contact.getId())});
		 db.close();
		return row;
	}
}
