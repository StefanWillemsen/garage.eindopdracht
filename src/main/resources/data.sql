INSERT INTO Users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO Users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO Users (username, password, enabled) VALUES ('Henk', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO Authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO Authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO Authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO Authorities (username, authority) VALUES ('Henk', 'ROLE_USER');

INSERT INTO Parts (name, description, price) VALUES ('brake disc', 'discs for the cars brakes', 40.00);
INSERT INTO Parts (name, description, price) VALUES ('tire', 'ring shaped component surronds the wheel to drive on', 35.00);
INSERT INTO Parts (name, description, price) VALUES ('front light', 'lights to see ahead on the road', 10.95);
INSERT INTO Parts (name, description, price) VALUES ('back lights', 'lights to make you visible for other drivers', 12.45);
INSERT INTO Parts (name, description, price) VALUES ('oil', 'supstance to keep the engine running smoothly', 32.70);

INSERT INTO Services (action, description, price) VALUES ('replacing brake discs', 'payment for the worktime it costs to replace the discs', 25.00);
INSERT INTO Services (action, description, price) VALUES ('replacing a tire', 'payment for the worktime it costs to replace a tire', 10.00);
INSERT INTO Services (action, description, price) VALUES ('replacing front lights', 'payment for the worktime it costs to replace the front lights', 21.95);
INSERT INTO Services (action, description, price) VALUES ('replacing back lights', 'payment for the worktime it costs to replace the back lights', 25.00);
INSERT INTO Services (action, description, price) VALUES ('replacing oil', 'payment for the worktime it costs to replace the oil', 31.60);

INSERT INTO Customers (first_name, last_name, phone_number, email, customerID) VALUES ('Tessa', 'Test', '1234567890', 'TessaTest@email.com', 1);

INSERT INTO Employees(employeeID, first_name, last_name, phone_number, role, email) VALUES (5, 'Timo', 'Tester', '0123456789', 'mechanic', 'TimoTester@email.com');

INSERT INTO Car (carID, customer_id, employee_id, brand, type, licence_plate, manufacturing_year) VALUES(10, 1, 5, 'TOYOTA', 'AIGO', 'AA-11-AA', 1999);

INSERT INTO Maintenance (services_applied, parts_exchanged, car, maintenance_date, maintenance_completed,first_check_done, customer_approved ) VALUES (1, 1, 10, '02/08/2021', false, false, false);
