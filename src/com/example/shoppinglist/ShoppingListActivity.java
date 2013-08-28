package com.example.shoppinglist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShoppingListActivity extends Activity {

	public static final int ADD_PRODUCT_REQUEST_CODE = 1;
	private static final String BUNDLE_PRODUCT_NAMES = "productNames";
	private ListView productNameslistView;
	private ArrayAdapter<Product> adapter;

	private ArrayList<Product> products;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_list);

		productNameslistView = (ListView) findViewById(R.id.myList);

		if (savedInstanceState != null) {
			products = savedInstanceState
					.getParcelableArrayList(BUNDLE_PRODUCT_NAMES);
		} else {
			products = new ArrayList<Product>();
			for (int i = 0; i < 100; ++i) {
				products.add(new Product("Product " + i));
			}
		}

		adapter = new MyArrayAdapter(this, products);

		productNameslistView.setAdapter(adapter);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList(BUNDLE_PRODUCT_NAMES, products);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == ADD_PRODUCT_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {

				String productName = data.getExtras().getString(
						AddProductActivity.PRODUCT_NAME);

				products.add(new Product(productName));
				adapter.notifyDataSetChanged();
			}
		}

		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		
		inflater.inflate(R.menu.shopping_list, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() == R.id.add_product_menu) {
			addButtonClick();
		}
		
		return true;
	}


	private void addButtonClick() {

		Intent addProductActivity = new Intent(this, AddProductActivity.class);
		startActivityForResult(addProductActivity, ADD_PRODUCT_REQUEST_CODE);
	}

}
