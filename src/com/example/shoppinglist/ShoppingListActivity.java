package com.example.shoppinglist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShoppingListActivity extends Activity {

	public static final int ADD_PRODUCT_REQUEST_CODE = 1;
	private static final String BUNDLE_PRODUCT_NAMES = "productNames";
	private Button addButton;
	private TextView productNameView;

	private ArrayList<String> productNames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_list);

		addButton = (Button) findViewById(R.id.add_button);
		productNameView = (TextView) findViewById(R.id.product_name_view);
		productNames = new ArrayList<String>();

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
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		productNames = savedInstanceState
				.getStringArrayList(BUNDLE_PRODUCT_NAMES);
		refreshProductNames();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == ADD_PRODUCT_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {

				String productName = data.getExtras().getString(
						AddProductActivity.PRODUCT_NAME);

				productNames.add(productName);

				refreshProductNames();
			}
		}

		super.onActivityResult(requestCode, resultCode, data);
	}

	private void refreshProductNames() {
		StringBuilder builder = new StringBuilder();

		for (String productName : productNames) {
			builder.append(productName);
			builder.append("\n");
		}

		productNameView.setText(builder.toString());
	}

	private void addButtonClick() {

		Intent addProductActivity = new Intent(this, AddProductActivity.class);
		startActivityForResult(addProductActivity, ADD_PRODUCT_REQUEST_CODE);
	}

}
