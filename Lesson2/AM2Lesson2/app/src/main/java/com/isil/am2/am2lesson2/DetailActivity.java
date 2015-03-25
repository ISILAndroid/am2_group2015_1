package com.isil.am2.am2lesson2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.isil.am2.am2lesson2.view.fragments.FourFragment;
import com.isil.am2.am2lesson2.view.fragments.OneFragment;
import com.isil.am2.am2lesson2.view.fragments.ThreeFragment;
import com.isil.am2.am2lesson2.view.fragments.TwoFragment;


public class DetailActivity extends ActionBarActivity {

    private OneFragment oneFragment= OneFragment.newInstance(null,null);
    private TwoFragment twoFragment= TwoFragment.newInstance(null,null);
    private ThreeFragment threeFragment= ThreeFragment.newInstance(null,null);
    private FourFragment fourFragment= FourFragment.newInstance(null,null);

    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        validateExtra();
        setFragment();
    }

    private void setFragment() {

        String name="";
        Fragment fragment=null;

        switch (pos)
        {
            case 0:
                fragment=oneFragment;
                name= "oneFragment";
                break;
            case 1:
                fragment=twoFragment;
                name= "twoFragment";
                break;
            case 2:
                fragment=threeFragment;
                name= "threeFragment";
                break;
            case 3:
                fragment=fourFragment;
                name= "fourFragment";
                break;
        }

        if(fragment!=null)
        {
            changeFragment(null,fragment,name);
        }
    }

    private void validateExtra() {
        if(getIntent()!=null)
        {
            pos=getIntent().getIntExtra("POS",0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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

    private void changeFragment(Bundle args, Fragment fragment,String fragName) {
        // update the main content by replacing fragments
        if (args != null) fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragName != null)
        {
            fragmentManager.beginTransaction().replace(R.id.container, fragment,fragName).commit();
        }

    }
}
