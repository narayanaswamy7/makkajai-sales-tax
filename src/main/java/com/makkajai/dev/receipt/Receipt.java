package com.makkajai.dev.receipt;

import java.util.List;

import com.makkajai.dev.product.Product;
import com.makkajai.dev.utils.Utils;

public class Receipt {

	private double totalsalesTax = 0;
	private double totalAmount = 0;
	private String itemDetails;

	public Receipt createReceipt(List<Product> products) {

		StringBuilder itemDetails = new StringBuilder();

		for (Product product : products) {
			totalsalesTax += product.getTax();
			totalAmount += product.getBasePrice();
			itemDetails.append(product.toString()).append("\n");
		}
		
		totalAmount = Utils.roundOffAmount(totalAmount);
		totalsalesTax = Utils.roundOffTax(totalsalesTax);
		this.itemDetails = itemDetails.toString();
		return this;
	}

	@Override
	public String toString() {
		return itemDetails + "Sales Taxes: " + totalsalesTax + "\nTotal: " + (totalAmount + totalsalesTax);
	}

}
