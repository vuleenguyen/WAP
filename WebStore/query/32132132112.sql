create table orderhistory_product (
	ID INTEGER auto_increment NOT NULL,
    ORDERID INTEGER NOT NULL,
    PRODUCTID INTEGER NOT NULL,
    PRIMARY KEY(ID)
);

ALTER TABLE orderhistory_product ADD foreign key (ORDERID) REFERENCES orderhistory(ORDERID);
orderhistory_productALTER TABLE orderhistory_product ADD foreign key (PRODUCTID) REFERENCES PRODUCT(PRODUCTID);

ALTER TABLE orderhistory MODIFY CART_NUMBER NVARCHAR(20) NOT NULL