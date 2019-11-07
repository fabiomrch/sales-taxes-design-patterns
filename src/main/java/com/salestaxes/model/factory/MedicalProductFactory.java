package com.salestaxes.model.factory;

import java.math.BigDecimal;

import com.salestaxes.model.MedicalProduct;
import com.salestaxes.model.Product;

/**
 * Factory that generates medical products
 * @author fab
 *
 */
public class MedicalProductFactory implements ProductFactory {

	public Product createProduct(String name, BigDecimal price, boolean imported) {
		return new MedicalProduct(name, price, imported);
	}

}
