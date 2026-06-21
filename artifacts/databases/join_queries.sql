-- INSERT a new test customer
INSERT INTO Customers
(CustomerID, FirstName, LastName, StreetAddress, City, State, ZipCode, Telephone, Email)
VALUES
(101, 'TestFirst', 'TestLast', '123 Test St', 'TestCity', 'OH', '44087', '330-555-1234', 'test101@example.com');

-- UPDATE the test customer's email
UPDATE Customers
SET Email = 'updated101@example.com'
WHERE CustomerID = 101;

-- DELETE the test customer
DELETE FROM Customers
WHERE CustomerID = 101;

-- VERIFY deletion
SELECT * FROM Customers WHERE CustomerID = 101;

-- COUNT statements for verification
SELECT COUNT(*) FROM Customers;
SELECT COUNT(*) FROM Orders;
SELECT COUNT(*) FROM RMA;
