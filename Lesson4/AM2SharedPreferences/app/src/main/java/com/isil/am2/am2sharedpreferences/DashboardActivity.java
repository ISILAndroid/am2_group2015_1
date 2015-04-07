package com.isil.am2.am2sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DashboardActivity extends ActionBarActivity {

    private TextView tviUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tviUsername= (TextView)findViewById(R.id.tviUsername);

        SharedPreferences sp = getSharedPreferences("MYSHAREDPREFERENCES", 0);
        String username= sp.getString("USERNAME",null);

        if(username!=null)
        {
           tviUsername.setText("Bienvenido "+username);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return false;
    }
}
