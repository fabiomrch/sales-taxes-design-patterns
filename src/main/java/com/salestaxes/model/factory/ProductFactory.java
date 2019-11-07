package com.salestaxes.model.factory;

import java.math.BigDecimal;

import com.salestaxes.model.Product;

public interface ProductFactory {
	Product createProduct(String name, BigDecimal price, boolean imported);
}
