CREATE TABLE products (
                          id VARCHAR(36) PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          price NUMERIC(19, 2),
                          quantity INTEGER
);