package com.salestaxes.model;

import java.math.BigDecimal;

import com.salestaxes.model.factory.ProductType;

/**
 * Specific product category: medical
 * @author fab
 *
 */
public class MedicalProduct extends Product {

	public MedicalProduct(String name, BigDecimal price, boolean imported) {
		super(name, price, imported);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTaxRate() {
		return ProductType.MEDICAL.getTaxRate();
	}

}
