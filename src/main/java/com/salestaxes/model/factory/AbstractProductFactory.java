package com.salestaxes.model.factory;

/**
 * This class manages the generation of generic product factories
 * @author fab
 *
 */
public class AbstractProductFactory {
	/**
	 * 
	 * @param type
	 * @return
	 */
	public static ProductFactory createProduct(ProductType type) {
		return type.createProductFactory();
	}
}
