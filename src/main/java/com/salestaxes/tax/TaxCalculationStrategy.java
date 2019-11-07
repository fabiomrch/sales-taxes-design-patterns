package com.salestaxes.tax;

import java.math.BigDecimal;

import com.salestaxes.model.Product;

/**
 * Model of tax calculation algorithm to apply on products
 * @author fab
 *
 */
public interface TaxCalculationStrategy {
	/**
	 * Calculate tax amount for a specific product
	 * @param product Product
	 * @return Tax amount
	 */
	BigDecimal calculateTax(Product product);
}
