package com.android.missedsocial.fragments;



import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.android.missedsocial.R;
import com.android.missedsocial.models.EncounterListModel;
import com.android.missedsocial.views.EncounterListView;
import com.android.missedsocial.views.ViewListener;


public class EncounterListFragmentTab extends SherlockFragment {


    public static final String MESSAGE_LOCATION = "";

	private EncounterListView encounterListView;
	private EncounterListModel encounterList;
	
	private Handler handler;

	
	/*
	 * Creates the view and registers the view as a listener to the MapStatusModel.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		encounterListView = (EncounterListView) inflater
				.inflate(R.layout.fragment_encounterlist, container, false);
		encounterListView.setViewListener(viewListener);
		handler = new Handler();

		
		return encounterListView;	
	}
	
	/*
	 * Called when the fragment is resumed and begins the data requests to the server.
	 */
	@Override
	public void onResume() {
		super.onResume();
		resumeUpdates();
	}
	
	/**
	 * Resumes the updating of the map status values
	 */
	public void resumeUpdates() {
		//spacecraftStatusView.resume();
		//handler.removeCallbacks(spacecraftStatusRun);
		//handler.post(spacecraftStatusRun);
	}
	
	/*
	 * Called when the fragment is paused and cancels all network actions, threads,
	 * and pauses the view.
	 */
	@Override
	public void onPause() {
		super.onPause();
		pauseUpdates();
	}
	
	/**
	 * Pauses the updating of the map status values
	 */
	public void pauseUpdates() {
		/*
		if (fetchSpacecraftStatusTask != null && !fetchSpacecraftStatusTask.isComplete()) {
			fetchSpacecraftStatusTask.abort();
		}
		handler.removeCallbacks(spacecraftStatusRun);
		spacecraftStatusView.pause();
		*/
	}
	

	
	/*
	 * Receives event from the view.
	 */
	private ViewListener viewListener = new ViewListener() {
		@Override
		public void onViewChange(String message, Object what) {}
	};
}
