package com.android.missedsocial.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.android.missedsocial.R;
import com.android.missedsocial.activities.HomeActivity;
import com.android.missedsocial.adapters.MenuListAdapter;

/**
 * This is the main view for the GameActivity. It creates and uses a navigation drawer with nested
 * fragments. The nested fragments are implemented on MapFragment which contains a ViewPager with 
 * two additional fragments. It also relays all user actions made in the subview fragments to the 
 * controller/activity with the interface ViewListener.
 *
 */
public class HomeView extends DrawerLayout {
	//TODO: Add fragmentCamera titles and subtitles here
	private static final String[] TITLES = new String[] { "Encounters", "Connections" };
	private static final String[] SUBTITLES = new String[] { 
		"See your encounters", "See your connections"};
	
	private ListView drawerList;
	private ActionBarDrawerToggle drawerToggle;
	private MenuListAdapter menuAdapter;
	private ActionBar actionBar;
	
	private SherlockFragmentActivity  activity;
	private HomeView homeView = this;
	private ViewListener viewListener;
	
	/**
	 * Creates the view.
	 * 
	 * @param context The context to create the view.
	 * @param attrs Any attributes to be set on the view.
	 */
	public HomeView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/**
	 * Sets up the view creating the navigation drawers and nested fragments.
	 * 
	 * @param savedInstanceState The saved instance state of the calling activity.
	 * @param activity The calling activity.
	 */
	public void setupView(Bundle savedInstanceState, SherlockFragmentActivity activity) {
		this.activity = activity;
		setupNavigation(savedInstanceState);
	}
	
	/**
	 * Sets up the navigation drawers.
	 * 
	 * @param savedInstanceState The saved instance state of the calling activity.
	 */
	private void setupNavigation(Bundle savedInstanceState) {
		actionBar = activity.getSupportActionBar();
		drawerList = (ListView) findViewById(R.id.listviewDrawer);
		setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		menuAdapter = new MenuListAdapter(activity, TITLES, SUBTITLES);
		drawerList.setAdapter(menuAdapter);
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		drawerToggle = new ActionBarDrawerToggle(activity, this, R.drawable.ic_drawer, 
				R.string.drawer_open, R.string.drawer_close) {
			
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
					activity.invalidateOptionsMenu();
				}
			}
			
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
					activity.invalidateOptionsMenu();
				}
			}
		};
		
		homeView.setDrawerListener(drawerToggle);
		
		if (savedInstanceState == null) {
			if (viewListener != null) {
				viewListener.onViewChange(HomeActivity.MESSAGE_DRAWER_ITEM_CLICK, 
						Integer.valueOf(0));
			}
			drawerList.setItemChecked(0, true);
			actionBar.setTitle(TITLES[0]);
			homeView.closeDrawer(drawerList);
		}
	}
	
	/**
	 * The listener for when a drawer item is clicked.
	 */
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if (viewListener != null) {
				viewListener.onViewChange(HomeActivity.MESSAGE_DRAWER_ITEM_CLICK, position);
			}
			drawerList.setItemChecked(position, true);
			activity.getSupportActionBar().setTitle(TITLES[position]);
			homeView.closeDrawer(drawerList);
		}
	}
		
	/*
	 * Called when the configuration of the navigation drawer changes.
	 * 
	 * @param The new configuration.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
		
	/**
	 * Sets the view listener to the parameter
	 * 
	 * @param viewListener The view listener to be set.
	 */
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}

	/**
	 * Should be called in the onOptionsItemSelected of the corresponding controller.
	 * 
	 * @param item The menu item selected.
	 */
	public void onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		
		if (itemId == android.R.id.home) {
			if (isDrawerOpen(drawerList)) {
				closeDrawer(drawerList);
			} else {
				openDrawer(drawerList);
			}
		}
	}

	/**
	 * Should be called in the onPostCreate method of the corresponding controller. To sync
	 * the state of the drawer toggle.
	 * 
	 * @param savedInstanceState
	 */
	public void onPostCreate(Bundle savedInstanceState) {
		drawerToggle.syncState();
	}
	
	public void onPrepareOptionsMenu(Menu menu) {
    	boolean drawerOpen = isDrawerOpen(drawerList);
    	menu.findItem(R.id.action_encounter).setVisible(!drawerOpen);
    	menu.findItem(R.id.action_connection).setVisible(!drawerOpen);
	}

}
