package com.isil.am2.examplelistviewadapter.view.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.am2.examplelistviewadapter.R;
import com.isil.am2.examplelistviewadapter.model.entity.ProductEntity;
import com.isil.am2.examplelistviewadapter.model.entity.UserEntity;
import com.isil.am2.examplelistviewadapter.utils.ImageUtils;

import java.util.List;

/**
 * Created by ALUMNO on 23/08/2014.
 */
public class ProductAdapter extends ArrayAdapter<ProductEntity> {

    private Context context;
    private List<ProductEntity> data;

    public ProductAdapter(Context context, int resource, List<ProductEntity> objects) {
        super(context, resource, objects);

        this.context = context;
        this.data = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_product, null);
            ViewHolder holder = new ViewHolder();
            holder.iviProduct = (ImageView)v.findViewById(R.id.iviProduct);
            holder.tviName = (TextView)v.findViewById(R.id.tviName);
            //holder.tviSkills = (TextView)v.findViewById(R.id.tviSkill);
            v.setTag(holder);
        }
        ProductEntity entry = data.get(position);
        if(entry != null)
        {
            //Bitmap bm= BitmapFactory.decodeResource(context.getResources(), entry.getImg());
            //Bitmap aux= ImageUtils.getCircularBitmap(bm);

            ViewHolder holder = (ViewHolder)v.getTag();
            holder.tviName.setText(entry.getName());
           // holder.iviProduct.setImageBitmap(aux);
        }

        return v;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ProductEntity getItem(int position) {
        return data.get(position);
    }

    static class ViewHolder
    {
        ImageView iviProduct;
        TextView tviName;
    }

}
