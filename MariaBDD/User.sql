-- Reconstruction de la base de données
DROP database IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;

CREATE TABLE T_Users (
	IdUser	int(4)	PRIMARY KEY AUTO_INCREMENT,
	Login 	varchar(20)	NOT NULL,
	Password			varchar(20)	NOT NULL
);

--INSERT INTO T_Users ( Login, Password ) VALUES  ( 'Pierre' , 'un');
--INSERT INTO T_Users ( Login, Password ) VALUES  ( 'Jo' , 'deux');
--INSERT INTO T_Users ( Login, Password ) VALUES  ( 'Maria' , 'trois');
--INSERT INTO T_Users ( Login, Password ) VALUES  ( 'Catia','quatre');