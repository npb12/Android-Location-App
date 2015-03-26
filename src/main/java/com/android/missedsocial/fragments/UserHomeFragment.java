package com.android.missedsocial.fragments;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.android.missedsocial.R;
import com.android.missedsocial.adapters.HomeViewPagerAdapter;


public class UserHomeFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.viewpager_status, container, false);
		
		ViewPager ViewPager = (ViewPager) view.findViewById(R.id.viewPager);	
		ViewPager.setAdapter(new HomeViewPagerAdapter(getChildFragmentManager()));
		
		ViewPager.setOnPageChangeListener((OnPageChangeListener) ViewPager.getAdapter());
		
		return view;
	}
	

	@Override
	public void onDetach() {
		super.onDetach();
		try {
			Field childFragmentManager = Fragment.class
					.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
