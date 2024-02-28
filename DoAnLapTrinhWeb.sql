
create database project
use project
CREATE TABLE Discounts (
    discountID NVARCHAR(50) PRIMARY KEY,
    nameDiscount NVARCHAR(200),
    discountPercentage INT
);

Create table Products (
	productID nvarchar(50) primary key,
	nameProduct nvarchar(200),
	description nvarchar(500),
	price float,
	imageURL  nvarchar(500),
	categoryID nvarchar(50),
	discountID NVARCHAR(50),
	unit NVARCHAR(200),
	FOREIGN KEY (discountID) references Discounts(discountID)
);

Create table ParentCategories(
	parentCategoryID nvarchar(50) primary key,
	nameCategory nvarchar(200),
	imageURL nvarchar(500)

)

Create table Categories(
	categoryID nvarchar(50) primary key,
	nameCategory nvarchar(200),
	parentCategoryID NVARCHAR(50),
    FOREIGN KEY (parentCategoryID) REFERENCES ParentCategories(parentCategoryID)
)

Create table Customers (
	customerID int Identity(1,1) primary key,
	username nvarchar(100),
	password  nvarchar(50),
	nameCustomer nvarchar(100),
	numberPhone varchar(20),
	email nvarchar(50),
	address nvarchar(200),
	role bit,
)
Create table Orders(
	orderID nvarchar(50) primary key,
	customerID int references Customers(customerID),
	orderDate smalldatetime,
)

Create table OrderItems(
	orderID nvarchar(50) references Orders(orderID),
	productID nvarchar(50) references Products(productID),
	quantity smallint
)

alter table products add constraint FK_Product Foreign Key (categoryID) references Categories(categoryID) 

ALTER TABLE Products
ADD available bit

create table Contacts(
	contactID int Identity(1,1) primary key,
	name nvarchar(100),
	numberPhone nvarchar(50),
	email nvarchar(50),
	content nvarchar(500)
)
select * from ParentCategories
select * from Categories

select * from Products
select * from Customers
select * from orders
select * from orderitems
delete from ParentCategories where parentCategoryID='DM07' ;
update Products
set discountID = 'DC10'
where productID='SP001'

delete from Products
where productID = 'SP019'


select * from discounts

SELECT Products.productID, Products.nameProduct, Products.description, Products.price, Products.imageURL, Discounts.nameDiscount, Discounts.discountPercentage
FROM Products
JOIN Discounts ON Products.discountID = Discounts.discountID;

Select top 10 * 
from Products
where discountID in (select discountID from Discounts)


Select top 10 * 
from Products
order by productID desc

insert into customers values ('haha', 'aa', 'hieu', '03934', 'sss@gmail.com','hcm', 1);

SELECT
    DATEADD(day, DATEDIFF(day, 0, orderDate), 0) AS OrderDay,
     SUM(CASE WHEN p.discountID IS NOT NULL THEN oi.quantity * (p.price - d. discountPercentage / 100.0 * p.price)
             ELSE oi.quantity * p.price END) AS TotalRe
FROM
    Orders o
    JOIN OrderItems oi ON o.orderID = oi.orderID
    JOIN Products p ON oi.productID = p.productID
	LEFT JOIN Discounts d ON p.discountID = d.discountID

WHERE
    o.orderDate >= DATEADD(day, -6, GETDATE()) -- Lấy ra 7 ngày gần nhất
GROUP BY
    DATEADD(day, DATEDIFF(day, 0, orderDate), 0)
ORDER BY
    OrderDay;

SELECT
    SUM(CASE WHEN p.discountID IS NOT NULL THEN oi.quantity * (p.price - d.discountPercentage / 100.0 * p.price)
             ELSE oi.quantity * p.price END) AS TotalRevenue
FROM
    OrderItems oi
    JOIN Products p ON oi.productID = p.productID
    LEFT JOIN Discounts d ON p.discountID = d.discountID;
