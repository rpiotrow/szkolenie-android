package com.example.shoppinglist;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<Product> {

	private LayoutInflater inflater;

	public MyArrayAdapter(Context context, ArrayList<Product> values) {
		super(context, R.layout.row_layout, values);
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		if (rowView == null) {
			rowView = inflater.inflate(R.layout.row_layout, parent, false);
			
			ViewHolder viewHolder = new ViewHolder();
			
			viewHolder.checkBox = (CheckBox) rowView.findViewById(R.id.checkBox1);
			viewHolder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
					Product item = (Product) compoundButton.getTag();
					item.setBought(value);
					
				}
			});
			viewHolder.textView = (TextView) rowView.findViewById(R.id.textView1);
			
			rowView.setTag(viewHolder);
		}
		
		ViewHolder viewHolder = (ViewHolder) rowView.getTag();	
		
		final Product item = getItem(position);
		viewHolder.checkBox.setTag(item);
		
		viewHolder.textView.setText(item.getName());
		viewHolder.checkBox.setChecked(item.isBought());
		
		return rowView;
	}
	
	private static class ViewHolder {
		private CheckBox checkBox;
		private TextView textView;
	}
	
}
