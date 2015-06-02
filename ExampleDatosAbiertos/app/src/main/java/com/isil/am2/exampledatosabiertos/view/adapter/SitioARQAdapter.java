package com.isil.am2.exampledatosabiertos.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.isil.am2.exampledatosabiertos.R;
import com.isil.am2.exampledatosabiertos.model.entity.SitioARQEntity;

import java.util.List;

/**
 * Created by emedinaa on 26/05/2015.
 */
public class SitioARQAdapter extends ArrayAdapter<SitioARQEntity> {
    private Context context;
    private List<SitioARQEntity> data;

    public SitioARQAdapter(Context context, int resource, List<SitioARQEntity> data) {
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
            v = inflater.inflate(R.layout.row_sitio_arq, null);
            ViewHolder holder = new ViewHolder();
            holder.tviIdentificador = (TextView)v.findViewById(R.id.tviIdentificador);
            holder.tviNombre = (TextView)v.findViewById(R.id.tviNombre);
            holder.tviDistrito = (TextView)v.findViewById(R.id.tviDistrito);
            v.setTag(holder);
        }
        SitioARQEntity entry = data.get(position);
        if(entry != null)
        {
            ViewHolder holder = (ViewHolder)v.getTag();
            //holder.tviIdentificador.setText(entry.getIdentificador());
            holder.tviNombre.setText(entry.getNombre());
            holder.tviDistrito.setText(entry.getDistrito());
           // holder.iviMascota.setImageBitmap(aux);

            if(position==0)
            {
                holder.tviIdentificador.setText("ID");
            }else
            {
                holder.tviIdentificador.setText(entry.getIdentificador());
            }
        }


        return v;
    }


    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public SitioARQEntity getItem(int position) {
        return data.get(position);
    }
    static class ViewHolder
    {
        TextView tviIdentificador;
        TextView tviNombre;
        TextView tviDistrito;
    }

}
