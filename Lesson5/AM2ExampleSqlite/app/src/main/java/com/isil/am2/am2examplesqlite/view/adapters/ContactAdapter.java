package com.isil.am2.am2examplesqlite.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.am2.am2examplesqlite.model.entity.ContactEntity;

import java.util.List;

/**
 * Created by emedinaa on 07/04/2015.
 */
public class ContactAdapter extends BaseAdapter {

    private Context context;
    private List<ContactEntity> data;
    private LayoutInflater mLayoutInflater = null;

    public ContactAdapter(Context context, List<ContactEntity> data) {
        this.context = context;
        this.data = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public class ViewHolder
    {
        public ImageView iviContact;
        public TextView tviName;
        public TextView tviPhone;
    }
}
