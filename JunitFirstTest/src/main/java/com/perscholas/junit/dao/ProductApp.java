package com.perscholas.junit.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Read items and quantities from a list in a txt file
// Grab the product from database and get price
// get a subtotal for each item
//print out an order, with item, quantity, and 

public class ProductApp {
	public static void run() throws SQLException {
		ProductDAO p_dao = new ProductDAO();
		p_dao.testConnection();
		
		Product productOne = new Product();
		productOne.setProductName("Coffee");
		productOne.setProductPrice(2.99);
		
		Product productTwo = new Product();
		productTwo.setProductName("Biscuit");
		productTwo.setProductPrice(5.99);
		
		Product productThree = new Product();
		productThree.setProductName("Eggs");
		productThree.setProductPrice(1.99);
		
		p_dao.createProduct(productOne);
		p_dao.createProduct(productTwo);
		p_dao.createProduct(productThree);
		p_dao.getProducts();
		System.out.println();
		
		p_dao.getProduct("Coffee");
		System.out.println();
		
		Product productOneUpdate = new Product();
		productOneUpdate.setProductName("Cappuccino");
		productOneUpdate.setProductPrice(4.99);
		p_dao.updateProduct(productOneUpdate);
		p_dao.getProducts();
		System.out.println();
		
//		p_dao.removeProduct(1);
		p_dao.getProducts();
		System.out.println();
	}
	public static void main(String[] args) throws SQLException, IOException {
//		run();
		ProductDAO p_dao = new ProductDAO();
		Product p = null;
		File productOrder = new File("order.txt");
		FileReader fr = null;
		BufferedReader br = null;
		String order = new String();
		Map<String, Integer> orderMap = new HashMap();
		List<ProductOrder> orderList = new ArrayList();
		double total = 0;
		try {
			fr = new FileReader(productOrder);
			br = new BufferedReader(fr);
			order = br.readLine();
			while(order!= null) {
				String[] arr = order.split(",");
				String name = arr[0];
				Integer quantity = Integer.parseInt(arr[1]);
				orderMap.put(name, quantity);
				order = br.readLine();
			}
			
			for(Map.Entry<String, Integer> entry: orderMap.entrySet()) {
				p = p_dao.getProduct(entry.getKey());
				ProductOrder po = new ProductOrder(p.getProductId(), p.getProductName(), p.getProductPrice());
				po.setQuantity(entry.getValue());
				orderList.add(po);
			}
			for (ProductOrder po: orderList) {
				System.out.println(po.toString());
				total += po.getSubtotal();
			}
			System.out.println("Order Total: $"+total);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				br.close();
			}
			if (fr != null) {
				fr.close();
			}
		}
	}
}
