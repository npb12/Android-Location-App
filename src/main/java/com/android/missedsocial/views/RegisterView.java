package com.android.missedsocial.views;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegisterView extends LinearLayout {

	private ViewListener viewListener;
	private Button registeruserButton;

	public RegisterView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void setViewListener(ViewListener viewListener){
		this.viewListener = viewListener;
	}
	
	@Override
	protected void onFinishInflate(){
		super.onFinishInflate();
//		registeruserButton = (Button) findViewById(R.id.registeruserButton);

	
	
/*	registeruserButton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			if(viewListener != null){
				viewListener.onViewChange(RegisterFragment.
						MESSAGE_REGISTERUSER,null);
			}
		}
	});
	
	*/
	
	
	}
	

}
