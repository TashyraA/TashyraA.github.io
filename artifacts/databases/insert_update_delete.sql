-- Create and select the database
CREATE DATABASE QuantigrationUpdates;
USE QuantigrationUpdates;

-- Create Customers table
CREATE TABLE Customers (
    CustomerID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(25) NOT NULL,
    LastName VARCHAR(25) NOT NULL,
    StreetAddress VARCHAR(50) NOT NULL,
    City VARCHAR(50) NOT NULL,
    State CHAR(2) NOT NULL,
    ZipCode VARCHAR(10) NOT NULL,
    Telephone VARCHAR(15) NOT NULL UNIQUE,
    Email VARCHAR(50)
);

-- Create Orders table
CREATE TABLE Orders (
    OrderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    SKU VARCHAR(20) NOT NULL,
    Description VARCHAR(100) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create RMA table
CREATE TABLE RMA (
    RMAID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    OrderID INT NOT NULL,
    Step VARCHAR(50) NOT NULL,
    Status VARCHAR(20) NOT NULL,
    Reason VARCHAR(50),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);
