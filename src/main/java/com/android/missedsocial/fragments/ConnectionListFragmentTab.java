package com.android.missedsocial.fragments;

import java.io.IOException;
import java.net.Socket;

import android.accounts.NetworkErrorException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.android.missedsocial.R;
import com.android.missedsocial.models.ConnectionListModel;
import com.android.missedsocial.views.ConnectionListView;
import com.android.missedsocial.views.ViewListener;


public class ConnectionListFragmentTab extends SherlockFragment {


	private ConnectionListView connectionListView;
	private ConnectionListModel connectionList;
	
	private Handler handler;
	
	/*
	 * Creates the view and registers the view as a listener to the MapStatusModel.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		connectionListView = (ConnectionListView) inflater
				.inflate(R.layout.fragment_connectionlist, container, false);
		connectionListView.setViewListener(viewListener);
		handler = new Handler();

		
		return connectionListView;	
	}
	
	/*
	 * Called when the fragment is resumed and begins the data requests to the server.
	 */
	@Override
	public void onResume() {
		super.onResume();
	}
	

	
	/*
	 * Called when the fragment is paused and cancels all network actions, threads,
	 * and pauses the view.
	 */
	@Override
	public void onPause() {
		super.onPause();
	}
	

	
	/*
	 * Receives event from the view.
	 */
	private ViewListener viewListener = new ViewListener() {
		@Override
		public void onViewChange(String message, Object what) {}
	};
}
