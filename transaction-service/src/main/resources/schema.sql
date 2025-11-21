CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    from_account VARCHAR(255),
    to_account VARCHAR(255),
    description VARCHAR(255),
    timestamp TIMESTAMP
);