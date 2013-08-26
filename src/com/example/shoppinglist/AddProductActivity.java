package com.example.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProductActivity extends Activity {

	public static final String PRODUCT_NAME = "productName";
	private Button addButton;
	private EditText productNameInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_product);

		addButton = (Button) findViewById(R.id.add_button);
		productNameInput = (EditText) findViewById(R.id.product_name_input);

		addButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				addButtonClick();

				// String value = productNameInput.getText().toString();
				// if (!TextUtils.isEmpty(value)) {
				// productNames.add(value);
				// }
				// productNameInput.getText().clear();
				// refreshProductNames();
			}

		});

	}

	protected void addButtonClick() {

		Intent intentWithData = new Intent();
		intentWithData.putExtra(PRODUCT_NAME, productNameInput.getText().toString());
		setResult(Activity.RESULT_OK, intentWithData);
		finish();

	}
}
