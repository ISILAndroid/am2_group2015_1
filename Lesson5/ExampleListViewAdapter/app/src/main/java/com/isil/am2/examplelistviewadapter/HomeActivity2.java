package com.isil.am2.examplelistviewadapter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.isil.am2.examplelistviewadapter.model.entity.ProductEntity;
import com.isil.am2.examplelistviewadapter.view.listeners.OnProductListener;


public class HomeActivity2 extends ActionBarActivity implements OnProductListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return false;
    }

    @Override
    public void productSelected(ProductEntity entity) {

    }
}
