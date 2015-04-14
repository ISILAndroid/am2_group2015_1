package com.isil.am2.examplelistviewadapter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.isil.am2.examplelistviewadapter.model.entity.ProductEntity;
import com.isil.am2.examplelistviewadapter.view.fragments.ProductDetailFragment;
import com.isil.am2.examplelistviewadapter.view.fragments.ProductFragment;
import com.isil.am2.examplelistviewadapter.view.listeners.OnProductListener;


public class HomeActivity extends ActionBarActivity implements OnProductListener {

    private ProductFragment productFragment;
    private ProductDetailFragment productDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        productFragment= (ProductFragment)getSupportFragmentManager().findFragmentById(R.id.fragProduct);
        productDetailFragment= (ProductDetailFragment)getSupportFragmentManager().findFragmentById(R.id.fragDetail);
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
    public void productSelected(ProductEntity entity)
    {
        productDetailFragment.showProductDetail(entity);
    }
}
