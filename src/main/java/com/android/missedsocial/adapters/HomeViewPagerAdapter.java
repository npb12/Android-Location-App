package com.android.missedsocial.adapters;


import com.android.missedsocial.fragments.ConnectionListFragmentTab;
import com.android.missedsocial.fragments.EncounterListFragmentTab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;


/**
 * The ViewPager adapter to be used for the HomeFragment.
 *
 *
 */
public class HomeViewPagerAdapter extends SmartFragmentPageAdapter implements 
		ViewPager.OnPageChangeListener {
	private static final int sPAGE_COUNT = 2;
	private static final String[] TITLES = new String[] { "Encounters", "Connections" };
	
	/**
	 * Initializes the ViewPager to used the fragment manager passed in.
	 * 
	 * @param fm The fragment manager to be used in the view pager.
	 */
	public HomeViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	/*
	 * Gets the fragment located at the position passed in as a parameter.
	 */
	@Override
	public Fragment getItem(int position) {
		switch(position) {
			case 0:
				return new EncounterListFragmentTab();
			case 1:
				return new ConnectionListFragmentTab();
			default:
				throw new IllegalArgumentException("The item position should be less than " +
						"or equal to:" + sPAGE_COUNT);
		}
	}

	/**
	 * Gets the title of the tab at the position passed in.
	 * 
	 * @param position The position of the page.
	 * @return The title of the page.
	 */
	public CharSequence getPageTitle(int position) {
		return TITLES[position];
	}
	
	/*
	 * Gets the number of pages in the ViewPager.
	 */
	@Override
	public int getCount() {
		return sPAGE_COUNT;
	}

	/*
	 * Called when the user selects a page in the view pager.
	 */
	@Override
	public void onPageScrollStateChanged(int position) {
		if (position == ViewPager.SCROLL_STATE_DRAGGING) {
			((EncounterListFragmentTab) getRegisteredFragment(0)).resumeUpdates();
		}
	}

	/*
	 * Called when the user begins to scroll to a new pager.
	 */
	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

	/*
	 * Called when the user selects a page in the view pager.
	 */
	@Override
	public void onPageSelected(int position) {
		if (!(getRegisteredFragment(position) instanceof EncounterListFragmentTab)) {
			((EncounterListFragmentTab) getRegisteredFragment(0)).pauseUpdates();
		}
	}
}
