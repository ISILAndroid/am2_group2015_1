package com.isil.am2.am2internalstorage;

import java.io.FileOutputStream;
import java.util.List;

import com.isil.am2.am2internalstorage.model.Data;
import com.isil.am2.am2internalstorage.model.NoteEntity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HomeActivity extends Activity {

	private Button btnAddNotes;
	private ListView lstNotes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		Data.getInstance();
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		btnAddNotes= (Button)findViewById(R.id.btnAddNotes);
		lstNotes =(ListView)findViewById(R.id.lstNotes);
		
		btnAddNotes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				createNote();
			}
		});
		

		populate();
	}

	private void populate() {
		// TODO Auto-generated method stub
		List<NoteEntity> objects= Data.getInstance().getNotes();
		
		ArrayAdapter<NoteEntity> adapter = new ArrayAdapter<NoteEntity>(this,
				android.R.layout.simple_list_item_1, objects);
		lstNotes.setAdapter(adapter);
		
		lstNotes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				showDetailsNote(position);
				
			}
			
		});
		
	}

	protected void showDetailsNote(int position) 
	{
		// TODO Auto-generated method stub
		
		NoteEntity entity = Data.getInstance().getNotes().get(position);
		if(entity!=null)
		{
			Intent intent=new Intent(this, NoteActivity.class);
			intent.putExtra("VIEW", NoteActivity.DETAILS_NOTE);
			intent.putExtra("ENTITY", entity);
			startActivity(intent);
		}

	}

	protected void createNote() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this, NoteActivity.class);
		intent.putExtra("VIEW", NoteActivity.NEW_NOTE);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return false;
	}

}
