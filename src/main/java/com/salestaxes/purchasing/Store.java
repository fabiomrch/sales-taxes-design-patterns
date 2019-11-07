package com.salestaxes.purchasing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.salestaxes.exception.ProductNotExistentException;
import com.salestaxes.model.Product;
import com.salestaxes.model.factory.ProductType;

/**
 * Class that represents a store from which getting products
 * @author fab
 *
 */
public class Store {
	private Map<String, ProductType> saleableProducts;
	
	public Store() {
		saleableProducts = new HashMap<String, ProductType>();
	}

	/**
	 * Make product saleable
	 * @param name Product code
	 * @param type Product type
	 */
	public void addProduct(String name, ProductType type) {
		saleableProducts.put(name, type);
	}
	
	/**
	 * 
	 * @param name Product code
	 * @param type Product type
	 */
	public void removeProduct(String name, ProductType type) {
		saleableProducts.remove(name);
	}
	
	/**
	 * Get a saleable product 
	 * @param name Product code
	 * @param price Price
	 * @param imported Set to true if product is imported
	 * @return Corresponding product
	 * @throws ProductNotExistentException Product with selected code not found
	 */
	public Product getProduct(String name, BigDecimal price, boolean imported) throws ProductNotExistentException {
		if(!saleableProducts.containsKey(name))
			throw new ProductNotExistentException("Product not existent!");

		return saleableProducts.get(name).createProductFactory().createProduct(name, price, imported);
	}
}
