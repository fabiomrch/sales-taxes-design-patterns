package com.salestaxes.payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.salestaxes.purchasing.ShoppingBasket;
import com.salestaxes.tax.TaxCalculationStrategyFactory;
import com.salestaxes.tax.TaxCalculationStrategyFactory.TaxCalculationAlgorithm;

/**
 * Class representing a biller that generates receipts
 * @author fab
 *
 */
public class ReceiptGenerator {
	private TaxCalculationAlgorithm taxCalculationAlgorithm;
	
	/**
	 * 
	 * @param taxCalculationAlgorithm Tax calculation algorithm to consider while calculating the total amount corresponding to the order to include in the receipt
	 */
	public ReceiptGenerator(TaxCalculationAlgorithm taxCalculationAlgorithm) {
		super();
		this.taxCalculationAlgorithm = taxCalculationAlgorithm;
	}

	/**
	 * Method that generates the receipt
	 * @param shoppingBasket Shopping basket containing all the products purchased
	 * @return Generated receipt
	 */
	public Receipt generateReceipt(ShoppingBasket shoppingBasket) {
		PriceCalculator priceCalculator = new PriceCalculator(TaxCalculationStrategyFactory.getTaxCalculationStrategy(taxCalculationAlgorithm));
		BigDecimal totalAmount = priceCalculator.calculateTotalAmountAfterTax(shoppingBasket);
		BigDecimal salesTaxesAmount = priceCalculator.calculateSalesTaxesAmount(shoppingBasket);
		List<ReceiptItem> receiptItems = 
			shoppingBasket
				.getProducts()
				.keySet()
				.stream()
				.map(product -> new ReceiptItem(product, shoppingBasket.getProducts().get(product), priceCalculator.calculateTotalAmountAfterTax(product, shoppingBasket.getProducts().get(product))))
				.collect(Collectors.toList());
		return new Receipt(receiptItems, totalAmount, salesTaxesAmount);
	}

}
