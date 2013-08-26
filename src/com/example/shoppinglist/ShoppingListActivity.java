package com.example.shoppinglist;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShoppingListActivity extends Activity {
	
	private static final String BUNDLE_PRODUCT_NAMES = "productNames";
	private Button addButton;
	private TextView productNameView;
	private EditText productNameInput;
	
	private ArrayList<String> productNames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_list);
		
		addButton = (Button) findViewById(R.id.add_button);
		productNameView = (TextView) findViewById(R.id.product_name_view);
		productNameInput = (EditText) findViewById(R.id.product_name_input);
		productNames = new ArrayList<String>();
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String value = productNameInput.getText().toString();
				if (!TextUtils.isEmpty(value)) {
					productNames.add(value);
				}
				productNameInput.getText().clear();
				refreshProductNames();
			}
			
		});
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putStringArrayList(BUNDLE_PRODUCT_NAMES, productNames);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		productNames = savedInstanceState.getStringArrayList(BUNDLE_PRODUCT_NAMES);
		refreshProductNames();
	}

	private void refreshProductNames() {
		StringBuilder builder = new StringBuilder();
		
		for (String productName : productNames) {
			builder.append(productName);
			builder.append("\n");
		}
		
		productNameView.setText(builder.toString());
	}
	
}
