package com.makkajai.dev.product;

import com.makkajai.dev.utils.Utils;

public class Product {

	private int quantity;
	private String itemName;
	private double basePrice;
	private double tax;
	private double finalPrice;

	public Product(String quantity, String itemName, String basePrice) {
		this.quantity = Integer.parseInt(quantity);
		this.itemName = itemName;
		this.basePrice = Double.parseDouble(basePrice);
	}

	public int getQuantity() {
		return quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax += tax;
	}

	public double getFinalPrice() {
		return Utils.roundOffAmount(basePrice + getTax());
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = Utils.roundOffAmount(finalPrice + getTax());
	}
	
	public boolean isImported() {
		return itemName.contains("import");
	}

	@Override
	public String toString() {
		return String.valueOf(quantity) + " " + itemName + ": " + getFinalPrice();
	}

}
