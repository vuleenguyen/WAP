create table PRODUCT (
	PRODUCTID Integer not null auto_increment,
    BRIEF_INFORMATION NVARCHAR(100),
    DETAIL_INFORMATION NVARCHAR(300),
    BRAND NVARCHAR(50),
    PRICE DOUBLE,
	FIRST_IMAGE NVARCHAR(50),
	SECOND_IMAGE NVARCHAR(50),
	COUNT INTEGER,
    primary key(PRODUCTID)
);
    
    
