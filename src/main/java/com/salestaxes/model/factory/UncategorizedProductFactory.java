package com.salestaxes.model.factory;

import java.math.BigDecimal;

import com.salestaxes.model.Product;
import com.salestaxes.model.UncategorizedProduct;

/**
 * Factory that generates uncategorized productss
 * @author fab
 *
 */
public class UncategorizedProductFactory implements ProductFactory {

	public Product createProduct(String name, BigDecimal price, boolean imported) {
		return new UncategorizedProduct(name, price, imported);
	}

}
