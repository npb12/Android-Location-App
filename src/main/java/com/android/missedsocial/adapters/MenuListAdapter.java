package com.android.missedsocial.adapters;

import com.android.missedsocial.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * This class acts as an adapter for a list. In particular it acts as the adapter for the list
 * displayed in the navigation drawer.
 *
 *
**/
public class MenuListAdapter extends BaseAdapter {
	private Context context;
	private String[] titles;
	private String[] subTitles;
	private LayoutInflater inflater;
	
	/**
	 * Initializes the context, titles, subtitles, and icons of the list adapter.
	 * 
	 * @param context This context of the adapter.
	 * @param titles The titles to be used for the list items.
	 * @param subtitles The subtitles to be used for the list items.
	 * @param icons The icons to be used for the list items.
	 */
	public MenuListAdapter(Context context, String[] titles, String[] subtitles) {
		this.context = context;
		this.titles = titles;
		this.subTitles = subtitles;
	}
	
	/*
	 * Gets the number of items in the list adapter.
	 */
	@Override
	public int getCount() {
		return titles.length;
	}
	
	/*
	 * Gets the title of the item at the location of the variable 'position'
	 */
	@Override
	public String getItem(int position) {
		return titles[position];
	}
	
	/*
	 * Gets the id of the item at the position passed in as a parameter.
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	/**
	 * Gets he view of the item located at the position passed in by the parameter.
	 * 
	 * @param position The position of the item whose view is to be retrieved.
	 * @param convertView 
	 * @param parent The parent of the item whose view is be retrieved.
	 * @return The view of the item at the position position
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textTitle;
		TextView textSubTitle;
		
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.drawer_list_item, parent, false);
		
		textTitle = (TextView) itemView.findViewById(R.id.title);
		textSubTitle = (TextView) itemView.findViewById(R.id.subtitle);

		textTitle.setText(titles[position]);
		textSubTitle.setText(subTitles[position]);

		return itemView;
	}
}

