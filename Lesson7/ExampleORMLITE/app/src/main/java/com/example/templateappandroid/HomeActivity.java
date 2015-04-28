package com.example.templateappandroid;

import java.util.List;

import com.example.templateappandroid.db.DatabaseHelper;
import com.example.templateappandroid.entity.ContactAdapter;
import com.example.templateappandroid.entity.ContactEntity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class HomeActivity extends Activity {

	private DatabaseHelper mhelper;
	private ListView lstContact;
	private List<ContactEntity> data;
	private ContactAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		lstContact= (ListView)findViewById(R.id.lstContacts);
		
		mhelper=new DatabaseHelper(this);
		setData();
		appDB();
	}

	private void setData() {
		// TODO Auto-generated method stub
		ContactEntity entity1= new ContactEntity(100, "Eduardo", "Medina", "abc@abc.com", "CEO");
		ContactEntity entity2= new ContactEntity(100, "Eduardo", "Medina", "abc@abc.com", "CEO");
		ContactEntity entity3= new ContactEntity(100, "Eduardo", "Medina", "abc@abc.com", "CEO");
		ContactEntity entity4= new ContactEntity(100, "Eduardo", "Medina", "abc@abc.com", "CEO");
		ContactEntity entity5= new ContactEntity(100, "Eduardo", "Medina", "abc@abc.com", "CEO");
		
		/*mhelper.addContactData(entity1);
		mhelper.addContactData(entity2);
		mhelper.addContactData(entity3);
		mhelper.addContactData(entity4);
		mhelper.addContactData(entity5);*/
	}

	private void appDB() {
		// TODO Auto-generated method stub
		
		data =mhelper.getContactAll();
		
		adapter= new ContactAdapter(this, R.layout.item_row_contact, data);
		lstContact.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.home, menu);
		return false;
	}

}
