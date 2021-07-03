package com.makkajai.dev.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.makkajai.dev.taxes.TaxFactory;

public class InputProducts {

	public static List<String> inputItemList() {
		Scanner scanner = new Scanner(System.in);
		List<String> inputItems = new ArrayList<String>();

		while (scanner.hasNextLine() == true) {
			String line = scanner.nextLine();
			if ("".equals(line)) {
				break;
			}
			inputItems.add(line);
		}
		scanner.close();
		return inputItems;
	}

	public static Product getItem(String input) {
		Pattern pattern = Pattern.compile("(\\d+) ([\\w\\s]*)at (\\d+.\\d{2})");
		Matcher matcher = pattern.matcher(input);
		try {
			matcher.find();
			matcher.group(1);
			matcher.group(2);
			matcher.group(3);
		} catch (Exception e) {
			System.out.println("Please check the input format: " + e);
		}
		return new Product(matcher.group(1), matcher.group(2), matcher.group(3));
	}

	public static List<Product> from(List<String> inputs) {
		return inputs.stream().map(InputProducts::from).collect(Collectors.toList());
	}

	private static Product from(String input) {
		Product product = InputProducts.getItem(input);
		TaxFactory.createTax(product);
		return product;
	}

}
