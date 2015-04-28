package com.example.templateappandroid.db;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.templateappandroid.entity.ContactEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
 
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
 
	private Context _context;
	private static final String DATABASE_NAME = "DBORMLITE.db";
	private static final int DATABASE_VERSION = 1;
	
	private Dao<ContactEntity, String> simpleContactDao = null;
	private RuntimeExceptionDao<ContactEntity, String> simpleRuntimeContactDao = null;
 
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		_context = context;
	}

	public Dao<ContactEntity, String> getContactDao() throws SQLException {
		if (simpleContactDao == null) {
			simpleContactDao = getDao(ContactEntity.class);
		}
		return simpleContactDao;
	}
 
	public RuntimeExceptionDao<ContactEntity, String> getSimpleDataContactDao() {
		if (simpleRuntimeContactDao == null) {
			simpleRuntimeContactDao = getRuntimeExceptionDao(ContactEntity.class);
		}
		return simpleRuntimeContactDao;
	}
	
	//Contact --------------------------------------------------------------------------
	
	public List<ContactEntity> getContactAll()
	{
		DatabaseHelper helper = new DatabaseHelper(_context);
		RuntimeExceptionDao<ContactEntity, String> simpleDao = helper.getSimpleDataContactDao();
		List<ContactEntity> list = simpleDao.queryForAll();
		return list;
	}
	
	//method for insert data
	public int addContactData(ContactEntity feed)
	{
		RuntimeExceptionDao<ContactEntity, String> dao = getSimpleDataContactDao();
		int i = dao.create(feed);
		return i;
	}
 
	//method for delete all rows
	public void deleteContactAll()
	{
		RuntimeExceptionDao<ContactEntity, String> dao = getSimpleDataContactDao();
		List<ContactEntity> list = dao.queryForAll();
		dao.delete(list);
	}
	//Delete
	public int deleteContact(ContactEntity entity)
	{
		RuntimeExceptionDao<ContactEntity, String> dao = getSimpleDataContactDao();
		int id =dao.delete(entity);
		return id;
	}
	
	//editar 
	public void updateContact(ContactEntity entity)
	{
		RuntimeExceptionDao<ContactEntity, String> dao = getSimpleDataContactDao();
		dao.update(entity);
	}
	
	/*public List<ContactEntity> getContactAll()
	{
		DatabaseHelper helper = new DatabaseHelper(_context);
		RuntimeExceptionDao<ContactEntity, String> simpleDao = helper.getSimpleDataDao();
		List<QuestionEntity> list = simpleDao.queryForAll();
		return list;
	} */

 
	//--------------------------------------------------------------------------------
	@Override
	public void close() {
		super.close();
		//simpleRuntimeDao = null;
		simpleRuntimeContactDao =null;
	}
 
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			//TableUtils.createTable(connectionSource, QuestionEntity.class);
			TableUtils.createTable(connectionSource, ContactEntity.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			//TableUtils.dropTable(connectionSource, QuestionEntity.class, true);
			TableUtils.dropTable(connectionSource, ContactEntity.class, true);
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}
}