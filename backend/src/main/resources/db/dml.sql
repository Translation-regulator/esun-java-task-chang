-- 預設使用者
INSERT IGNORE INTO user (user_id, user_name, email, account) VALUES
('A1236456789', '小張', 'zhang@example.com', '1111999666');

-- 預設產品
INSERT IGNORE INTO product (product_name, price, fee_rate) VALUES
('產品A', 100.00, 0.0500),
('產品B', 200.00, 0.0300);

