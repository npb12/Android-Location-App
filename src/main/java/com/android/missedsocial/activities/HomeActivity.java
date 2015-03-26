package com.android.missedsocial.activities;

import java.io.IOException;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.android.missedsocial.R;



import com.android.missedsocial.fragments.EncounterListFragmentTab;
import com.android.missedsocial.fragments.ConnectionListFragmentTab;
import com.android.missedsocial.views.HomeView;
import com.android.missedsocial.views.ViewListener;


import com.android.missedsocial.R;




public class HomeActivity extends SherlockFragmentActivity{
	
	public static final String MESSAGE_DRAWER_ITEM_CLICK = "40.";

	
	private HomeView homeView;
	


	
	Fragment fragmentConnection = new ConnectionListFragmentTab();
	Fragment fragmentEncounter = new EncounterListFragmentTab();


	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		homeView = (HomeView) View.inflate(this, R.layout.activity_home, null);
		homeView.setViewListener(viewListener);
		setContentView(homeView);
		homeView.setupView(savedInstanceState, this);
	}
	
	/*
	 * Creates the options menu.
	 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getSupportMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
	
    /*
     * Called by the view when the drawer is open.
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
    }
    
	/*
	 * Called after the creation of the activity. Sends a message to the HomeView to synchronize
	 * the drawer toggle.
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		homeView.onPostCreate(savedInstanceState);
	}
	


	/**
	 * Manages the fragment transactions occurring when the user selects a new item from the 
	 * navigation drawer list.
	 * 
	 * @param position The position of the item selected.
	 */
	private void selectItem(int position) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		switch(position) {
		case 0:
			ft.replace(R.id.contentFrame, fragmentEncounter);
			break;
			
		case 1:
			ft.replace(R.id.contentFrame, fragmentConnection);
			break;
		
		}
		ft.commit();
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		homeView.onOptionsItemSelected(item);
        	return super.onOptionsItemSelected(item);    
	}
	

	/**
	 * Receives event from the view.
	 */
	private ViewListener viewListener = new ViewListener() {
		@Override
		public void onViewChange(String message, Object what) {
			if (message.equals(MESSAGE_DRAWER_ITEM_CLICK) && what instanceof Integer) {
				Integer item = (Integer) what;
				selectItem(item.intValue());
			}
		}
	};






}
