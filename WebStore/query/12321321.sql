INSERT INTO PRODUCT VALUES (16,'Choose versatile smartphones for every purpose',
	'Choose versatile smartphones for every purpose','Iphone',12,'product1.png','product1_.png',1,'Elephone G5 5.5 inch Android');
    
    ALTER TABLE PRODUCT ADD COLUMN PRODUCT_NAME NVARCHAR(50) NOT NULL;
    
    
 INSERT INTO `product` VALUES (17,'Choose versatile smartphones for every purpose! Our friendly ','Choose versatile smartphones for every purpose! Our friendly ','Iphone',32,'product2.png','product2_.png',4,'BLU Studio 5.0 C HD Smartphone');   
 
 INSERT INTO `product` VALUES (18,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','Iphone',64,'product3.png','product3_.png',2,'Alcatel One Fierce Prepaid Phone');


INSERT INTO `product` VALUES (19,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','Iphone',64,'product4.png','product4_.png',2,'ASUS ZENFONE 6 A601CG');


INSERT INTO `product` VALUES (20,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','LG',40,'product5.png','product5_.png',2,'Samsung Galaxy S4 SGH-M919');

INSERT INTO `product` VALUES (21,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','Asus',24,'product6.png','product6_.png',2,'Samsung Galaxy S III');


INSERT INTO `user` VALUES (1,'vu_leenguyen','Vuhandsome123','Nguyen Hoan Vu Le','Male','Iowa','FairField','4th 1000 North','52775','1992-12-20','vuleenguyen.92@gmail.com','manager');

INSERT INTO `user` VALUES (2,'anas','Anas123','Anas',NULL,NULL,NULL,NULL,'0','0024-01-05','anas@gmail.com','guest');

INSERT INTO `user` VALUES (3,'Frehiwot','Frutye2002','Tadese',NULL,NULL,NULL,NULL,'0','0019-01-05','frutye@gmil.com','guest');


ALTER TABLE USER MODIFY  COLUMN GENDER NVARCHAR(10) NULL;
ALTER TABLE USER MODIFY  COLUMN STATE NVARCHAR(50) NULL;
ALTER TABLE USER MODIFY  COLUMN CITY NVARCHAR(50) NULL;
ALTER TABLE USER MODIFY  COLUMN STREET NVARCHAR(50) NULL;
ALTER TABLE USER MODIFY  COLUMN ZIPCODE NVARCHAR(50) NULL;


