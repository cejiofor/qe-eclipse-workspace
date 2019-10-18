package com.perscholas.junit.dao.test;


import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.junit.dao.Product;
import com.perscholas.junit.dao.ProductDAO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

// Annotate class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class ProductDAOParameterizedTest {
	// Declare attributes
	private static ProductDAO p_dao;
	private int id;
	private String name;
	private Double price;

	/* Create the constructor. The order of arguments in the parentheses
	 * determines the parameter position in the two-dimensional Object arrays.
	 * */
	
	public ProductDAOParameterizedTest (String name, Double price) {
		this.name = name;
		this.price= price;
	}

	/* Set up the parameters. */
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{ "Phone", 699.99},
                		{ "Latop", 1299.99},
                		{ "T V", 299.99 },
                		{ "Tablet", 599.99}
                		});
    }

   
    @BeforeClass
    public static void setUp() {
    	p_dao = new ProductDAO();
    }

    // Run the test
    @Test
    public void ProductDAOTest() throws SQLException{
    	Product p = new Product();
    	p.setProductName(name);
    	p.setProductPrice(price);
    	
    	assertNotNull(p_dao.createProduct(p));
    	

    	System.out.printf("Product: %s Price: %.2f%n",
    			p.getProductName(), p.getProductPrice());
    }
}