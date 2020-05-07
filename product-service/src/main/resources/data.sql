DROP TABLE IF EXISTS products;
 
CREATE TABLE products (
  product_id INT PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  product_company VARCHAR(250) NOT NULL,
  product_category VARCHAR(250) NOT NULL,
  product_description VARCHAR(250) NOT NULL
);

INSERT INTO products (product_id, product_name, product_company, product_category, product_description) VALUES
  (1, 'iPhoneXS', 'Apple', 'Smart Phone', 'Apple iPhone XS'),
  (2, 'iPhoneXR', 'Apple', 'Mobile Phones', 'Apple iPhone XR'),
  (3, 'Galaxy S10', 'Samsung', 'Mobile Phones', 'Samsung Galaxy S10'),
  (4, 'Latitude', 'Dell', 'Laptop', 'Dell Latitude');