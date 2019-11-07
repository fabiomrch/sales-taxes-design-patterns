package com.salestaxes.model.factory;

import java.math.BigDecimal;

import com.salestaxes.model.BookProduct;
import com.salestaxes.model.Product;

/**
 * Factory that generates book products
 * @author fab
 *
 */
public class BookProductFactory implements ProductFactory {

	public Product createProduct(String name, BigDecimal price, boolean imported) {
		return new BookProduct(name, price, imported);
	}

}
