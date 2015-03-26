package com.android.missedsocial.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.android.missedsocial.R;
import com.android.missedsocial.views.RegisterView;
import com.android.missedsocial.views.ViewListener;


public class RegisterActivity extends Activity{
	
	public static final String MESSAGE_REGISTER = "";
	public static final String MESSAGE_LOGIN = "";

	

	
	private RegisterView registerActivityView;
	private ViewListener viewListener;

	@Override
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		registerActivityView = (RegisterView) View
		.inflate(this, R.layout.activity_register, null);
		registerActivityView.setViewListener(viewListener);
		setContentView(registerActivityView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	


}

