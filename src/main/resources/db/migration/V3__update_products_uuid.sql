-- V3__update_products_uuid.sql
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS categories CASCADE;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE categories (
                            id VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
                          id VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
                          name VARCHAR(255) NOT NULL,
                          brand VARCHAR(255),
                          description VARCHAR(1000),
                          category_id VARCHAR(36),
                          price NUMERIC(19, 2),
                          inventory INTEGER,
                          CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES categories(id)
);