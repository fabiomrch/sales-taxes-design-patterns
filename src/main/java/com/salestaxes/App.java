package com.salestaxes;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.salestaxes.model.factory.ProductType;
import com.salestaxes.payment.Receipt;
import com.salestaxes.payment.ReceiptGenerator;
import com.salestaxes.purchasing.ShoppingBasket;
import com.salestaxes.purchasing.Store;
import com.salestaxes.tax.TaxCalculationStrategyFactory.TaxCalculationAlgorithm;

/**
 * Class with main method usable to test receipt generation
 * @author fab
 *
 */
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
        Store store = new Store();
        store.addProduct("book", ProductType.BOOK);
        store.addProduct("music CD", ProductType.UNCATEGORIZED);
        store.addProduct("chocolate bar", ProductType.FOOD);
        store.addProduct("box of chocolates", ProductType.FOOD);
        store.addProduct("bottle of perfume", ProductType.UNCATEGORIZED);
        store.addProduct("packet of headache pills", ProductType.MEDICAL);
              
        ReceiptGenerator receiptGenerator = new ReceiptGenerator(TaxCalculationAlgorithm.IMPORT);
     
        try {
	        ShoppingBasket shoppingBasket1 = new ShoppingBasket();
	        shoppingBasket1.addProduct(store.getProduct("book", new BigDecimal(12.49), false), 1);
	        shoppingBasket1.addProduct(store.getProduct("music CD", new BigDecimal(14.99), false), 1);
	        shoppingBasket1.addProduct(store.getProduct("chocolate bar", new BigDecimal(0.85), false), 1);
	
	        Receipt receipt1 = receiptGenerator.generateReceipt(shoppingBasket1);
	        System.out.println(receipt1.toString() + "\n");
	        
	        ShoppingBasket shoppingBasket2 = new ShoppingBasket();        
	        shoppingBasket2.addProduct(store.getProduct("box of chocolates", new BigDecimal(10.00), true), 1);
	        shoppingBasket2.addProduct(store.getProduct("bottle of perfume", new BigDecimal(47.50), true), 1);
	    
	        Receipt receipt2 = receiptGenerator.generateReceipt(shoppingBasket2);      
	        System.out.println(receipt2.toString() + "\n");
	        
	        ShoppingBasket shoppingBasket3 = new ShoppingBasket();
	        shoppingBasket3.addProduct(store.getProduct("bottle of perfume", new BigDecimal(27.99), true), 1);
	        shoppingBasket3.addProduct(store.getProduct("bottle of perfume", new BigDecimal(18.99), false), 1);
	        shoppingBasket3.addProduct(store.getProduct("packet of headache pills", new BigDecimal(9.75), false), 1);
	        shoppingBasket3.addProduct(store.getProduct("box of chocolates", new BigDecimal(11.25), true), 1);
	        
	        Receipt receipt3 = receiptGenerator.generateReceipt(shoppingBasket3);      
	        System.out.println(receipt3.toString());
        } catch(Exception e) {
        	log.error("", e);
        }
    }
}
