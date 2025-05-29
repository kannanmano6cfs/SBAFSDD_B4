create database DemoDb3;

Create TABLE Categories(
	CategoryID INT PRIMARY KEY IDENTITY(1,1),
	CategoryName VARCHAR(255)
);

CREATE TABLE Products(
	ProductId INT PRIMARY KEY IDENTITY(1,1),
	ProductName VARCHAR(255),
	Description TEXT,
	Price Decimal(10,2),
	CategoryID INT,
	FOREIGN KEY (CategoryID) References Categories(CategoryID)
);

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY IDENTITY(1,1),
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Address VARCHAR(255)
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT,
    OrderDate DATETIME,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


CREATE TABLE Cart (
    CartID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

--Constraints

ALTER TABLE Customers ADD CONSTRAINT chk_email CHECK(Email LIKE '%@%.%')

---Keys, Referential Integrity and CASCADE

Create TABLE CartItems (
	CartItemID INT PRIMARY KEY IDENTITY(1,1),
	CartID INT,
	ProductID INT,
	Quantity INT
	FOREIGN KEY(CartID) REFERENCES Cart(CartID) ON DELETE CASCADE,
	FOREIGN KEY(ProductID) REFERENCES Products(ProductID) 
);

CREATE TABLE OrderItems (
	OrderItemID INT PRIMARY KEY IDENTITY(1,1),
	OrderID INT,
	ProductID INT,
	Quantity INT
	FOREIGN KEY(ProductID) REFERENCES Products(ProductID), 
	FOREIGN KEY(OrderID) REFERENCES Orders(OrderID) ON DELETE SET NULL 
);

CREATE VIEW PRODUCTDETAILS AS SELECT ProductID, ProductName, Description from Products WHERE Price>1000.00;

Select * from CUSTOMER_ORDER_DETAILS;

CREATE INDEX ind_Customer ON Customers (Name);

CREATE TABLE OrderHistory (
	OrderID INT,
	CustomerID INT,
	DeletedAt DATETIME DEFAULT GETDATE()
);

CREATE TRIGGER trg_AfterDelete ON Orders
AFTER DELETE
AS
BEGIN
	INSERT INTO OrderHistory (OrderID, CustomerID, DeletedAt) 
	SELECT OrderID, CustomerID, GETDATE() from deleted;
END;