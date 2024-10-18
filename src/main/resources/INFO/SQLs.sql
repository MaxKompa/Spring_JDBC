-- SQL для створення таблиці Customer
CREATE TABLE Customer (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          fullName VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          socialSecurityNumber VARCHAR(11) NOT NULL UNIQUE
);

-- SQL для отримання всіх клієнтів
SELECT * FROM Customer;

-- SQL для отримання клієнта за ID
SELECT * FROM Customer WHERE id = ?;

-- SQL для додавання нового клієнта
INSERT INTO Customer (fullName, email, socialSecurityNumber) VALUES (?, ?, ?);

-- SQL для оновлення клієнта
UPDATE Customer SET fullName = ?, email = ?, socialSecurityNumber = ? WHERE id = ?;

-- SQL для видалення клієнта
DELETE FROM Customer WHERE id = ?;
