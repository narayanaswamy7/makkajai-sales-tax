package com.makkajai.dev.taxes;

import java.util.stream.Stream;

import com.makkajai.dev.product.Product;

public class TaxFactory {

	public static void createTax(Product product) {
		if (!Stream.of("book", "chocolate", "pill")
				.anyMatch(exemptedItem -> product.getItemName().contains(exemptedItem))) {
			new SalesTax().calculateTax(product);
		}
		if (product.isImported()) {
			new ImportTax().calculateTax(product);
		}
	}

}
