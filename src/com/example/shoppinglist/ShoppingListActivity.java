package com.example.shoppinglist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShoppingListActivity extends Activity {
	
	private Button addButton;
	private TextView productNameView;
	private EditText productNameInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_list);
		
		addButton = (Button) findViewById(R.id.add_button);
		productNameView = (TextView) findViewById(R.id.product_name_view);
		productNameInput = (EditText) findViewById(R.id.product_name_input);
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				productNameView.setText(productNameInput.getText());
			}
			
		});
	}

}
