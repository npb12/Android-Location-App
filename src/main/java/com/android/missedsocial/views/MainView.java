package com.android.missedsocial.views;


import com.android.missedsocial.R;
import com.android.missedsocial.activities.MainActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainView extends LinearLayout {

	private ViewListener viewListener;
	private Button registerButton;
	private Button loginButton;
//	private Button JSONbutton;
	
	public MainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void setViewListener(ViewListener viewListener){
		this.viewListener = viewListener;
	}
	
	@Override
	protected void onFinishInflate(){
		super.onFinishInflate();

	}
	
	
	

}
