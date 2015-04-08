package com.isil.am2.am2examplesqlite;

import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import com.isil.am2.am2examplesqlite.model.entity.ContactEntity;
import com.isil.am2.am2examplesqlite.storage.db.CRUDOperations;
import com.isil.am2.am2examplesqlite.storage.db.MyDatabase;
import com.isil.am2.am2examplesqlite.view.fragments.ContactFragment;
import com.isil.am2.am2examplesqlite.view.listeners.OnHomeListener;

public class HomeActivity extends ActionBarActivity implements OnHomeListener {

    private ContactFragment contactFragment= ContactFragment.newInstance(null,null);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, contactFragment)
                    .commit();
        }

		//app();
	}

	private void app() {
		// TODO Auto-generated method stub
		MyDatabase db = new MyDatabase(this);
		CRUDOperations crud = new CRUDOperations(db);
		
		crud.addContact(new ContactEntity("Eduardo Medina", "976052576"));
		crud.addContact(new ContactEntity("Jose Alfaro", "976052576"));
		crud.addContact(new ContactEntity("Carlos Perez", "976052576"));
		
		List<ContactEntity> lst = crud.getAllContacts();
		for (ContactEntity c: lst)
		{
			Log.v("CONSOLE","Contact item "+ c.getId()+" "+c.getName()+" "+c.getPhone_number());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

}
