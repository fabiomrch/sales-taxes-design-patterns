package com.salestaxes.model.factory;

import java.util.ResourceBundle;

import com.salestaxes.properties.PropertiesResources;

/**
 * Product categories
 * @author fab
 *
 */
public enum ProductType {
	BOOK {
		@Override
		public ProductFactory createProductFactory() {
			return new BookProductFactory();
		}

		@Override
		public double getTaxRate() {
			return Double.parseDouble(ResourceBundle.getBundle(PropertiesResources.SETTINGS).getString("product.book.tax_rate"));
		}
	},
	FOOD {
		@Override
		public ProductFactory createProductFactory() {
			return new FoodProductFactory();
		}

		@Override
		public double getTaxRate() {
			return Double.parseDouble(ResourceBundle.getBundle(PropertiesResources.SETTINGS).getString("product.food.tax_rate"));
		}
	},
	MEDICAL {
		@Override
		public ProductFactory createProductFactory() {
			return new MedicalProductFactory();
		}

		@Override
		public double getTaxRate() {
			return Double.parseDouble(ResourceBundle.getBundle(PropertiesResources.SETTINGS).getString("product.medical.tax_rate"));
		}
	},
	UNCATEGORIZED {
		@Override
		public ProductFactory createProductFactory() {
			return new UncategorizedProductFactory();
		}

		@Override
		public double getTaxRate() {
			return Double.parseDouble(ResourceBundle.getBundle(PropertiesResources.SETTINGS).getString("product.uncategorized.tax_rate"));
		}
	};
	
	/**
	 * 
	 * @return Product factory that generates the product related to a specific type
	 */
	public abstract ProductFactory createProductFactory();
	/**
	 * 
	 * @return Get tax rate of a specific product category
	 */
	public abstract double getTaxRate();
}
