-- 👥 Customers
INSERT INTO customers (name, address, age) VALUES
    ('Aldo Mendoza', 'Calle 123, CDMX', 28),
    ('Maria Lopez', 'Av. Reforma 500, CDMX', 35),
    ('Carlos Ramos', 'Col. Roma Norte, CDMX', 41);
-- 🛒 Products
INSERT INTO products (name, description, price) VALUES
    ('Laptop Dell XPS', '13 inch laptop with an Intel i7 processor', 24999.99),
    ('Monitor LG 27"', '4K Ultra HD', 8999.50),
    ('Mouse Logitech MX Master 3', 'Ergonómic wireless mouse', 1999.99);

-- 📦 Orders
INSERT INTO orders (customer_id, product_id, order_date, delivery_date) VALUES
    (1, 1, '2025-10-15', '2025-10-20'),
    (2, 2, '2025-10-11', '2025-10-13'),
    (2, 2, '2025-10-16', '2025-10-21');
