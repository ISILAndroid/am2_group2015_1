package com.isil.am2.am2examplesqlite;

import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import com.isil.am2.am2examplesqlite.model.entity.ContactEntity;
import com.isil.am2.am2examplesqlite.storage.db.CRUDOperations;
import com.isil.am2.am2examplesqlite.storage.db.MyDatabase;
import com.isil.am2.am2examplesqlite.view.fragments.AddContactFragment;
import com.isil.am2.am2examplesqlite.view.fragments.ContactFragment;
import com.isil.am2.am2examplesqlite.view.fragments.DetailFragment;
import com.isil.am2.am2examplesqlite.view.listeners.OnHomeListener;

public class HomeActivity extends ActionBarActivity implements OnHomeListener {

    private  static  final  int LIST_CONTACT=100;
    private  static  final  int ADD_CONTACT=101;
    private  static  final  int DETAIL_CONTACT=102;

    private ContactFragment contactFragment= ContactFragment.newInstance(null,null);
    private AddContactFragment addContactFragment= AddContactFragment.newInstance(null,null);
    private DetailFragment detailFragment= DetailFragment.newInstance(null,null);

	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
        getActionBar().hide();

        if (savedInstanceState == null) {
            changeFragment(LIST_CONTACT,null);
        }

		//app();
	}
    private  void changeFragment(int id,Bundle bundle)
    {
        Fragment fragment= null;
        switch (id)
        {
            case LIST_CONTACT:
                fragment=contactFragment;
                break;

            case ADD_CONTACT:
                fragment=addContactFragment;
                break;

            case DETAIL_CONTACT:
                fragment=detailFragment;
                break;
        }

        if(fragment!=null)
        {
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }

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

    @Override
    public void addContact(Object object) {
        changeFragment(ADD_CONTACT,null);
    }

    @Override
    public void listContacts() {
        changeFragment(LIST_CONTACT,null);
    }

    @Override
    public void selectedContact(ContactEntity contactEntity)
    {
        Bundle bundle= new Bundle();
        bundle.putSerializable("ENTITY",contactEntity);

        changeFragment(DETAIL_CONTACT,bundle);
    }
}
