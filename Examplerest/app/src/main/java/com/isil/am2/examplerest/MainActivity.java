package com.isil.am2.examplerest;

import android.support.v4.app.FragmentManager;
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

import com.isil.am2.examplerest.view.fragments.DetalleMascotaFragment;
import com.isil.am2.examplerest.view.fragments.MainFragment;
import com.isil.am2.examplerest.view.fragments.MascotaFragment;
import com.isil.am2.examplerest.view.listeners.OnFragmentListener;


public class MainActivity extends ActionBarActivity implements OnFragmentListener{

    public final static String FMASCOTA="MASCOTA";
    public final static String FDETMASCOTA="DETMASCOTA";

    private MainFragment mainFragment= MainFragment.newInstance(null,null);
    private MascotaFragment mascotaFragment= MascotaFragment.newInstance(null,null);
    private DetalleMascotaFragment detalleMascotaFragment= DetalleMascotaFragment.newInstance(null,null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mascotaFragment)
                    .commit();
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


        return false;
    }

    @Override
    public void changeFragment(Bundle bundle, String fragName, String fragBack) {
        Fragment fragment= factoryFragment(fragName);

        if (bundle != null) fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment, fragName).addToBackStack(fragBack).commit();
    }

    private Fragment factoryFragment(String fragName) {

        if(fragName.equals("MASCOTA"))
        {
            return mascotaFragment;
        }else if(fragName.equals("DETMASCOTA"))
        {
            return detalleMascotaFragment;
        }
        return null;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
