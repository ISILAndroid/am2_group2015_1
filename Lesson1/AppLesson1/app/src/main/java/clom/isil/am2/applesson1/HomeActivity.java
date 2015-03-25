package clom.isil.am2.applesson1;

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

import clom.isil.am2.applesson1.view.fragments.FourFragment;
import clom.isil.am2.applesson1.view.fragments.OneFragment;
import clom.isil.am2.applesson1.view.fragments.ThreeFragment;
import clom.isil.am2.applesson1.view.fragments.TwoFragment;
import clom.isil.am2.applesson1.view.listener.OnFragmentListener;


public class HomeActivity extends ActionBarActivity implements OnFragmentListener{

    private OneFragment oneFragment= OneFragment.newInstance(null,null);
    private TwoFragment twoFragment= TwoFragment.newInstance(null,null);
    private ThreeFragment threeFragment= ThreeFragment.newInstance(null,null);
    private FourFragment fourFragment= FourFragment.newInstance(null,null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /* (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
        //changeFragment(null,oneFragment,"oneFragment");
        //changeFragment(null,twoFragment,"twoFragment");
        //changeFragment(null,threeFragment,"threeFragment");
        changeFragment(null,fourFragment,"fourFragment");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    @Override
    public void exitApp() {

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
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }
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
