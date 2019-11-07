package com.salestaxes.model;

import java.math.BigDecimal;

import com.salestaxes.model.factory.ProductType;

/**
 * Uncategorized product model
 * @author fab
 *
 */
public class UncategorizedProduct extends Product {

	public UncategorizedProduct(String name, BigDecimal price, boolean imported) {
		super(name, price, imported);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTaxRate() {
		return ProductType.UNCATEGORIZED.getTaxRate();
	}

}
