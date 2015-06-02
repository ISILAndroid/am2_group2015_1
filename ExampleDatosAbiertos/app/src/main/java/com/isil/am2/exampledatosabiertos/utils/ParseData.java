package com.isil.am2.exampledatosabiertos.utils;

import com.isil.am2.exampledatosabiertos.model.entity.SitioARQEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 2/06/15.
 */
public class ParseData
{
    private List<SitioARQEntity> data;

    public ParseData(List<ArrayList<String>> lsObjects) {

        data= new ArrayList<SitioARQEntity>();

        ArrayList<String> item=null;
        int size=0;
        SitioARQEntity entity=null;

        for (int i = 0; i <lsObjects.size() ; i++) {
            item= lsObjects.get(i);
            entity= new SitioARQEntity();
            if(item!=null)
            {
                size= item.size();
                entity.setIdentificador(item.get(1));
                entity.setNombre(item.get(2));
                entity.setDistrito(item.get(4));
                data.add(entity);
            }
        }


    }

    public List<SitioARQEntity> getData() {
        return data;
    }
}
