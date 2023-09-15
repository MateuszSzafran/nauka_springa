CREATE TABLE IF NOT EXISTS product(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE,
    description VARCHAR(1000)
);