public Integer createProduct(User user) throws SQLException {
    String name = product.getProductName();
    Double price = product.getProductPrice();
    
    // Create an instance of the mariaDB connection
    MariaDBConnection mariaDB = new MariaDBConnection();
    
    //Declare SQL variables to manage connection and read data
    // String createQuery = null;
    // Statement createStmt = null;
    Connection sqlConnect = null;
    PreparedStatement insertStmt = null;
    String sqlQuery = null;
    Integer result = null;
    
    try {
        //Create a connection to MariaDB database
        sqlConnect = mariaDB.getConnection();
        
        ////Create Table 
        // createQuery = "CREATE TABLE products (product_id INT PRIMARY KEY, product_name VARCHAR(100), product_price double";
        // createStmt = sqlConnect.createStatement();
        //// Run the sql query and return the results to a ResultSet variable
        // results = createStmt.executeQuery(createQuery);
        
        // SQL query to be run to receive data from SQL table
        sqlQuery = "INSERT INTO products (product_name, product_price) values (?, ?)";
        
        // Statement needed to run the sql query
        insertStmt = sqlConnect.prepareStatement(sqlQuery);

        // Set parameters for the prepared statement
        insertStmt.setString(1, name);
        insertStmt.setDouble(2, price);
        
        
        // run the sql query and return the new ID to a result variable
        result = insertStmt.executeUpdate();
    } 
    catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    } 
    finally {
            
        if (insertStmt != null) {
            insertStmt.close();
        }
        if (sqlConnect != null) {
            sqlConnect.close();
        }
    }
    return result;
    
}

public List<Product> getProducts() throws SQLException {
    // List to store all products
    List<Product> productList = new ArrayList();
    // Create an instance of the mariaDB connection
    MariaDBConnection mariaDB = new MariaDBConnection();
    
    //Declare SQL variables manage connection and read data
    Connection sqlConnect = null;
    String selectQuery = null;
    Statement selectStmt = null;
    ResultSet results = null;
    
    try {
        //Create a connection to MariaDB database
        sqlConnect = mariaDB.getConnection();
        
        // SQL query to be run to receive data from SQL table
        selectQuery = "SELECT * FROM products";
        
        // Statement needed to run the sql query
        selectStmt = sqlConnect.createStatement();
        
        // run the sql query and return the results to a ResultSet variable
        results = selectStmt.executeQuery(selectQuery);
        
        // iterate through the java result set and set student properties from ArrayList properties
        while (results.next())
        {
            Product product = new Product();
            product.setProductId(results.getInt("product_id"));
            product.setProductName(results.getString("product_name"));
            product.setProductPrice(results.getDouble("product_price"));
            productList.add(product);
            System.out.println(product.toString());
        }
    } 
    catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    } 
    finally {
        if (results != null) {
            results.close();
        }
        if (selectStmt != null) {
            selectStmt.close();
        }
        if (sqlConnect != null) {
            sqlConnect.close();
        }
    }
    return productList;
}

public Product getProduct(String name) throws SQLException {
    Product product = null;
    // Create an instance of the mariaDB connection
    MariaDBConnection mariaDB = new MariaDBConnection();
    
    // Declare SQL variables needed to manage connection and read data
    Connection sqlConnect = null;
    PreparedStatement selectStmt = null;
    String selectQuery = null;
    ResultSet results = null;						
        
    try {
        //Create a connection to MariaDB database
        sqlConnect = mariaDB.getConnection();
        
        // SQL query to be run to get product from SQL table
        selectQuery = "SELECT * FROM products WHERE product_name = ?";
        
        // Statement needed to run the sql query
        selectStmt = sqlConnect.prepareStatement(selectQuery);
        selectStmt.setString(1, name.toString());
        
        // run the sql query 
        results = selectStmt.executeQuery();
        
        while (results.next())
        {
            product = new Product();
            product.setProductId(results.getInt("product_id"));
            product.setProductName(results.getString("product_name"));
            product.setProductPrice(results.getDouble("product_price"));
            System.out.println(product.toString());
        }
        
    } 
    catch (Exception e)
    {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
    finally {
        if (results != null) {
            results.close();
        }
        if (selectStmt != null) {
            selectStmt.close();
        }
        if (sqlConnect != null) {
            sqlConnect.close();
        }
    }
    return product;
    
}

public Boolean updateProduct(Product product) throws SQLException {
    // Create an instance of the mariaDB connection
    MariaDBConnection mariaDB = new MariaDBConnection();

    // Declare SQL variables needed to manage connection and read data
    Connection sqlConnect = null;
    PreparedStatement updateStmt = null;
    String updateQuery = null;
    int results = -1;
    
    try {
        // SQL query to be run to udpate product data in SQL table
        updateQuery = "UPDATE products "
                + "set product_name = ?, "
                + "product_price = ? "
                + "where product_id = "
                + "(Select min(product_id) from products)";
        
        //Create a connection to MariaDB database
        sqlConnect = mariaDB.getConnection();
        
        // Statement needed to run the sql query
        updateStmt = sqlConnect.prepareStatement(updateQuery);

        // Set parameters for the prepared statement
        updateStmt.setString(1, product.getProductName());
        updateStmt.setDouble(2, product.getProductPrice());
        
        // run the sql query
        results = updateStmt.executeUpdate();
    } 
    catch (Exception e) {
        System.out.println("Error: "+e.getMessage());
        e.printStackTrace();
    }finally {
        if (updateStmt != null) {
            updateStmt.close();
        }
        if (sqlConnect != null) {
            sqlConnect.close();
        }
    }
    if (results >0) {
        return true;
    }
    return false;
}

public boolean removeProduct(int id) throws SQLException {
    // Create an instance of the mariaDB connection
    MariaDBConnection mariaDB = new MariaDBConnection();
    
    // Declare SQL variables needed to manage connection and read data
    Connection sqlConnect = null;
    String removeQuery = null;
    PreparedStatement removeStmt = null;
    int results = -1;
        
    try {
        //Create a connection to MariaDB database
        sqlConnect = mariaDB.getConnection();
        
        // SQL query to be run to add student data to SQL table
        removeQuery = "DELETE FROM products where product_id = ?";
        
        // Statement needed to run the sql query
        removeStmt = sqlConnect.prepareStatement(removeQuery);

        // Set parameters for the prepared statement
        removeStmt.setInt(1, id);
        
        // run the sql query 
        results = removeStmt.executeUpdate();
        // Returns: either (1) the row count for SQL Data Manipulation Language (DML) statements or 
        // (2) 0 for SQL statements that return nothing
    } 
    catch (Exception e)
    {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
    finally {
        if (removeStmt != null) {
            removeStmt.close();
        }
        if (sqlConnect != null) {
            sqlConnect.close();
        }
    }
    if (results >0) {
        return true;
    }
    return false;
}