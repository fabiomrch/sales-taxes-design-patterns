package com.salestaxes.model;

import java.math.BigDecimal;

import com.salestaxes.model.factory.ProductType;

/**
 * Specific product category: food
 * @author fab
 *
 */
public class FoodProduct extends Product {

	public FoodProduct(String name, BigDecimal price, boolean imported) {
		super(name, price, imported);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTaxRate() {
		return ProductType.FOOD.getTaxRate();
	}

}
