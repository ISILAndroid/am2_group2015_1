package com.isil.am2.am2internalstorage.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isil.am2.am2internalstorage.R;
import com.isil.am2.am2internalstorage.model.NoteEntity;

public class DetailsNoteFragment extends Fragment {

	
	TextView txtName, txtDesc, txtDate;
	private NoteEntity entity;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 return inflater.inflate(R.layout.fragment_detailsnote, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		txtName = (TextView)getView().findViewById(R.id.txtName);
		txtDate =(TextView)getView().findViewById(R.id.txtDateOfCreation);
		txtDesc = (TextView)getView().findViewById(R.id.txtDesc);
		
		validateExtra();
		if(entity!=null)
		{
			setData();
		}else
		{
			//error
		}

	}
	private void setData() {
		// TODO Auto-generated method stub
		
		String desc =readInternalStorage();
		txtName.setText(entity.getName());
		txtDate.setText(entity.getDate());
		txtDesc.setText(desc);
	}
	private void validateExtra() {
		// TODO Auto-generated method stub
		if (getArguments()!=null)
		{
			entity = (NoteEntity)getArguments().getSerializable("NOTE");
		}
	}
	public String  readInternalStorage()
	{
		String data ="";
		String fileName = entity.getPath();
		FileInputStream fis;
		try {
			fis = getActivity().openFileInput(fileName);
			
			int c;
			String aux="";
			while( (c=fis.read())!=-1)
			{
				aux = aux + Character.toString((char)c);
			}
			
			data=aux;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
}
