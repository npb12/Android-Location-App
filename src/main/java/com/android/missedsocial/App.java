package com.android.missedsocial;

import android.app.Application;
import android.content.Context;


public class App extends Application {
	private static App instance;
	
	/*
	 * Creates the instance.
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}
	
	/**
	 * Gets the instance of the application context.
	 * 
	 * @return The application context.
	 */
	public static Context getContext() {
		return instance.getApplicationContext();
	}
}

