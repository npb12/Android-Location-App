package com.android.missedsocial.views;


import com.android.missedsocial.R;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LoginView extends LinearLayout {

	private ViewListener viewListener;
	private Button loguserButton;
	
	public LoginView(Context context, AttributeSet attrs) {
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
