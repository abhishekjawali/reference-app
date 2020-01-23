DROP TABLE IF EXISTS ratings;
 
CREATE TABLE ratings (
  product_id INT PRIMARY KEY,
  rating INT NOT NULL
  
);

INSERT INTO ratings (product_id, rating) VALUES
  (1, 5),
  (2, 4),
  (3, 3),
  (4, 4);