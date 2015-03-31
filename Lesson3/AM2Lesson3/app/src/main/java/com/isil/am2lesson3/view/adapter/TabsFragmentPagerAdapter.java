package com.isil.am2lesson3.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.isil.am2lesson3.view.fragments.AFragment;
import com.isil.am2lesson3.view.fragments.BFragment;
import com.isil.am2lesson3.view.fragments.CFragment;

public class TabsFragmentPagerAdapter extends FragmentPagerAdapter{
	
	final int PAGE_COUNT = 3;
	
	/** Constructor of the class */
	public TabsFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}

	/** This method will be invoked when a page is requested to create */
	@Override
	public Fragment getItem(int arg0) {
		Bundle data = new Bundle();
		switch(arg0){
		
			/** tab1 is selected */
			case 0:
				AFragment fragment1 =AFragment.newInstance(null,null);
				return fragment1;
				
			/** tab2 is selected */
			case 1:
                BFragment fragment2 =BFragment.newInstance(null,null);
				return fragment2;
            case 2:
                CFragment fragment3 =CFragment.newInstance(null,null);
				return fragment3;
		}
		
		return null;
	}

	/** Returns the number of pages */
	@Override
	public int getCount() {		
		return PAGE_COUNT;
	}
	
}
