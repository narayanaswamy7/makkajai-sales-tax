package com.makkajai.dev.taxes;

import com.makkajai.dev.product.Product;

public class ImportTax implements Tax {

	private final double IMPORT_TAX = 0.05;

	@Override
	public void calculateTax(Product product) {
		product.setTax(IMPORT_TAX * product.getBasePrice());
	}

}
