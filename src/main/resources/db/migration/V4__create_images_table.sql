CREATE TABLE images (
                        id VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
                        file_path VARCHAR(500),
                        file_type VARCHAR(100),
                        download_url VARCHAR(500),
                        image BYTEA,
                        product_id VARCHAR(36),
                        CONSTRAINT fk_image_product FOREIGN KEY (product_id) REFERENCES products(id)
);