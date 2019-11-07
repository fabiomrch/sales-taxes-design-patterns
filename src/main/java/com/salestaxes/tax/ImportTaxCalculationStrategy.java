package com.salestaxes.tax;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import com.salestaxes.model.Product;
import com.salestaxes.properties.PropertiesResources;
import com.salestaxes.utils.PriceRounder;

/**
 * Specific tax calculation algorithm: it considers the import tax rate
 * @author fab
 *
 */
public class ImportTaxCalculationStrategy implements TaxCalculationStrategy {

	public BigDecimal calculateTax(Product product) {
		final double importTaxRate = Double.parseDouble(ResourceBundle.getBundle(PropertiesResources.SETTINGS).getString("tax.import.rate"));
		
		BigDecimal taxAmount = product.getPrice().multiply(new BigDecimal(product.getTaxRate()));
		if(product.isImported())
			taxAmount = taxAmount.add(product.getPrice().multiply(new BigDecimal(importTaxRate)));
		
		return PriceRounder.roundUp(taxAmount);
	}

}
