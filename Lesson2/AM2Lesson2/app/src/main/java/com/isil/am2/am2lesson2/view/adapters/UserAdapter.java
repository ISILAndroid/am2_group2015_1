package com.isil.am2.am2lesson2.view.adapters;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.am2.am2lesson2.R;
import com.isil.am2.am2lesson2.model.entity.UserEntity;

public class UserAdapter extends ArrayAdapter<UserEntity> {

	private List<UserEntity> data;
	private Context context;
	
	public UserAdapter(Context context, int resource, List<UserEntity> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.data=objects;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		 View v = convertView;
	        if(v == null)
	        {
	            LayoutInflater inflater = LayoutInflater.from(context);
	            v = inflater.inflate(R.layout.row_user, null);
	            ViewHolder holder = new ViewHolder();
	            holder.txt = (TextView)v.findViewById(R.id.txtUser);
	            holder.img = (ImageView)v.findViewById(R.id.imgUser);

	            v.setTag(holder);
	        }
	        UserEntity entry = data.get(position);
	        if(entry != null)
	        {


	            ViewHolder holder = (ViewHolder)v.getTag();
	            holder.txt.setText(entry.getName());
	        }

	        return v;
	}
	
	
	public static class ViewHolder
	{
		private ImageView img;
		private TextView txt;
	}

}
