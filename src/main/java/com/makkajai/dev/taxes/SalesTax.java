package com.makkajai.dev.taxes;

import com.makkajai.dev.product.Product;

public class SalesTax implements Tax {

	private final double SALES_TAX = 0.1;

	@Override
	public void calculateTax(Product product) {
		product.setTax(SALES_TAX * product.getBasePrice());
	}

}
