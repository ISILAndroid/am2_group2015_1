package com.isil.am2.am2lesson2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    List<View> arrFraLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrFraLay=new ArrayList<View>();
        arrFraLay.add(findViewById(R.id.fraLay1));
        arrFraLay.add(findViewById(R.id.fraLay2));
        arrFraLay.add(findViewById(R.id.fraLay3));
        arrFraLay.add(findViewById(R.id.fraLay4));

        for (int i = 0; i <arrFraLay.size() ; i++) {
            final int pos=i;
            arrFraLay.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoDetail(pos);
                }
            });
        }
    }

    private void gotoDetail(int pos) {
        Intent intent= new Intent(this, DetailActivity.class);
        intent.putExtra("POS",pos);

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
