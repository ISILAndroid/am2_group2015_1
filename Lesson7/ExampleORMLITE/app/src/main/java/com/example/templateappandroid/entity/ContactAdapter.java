package com.example.templateappandroid.entity;

import java.util.List;



import com.example.templateappandroid.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<ContactEntity> {

	private List<ContactEntity> data;
	private Context context;
	
	public ContactAdapter(Context _context,
			int textViewResourceId, List<ContactEntity> _data) 
	{
		super(_context, textViewResourceId, _data);
		// TODO Auto-generated constructor stub
		this.context=_context;
		this.data=_data;
	}
	
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		ContactsViewHolder viewHolder;
		if(v==null)
		{
	           LayoutInflater li = (LayoutInflater) getContext().getSystemService(
	                    Context.LAYOUT_INFLATER_SERVICE);
	            v = li.inflate(R.layout.item_row_contact, parent, false);
	 
	            viewHolder = new ContactsViewHolder();
	            viewHolder.txtName=(TextView)v.findViewById(R.id.txt_row_name);
	            viewHolder.txtDesc=(TextView)v.findViewById(R.id.txt_row_desc);
	            v.setTag(viewHolder);
		}else
		{
			viewHolder = (ContactsViewHolder) v.getTag();
		}
		
		ContactEntity contact=data.get(position);
        if (contact != null) 
        {
            viewHolder.txtName.setText(contact.getUserName());
            viewHolder.txtDesc.setText(contact.getEmail());
        }

		return v;
	}
	
    static class ContactsViewHolder {
        ImageView imgContact;
        TextView txtName;
        TextView txtDesc;
    }
	
	

}
