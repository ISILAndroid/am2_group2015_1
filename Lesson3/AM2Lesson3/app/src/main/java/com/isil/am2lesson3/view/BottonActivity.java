package com.isil.am2lesson3.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.isil.am2lesson3.R;
import com.isil.am2lesson3.view.fragments.BottomBarFragment;
import com.isil.am2lesson3.view.fragments.BoxFragment;
import com.isil.am2lesson3.view.listener.OnBoxListener;

public class BottonActivity extends ActionBarActivity  implements OnBoxListener{

    BoxFragment boxFragment;
    BottomBarFragment bottomBarFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botton);

        bottomBarFragment = (BottomBarFragment)getSupportFragmentManager().findFragmentById(R.id.bottonFragment);
        boxFragment = (BoxFragment)getSupportFragmentManager().findFragmentById(R.id.boxFragment);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_button, menu);
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
    public void colorSelected(int pos) {
        boxFragment.selectedColor(0);
    }
}
