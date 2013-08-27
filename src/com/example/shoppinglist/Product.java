package com.example.shoppinglist;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

	private String name;
	private boolean bought;
	
	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeString(getName());
		parcel.writeByte((byte) (isBought() ? 1 : 0));
	}
	
	public static final Parcelable.Creator<Product> CREATOR = new Creator<Product>() {
		
		@Override
		public Product createFromParcel(Parcel parcel) {
			return new Product(parcel);
		}
		
		@Override
		public Product[] newArray(int size) {
			return new Product[size];
		}
		
	};
	
	private Product(Parcel parcel) {
		setName(parcel.readString());
		setBought(parcel.readByte() == 1 ? true : false);
	}
	
}
