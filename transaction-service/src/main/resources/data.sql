INSERT INTO transactions (amount, from_account, to_account, description, timestamp)
VALUES (1000.0, 'TestUser1', 'TestUser2', 'Initial test transaction', CURRENT_TIMESTAMP);

INSERT INTO transactions (amount, from_account, to_account, description, timestamp)
VALUES (6000.0, 'TestUser3', 'TestUser4', 'Large transaction', CURRENT_TIMESTAMP);