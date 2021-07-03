package com.makkajai.dev.main;

import java.util.List;

import com.makkajai.dev.product.InputProducts;
import com.makkajai.dev.product.Product;
import com.makkajai.dev.receipt.Receipt;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Enter the Products one by one, press ENTER TWICE after entering all the Products");
		List<Product> products = InputProducts.from(InputProducts.inputItemList());

		Receipt receipt = new Receipt();
		System.out.println(receipt.createReceipt(products));
	}

}
