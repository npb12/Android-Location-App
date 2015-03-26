package com.android.missedsocial.views;

import com.android.missedsocial.R;



import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;


public class EncounterListView extends LinearLayout{

	
	private ViewListener viewListener;

	



	public EncounterListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
    
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		

	}
	

	

}
