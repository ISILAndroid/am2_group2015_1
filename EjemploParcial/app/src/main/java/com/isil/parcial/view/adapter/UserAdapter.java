package com.isil.parcial.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.parcial.R;
import com.isil.parcial.model.UserEntity;

import java.util.List;

/**
 * Created by emedinaa on 5/05/15.
 * Adapter asociado a la entidad UserEntity
 */
public class UserAdapter extends ArrayAdapter<UserEntity>
{

    //contexto
    private Context context;

    //lista de la entidad User
    private List<UserEntity> data;


    // Constructor del adaptador
    public UserAdapter(Context context, int resource, List<UserEntity> objects) {
        super(context, resource, objects);

        this.context = context;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //View v = convertView;

        //si es la primera vez que pinta el item
        /*if(v == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_user, null);
            ViewHolder holder = new ViewHolder();
            holder.iviUser = (ImageView)v.findViewById(R.id.iviUser);
            holder.tviUser = (TextView)v.findViewById(R.id.tviUser);
            v.setTag(holder);
        }*/

        //si la entidad existe
       /* UserEntity entry = data.get(position);
        if(entry != null)
        {
            ViewHolder holder = (ViewHolder)v.getTag();
            holder.tviName.setText(entry.getName());
        }*/

        //return v;
        return super.getView(position, convertView, parent);
    }

    //devuelve el total de elementos
    @Override
    public int getCount() {
        return data.size();
    }

    //devuelve cada elemento
    @Override
    public UserEntity getItem(int position) {
        return data.get(position);
    }

    //clase Holder
    static class ViewHolder
    {
        ImageView iviUser;
        TextView tviUser;
    }
}
