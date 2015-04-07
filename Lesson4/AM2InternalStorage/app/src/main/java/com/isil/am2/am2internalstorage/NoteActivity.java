package com.isil.am2.am2internalstorage;

import java.io.Serializable;

import com.isil.am2.am2internalstorage.model.NoteEntity;
import com.isil.am2.am2internalstorage.view.DetailsNoteFragment;
import com.isil.am2.am2internalstorage.view.NewNoteFragment;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class NoteActivity extends FragmentActivity {

	public static final  String DETAILS_NOTE ="details";
	public static final String NEW_NOTE ="newnote";
	private String currentView=null;
	private NoteEntity currentEntity=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
		
		validateExtra();
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		Fragment fragment = getSelectedFragment(currentEntity);
		
		FragmentManager fm= getSupportFragmentManager();
		FragmentTransaction ft= fm.beginTransaction();
		ft.add(R.id.container,fragment);
		ft.commit();
		
	}
	
	public Fragment getSelectedFragment(Serializable entity)
	{
		Fragment fragment=null;
		
		if(currentView.equals(NoteActivity.NEW_NOTE))
		{
			fragment = new NewNoteFragment();
			return fragment;
			
		}else if(currentView.equals(NoteActivity.DETAILS_NOTE))
		{
			Bundle bundle=new Bundle();
			bundle.putSerializable("NOTE", entity);
			
			fragment = new DetailsNoteFragment();
			fragment.setArguments(bundle);
			return fragment;
			
		}
		return null;
	}

	private void validateExtra() {
		// TODO Auto-generated method stub
		Bundle bundle =getIntent().getExtras();
		if(bundle!=null)
		{
			if(bundle.getString("VIEW")!=null)
			{
				currentView= bundle.getString("VIEW");
			}
			if(bundle.getSerializable("ENTITY")!=null)
			{
				currentEntity = (NoteEntity)bundle.getSerializable("ENTITY");
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		return false;
	}

}
