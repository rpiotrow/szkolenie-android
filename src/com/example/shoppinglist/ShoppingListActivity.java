package com.example.shoppinglist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ShoppingListActivity extends Activity {

	public static final int ADD_PRODUCT_REQUEST_CODE = 1;
	private static final String BUNDLE_PRODUCT_NAMES = "productNames";
	private Button addButton;
	private ListView productNameslistView;
	private ArrayAdapter<String> adapter;

	private ArrayList<String> productNames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_list);

		addButton = (Button) findViewById(R.id.add_button);
		productNameslistView = (ListView) findViewById(R.id.myList);

		if (savedInstanceState != null) {
			
			productNames = savedInstanceState
					.getStringArrayList(BUNDLE_PRODUCT_NAMES);
		} else {
			productNames = new ArrayList<String>();
		}

		adapter = new MyArrayAdapter(this, productNames);

		productNameslistView.setAdapter(adapter);

		addButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				addButtonClick();
			}
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putStringArrayList(BUNDLE_PRODUCT_NAMES, productNames);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == ADD_PRODUCT_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {

				String productName = data.getExtras().getString(
						AddProductActivity.PRODUCT_NAME);

				productNames.add(productName);
				adapter.notifyDataSetChanged();
			}
		}

		super.onActivityResult(requestCode, resultCode, data);
	}


	private void addButtonClick() {

		Intent addProductActivity = new Intent(this, AddProductActivity.class);
		startActivityForResult(addProductActivity, ADD_PRODUCT_REQUEST_CODE);
	}

}
