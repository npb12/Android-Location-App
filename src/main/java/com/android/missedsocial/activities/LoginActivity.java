package com.android.missedsocial.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.android.missedsocial.R;
import com.android.missedsocial.views.LoginView;
import com.android.missedsocial.views.ViewListener;

public class LoginActivity extends Activity{
	
	public static final String MESSAGE_REGISTER = "";
	public static final String MESSAGE_LOGIN = "";

	

	
	private LoginView loginActivityView;
	private ViewListener viewListener;
	
	private Button Button1;

	@Override
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loginActivityView = (LoginView) View
		.inflate(this, R.layout.activity_login, null);
		loginActivityView.setViewListener(viewListener);
		setContentView(loginActivityView);
		
		Button1 = (Button) findViewById(R.id.buttons);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public void sendMessage(View view) 
	{
	    Intent intent = new Intent(com.android.missedsocial.activities.LoginActivity.this, com.android.missedsocial.activities.HomeActivity.class);
	    startActivity(intent);
	}
	


}

