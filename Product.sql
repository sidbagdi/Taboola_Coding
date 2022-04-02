
#Creating the product table
CREATE TABLE products (
    name varchar(255),
    category varchar(255),
    PRIMARY KEY (name)
);

#Creating the product_history_table
CREATE TABLE products_price_history (
    price int,
    start_date date,
    end_date date,
    name varchar(255),
    FOREIGN KEY (name) REFERENCES products(name) #Foreign key to primary key name in products table
    
);

#Projecting all columns after joining the two tables on name attribute
SELECT * FROM 
products p join products_price_history pph
on p.name=pph.name

# Query to add a new price to the product - We first set the end_date for the previous entry of the old price
UPDATE products_price_history SET end_date = Date.now() where name = "name" and end_date IS NULL;

#Now we insert the new price with end date as null
INSERT INTO products_price_history VALUES(new_price,date.NOW(), NULL, name);