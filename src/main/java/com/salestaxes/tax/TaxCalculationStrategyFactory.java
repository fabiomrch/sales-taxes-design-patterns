package com.salestaxes.tax;

/**
 * Factory that manages the creation of tax calculation strategies
 * @author fab
 *
 */
public class TaxCalculationStrategyFactory {
	private TaxCalculationStrategyFactory() {}
	
	public enum TaxCalculationAlgorithm {
		IMPORT {
			@Override
			public TaxCalculationStrategy getStrategy() {
				return new ImportTaxCalculationStrategy();
			}
		};
		
		public abstract TaxCalculationStrategy getStrategy();
	}
	
	/**
	 * 
	 * @param algorithm Tax calculation algorithm
	 * @return Strategy related to the algorithm
	 */
	public static TaxCalculationStrategy getTaxCalculationStrategy(TaxCalculationAlgorithm algorithm) {
		return algorithm.getStrategy();
	}
}
