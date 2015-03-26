package com.android.missedsocial.views;

import com.android.missedsocial.R;
import com.android.missedsocial.models.ConnectionListModel;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ConnectionListView extends LinearLayout{

	
	private ViewListener viewListener;
	private ConnectionListModel encounterList;
	



	public ConnectionListView(Context context, AttributeSet attrs) {
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
