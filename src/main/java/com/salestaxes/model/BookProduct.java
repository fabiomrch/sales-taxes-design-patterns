package com.salestaxes.model;

import java.math.BigDecimal;

import com.salestaxes.model.factory.ProductType;

/**
 * Specific product category: book
 * @author fab
 *
 */
public class BookProduct extends Product {

	public BookProduct(String name, BigDecimal price, boolean imported) {
		super(name, price, imported);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTaxRate() {
		return ProductType.BOOK.getTaxRate();
	}

}
