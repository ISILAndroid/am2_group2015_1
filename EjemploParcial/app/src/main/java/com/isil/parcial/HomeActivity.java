package com.isil.parcial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.isil.parcial.view.NavigationDrawerActivity;
import com.isil.parcial.view.listener.OnFragmentListener;


public class HomeActivity extends ActionBarActivity implements OnFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.btnIngresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHome();
            }
        });

    }

    private void gotoHome()
    {
        //ir a la siguiente pantalla
        startActivity(new Intent(this, NavigationDrawerActivity.class));
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

        return false;
    }

    @Override
    public void gotoAction(Object obj)
    {

    }


}
