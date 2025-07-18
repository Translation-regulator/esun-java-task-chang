-- 切換資料庫（請視實際名稱調整）
USE esun_like_db;

-- 使用者資料表
CREATE TABLE IF NOT EXISTS user (
    user_id VARCHAR(20) PRIMARY KEY,           -- 使用者 ID
    user_name VARCHAR(50) NOT NULL,            -- 使用者名稱
    email VARCHAR(100) NOT NULL,               -- Email
    account VARCHAR(20) NOT NULL               -- 扣款帳號
);

-- 產品資料表
CREATE TABLE IF NOT EXISTS product (
    no INT PRIMARY KEY AUTO_INCREMENT,         -- 流水號
    product_name VARCHAR(100) NOT NULL,        -- 產品名稱
    price DECIMAL(10,2) NOT NULL,              -- 價格
    fee_rate DECIMAL(5,4) NOT NULL             -- 手續費率
);

-- 喜好清單
CREATE TABLE IF NOT EXISTS like_list (
    sn INT PRIMARY KEY AUTO_INCREMENT,         -- 流水編號
    user_id VARCHAR(20) NOT NULL,              -- 使用者 ID（外鍵）
    product_id INT NOT NULL,                   -- 產品 ID（外鍵）
    order_name INT NOT NULL,                   -- 購買數量
    account VARCHAR(20),                       -- 帳號（冗餘欄位）
    total_amount DECIMAL(10,2),                -- 預計扣款總金額
    total_fee DECIMAL(10,2),                   -- 手續費總金額
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (product_id) REFERENCES product(no)
);
