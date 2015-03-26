package com.android.missedsocial.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Extends FragmentPagerAdapter to allow easy access to the fragments in the pager.
 * 
 * 
 */
public abstract class SmartFragmentPageAdapter extends FragmentPagerAdapter {
	private SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

	/*
	 * Default constuctor.
	 */
	public SmartFragmentPageAdapter(FragmentManager fm) {
		super(fm);
	}
	
	/*
	 * Called to instantiate an item.
	 */
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Fragment fragment = (Fragment) super.instantiateItem(container, position);
		registeredFragments.put(position, fragment);
		return fragment;
	}
	
	/*
	 * Called to destroy an item.
	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		registeredFragments.remove(position);
		super.destroyItem(container, position, object);
	}
	
	/**
	 * 
	 * Gets the fragment at the position passed in.
	 * 
	 * @param position the position of the fragment to retrieve.
	 * @return The fragment at the requested position.
	 */
	public Fragment getRegisteredFragment(int position) {
		return registeredFragments.get(position);
	}
}
