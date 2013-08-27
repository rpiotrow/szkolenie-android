package com.example.shoppinglist;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<String> {

	private LayoutInflater inflater;

	public MyArrayAdapter(Context context, ArrayList<String> values) {
		super(context, R.layout.row_layout, values);
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = inflater.inflate(R.layout.row_layout, parent, false);
		//CheckBox checkbox = (CheckBox) rowView.findViewById(R.id.checkBox1);
		TextView textView = (TextView) rowView.findViewById(R.id.textView1);
		textView.setText(getItem(position));
		
		return rowView;
	}
	
}
