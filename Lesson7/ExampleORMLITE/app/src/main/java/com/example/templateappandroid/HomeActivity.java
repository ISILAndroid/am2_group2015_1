package com.example.templateappandroid;

import java.util.List;

import com.example.templateappandroid.storage.db.DatabaseHelper;
import com.example.templateappandroid.model.entity.ContactEntity;
import com.example.templateappandroid.view.adapters.ContactAdapter;
import com.example.templateappandroid.view.fragments.AddContactFragment;
import com.example.templateappandroid.view.fragments.ContactFragment;
import com.example.templateappandroid.view.fragments.DetailFragment;
import com.example.templateappandroid.view.listeners.OnHomeListener;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ListView;

public class HomeActivity extends ActionBarActivity implements OnHomeListener {


    private  static  final  int LIST_CONTACT=100;
    private  static  final  int ADD_CONTACT=101;
    private  static  final  int DETAIL_CONTACT=102;

	//private DatabaseHelper mhelper;
	//private ListView lstContact;
	//private List<ContactEntity> data;
	//private ContactAdapter adapter;

    private ContactFragment contactFragment= ContactFragment.newInstance(null,null);
    private AddContactFragment addContactFragment= AddContactFragment.newInstance(null,null);
    private DetailFragment detailFragment= DetailFragment.newInstance(null,null);

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

        getActionBar().hide();

        if (savedInstanceState == null) {
            changeFragment(LIST_CONTACT,null);
        }

        //lstContact= (ListView)findViewById(R.id.lstContacts);
		
		//mhelper=new DatabaseHelper(this);
		//setData();
		//appDB();
	}

	private void setData() {
		// TODO Auto-generated method stub
		/*ContactEntity entity1= new ContactEntity( "Eduardo", "abc@abc.com", "4575488");
		ContactEntity entity2= new ContactEntity( "Eduardo",  "abc@abc.com", "4575488");
		ContactEntity entity3= new ContactEntity( "Eduardo",  "abc@abc.com", "4575488");
		ContactEntity entity4= new ContactEntity("Eduardo",  "abc@abc.com", "4575488");
		ContactEntity entity5= new ContactEntity("Eduardo",  "abc@abc.com", "4575488");
		
		mhelper.addContactData(entity1);
		mhelper.addContactData(entity2);
		mhelper.addContactData(entity3);
		mhelper.addContactData(entity4);
		mhelper.addContactData(entity5);*/
	}

	private void appDB() {
		// TODO Auto-generated method stub
		
		/*data =mhelper.getContactAll();
		
		adapter= new ContactAdapter(this, data);
		lstContact.setAdapter(adapter);*/
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
                fragment=AddContactFragment.newInstance(null,null);
                break;


            case DETAIL_CONTACT:
                fragment= DetailFragment.newInstance(null,null);
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


    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.home, menu);
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
    public void selectedContact(ContactEntity contactEntity) {
        Bundle bundle= new Bundle();
        bundle.putSerializable("ENTITY",contactEntity);


        changeFragment(DETAIL_CONTACT,bundle);
    }
}
