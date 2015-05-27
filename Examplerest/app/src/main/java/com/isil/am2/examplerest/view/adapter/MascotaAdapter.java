package com.isil.am2.examplerest.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.am2.examplerest.R;
import com.isil.am2.examplerest.model.entity.MascotaEntity;

import java.util.List;

/**
 * Created by emedinaa on 26/05/2015.
 */
public class MascotaAdapter extends ArrayAdapter<MascotaEntity> {
    private Context context;
    private List<MascotaEntity> data;

    public MascotaAdapter(Context context,int resource, List<MascotaEntity> data) {
        super(context,resource);
        this.context= context;
        this.data= data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_mascota, null);
            ViewHolder holder = new ViewHolder();
            holder.iviMascota = (ImageView)v.findViewById(R.id.iviMascota);
            holder.tviName = (TextView)v.findViewById(R.id.tviName);
            holder.tviDesc = (TextView)v.findViewById(R.id.tviDesc);
            v.setTag(holder);
        }
        MascotaEntity entry = data.get(position);
        if(entry != null)
        {
            Bitmap bm= BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_pet);
            //Bitmap aux= ImageUtils.getCircularBitmap(bm);


            ViewHolder holder = (ViewHolder)v.getTag();
            holder.tviName.setText(entry.getName());
            holder.tviDesc.setText(entry.getDetalle());
           // holder.iviMascota.setImageBitmap(aux);
        }


        return v;
    }


    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public MascotaEntity getItem(int position) {
        return data.get(position);
    }
    static class ViewHolder
    {
        ImageView iviMascota;
        TextView tviName;
        TextView tviDesc;
    }

}
