package com.salestaxes.model;

import java.math.BigDecimal;

/**
 * Model of a purchasable product 
 * @author fab
 *
 */
public abstract class Product {
	private final String name;
	private final BigDecimal price;
	private final boolean imported;
	
	/**
	 * 
	 * @param name Name that identifies the product
	 * @param price Price potentially subject to taxation 
	 * @param imported Boolean that indicates whether the product is imported (true) or local (false)
	 */
	public Product(String name, BigDecimal price, boolean imported) {
		super();
		this.name = name;
		this.price = price;
		this.imported = imported;
	}
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public boolean isImported() {
		return imported;
	}
	public abstract double getTaxRate();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (imported ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (imported != other.imported)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return (imported ? "imported " : "") + name;
	}
	
}
