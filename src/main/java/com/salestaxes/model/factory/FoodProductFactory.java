package com.salestaxes.model.factory;

import java.math.BigDecimal;

import com.salestaxes.model.FoodProduct;
import com.salestaxes.model.Product;

/**
 * Factory that generates food products
 * @author fab
 *
 */
public class FoodProductFactory implements ProductFactory {

	public Product createProduct(String name, BigDecimal price, boolean imported) {
		return new FoodProduct(name, price, imported);
	}

}
