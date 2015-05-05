package com.example.templateappandroid.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;

import java.sql.SQLException;
import java.util.List;

import com.example.templateappandroid.model.entity.ContactEntity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

/**
 * Created by emedinaa on 28/04/2015.
 */
public class ContactRepository {

    private DatabaseHelper db;
    Dao<ContactEntity, String> contactDao;

    public Dao<ContactEntity, String> getContactDao() {
        return contactDao;
    }

    public ContactRepository(Context ctx)
    {

        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            contactDao = db.getContactDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int create(ContactEntity goal)
    {
        try {
            return contactDao.create(goal);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int update(ContactEntity goal)
    {
        try {
            return contactDao.update(goal);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(ContactEntity goal)
    {
        try {
            return contactDao.delete(goal);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public List<ContactEntity> getAll()
    {
        try {
            return contactDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }


    public ContactEntity getById(String idGoal)
    {
        try {
            QueryBuilder<ContactEntity, String> qb = contactDao.queryBuilder();
            qb.where().eq("id", idGoal);

            PreparedQuery<ContactEntity> pq = qb.prepare();
            return contactDao.queryForFirst(pq);

        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public List<ContactEntity> getQuery(QueryBuilder<ContactEntity, Integer> queryBuilder)
    {
        try {
            PreparedQuery<ContactEntity> preparedQuery = queryBuilder.prepare();
            return contactDao.query(preparedQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
