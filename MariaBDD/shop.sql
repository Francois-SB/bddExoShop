
-- Reconstruction de la base de données
DROP database IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;

-- Construction de la table des articles en vente

CREATE TABLE T_Articles (
	IdArticle	int(4)	PRIMARY KEY AUTO_INCREMENT,
	Description 	varchar(30)	NOT NULL,
	Brand			varchar(30)	NOT NULL,
	UnitaryPrice	float(8) NOT NULL
)ENGINE = InnoDB;

CREATE TABLE T_Categories (
	IdCategory	int(4)	PRIMARY KEY AUTO_INCREMENT,
	CatName 	varchar(30)	NOT NULL,
	Description 	varchar(100)	NOT NULL
);
--
INSERT INTO T_Categories ( CatName, Description ) VALUES  ( 'Materiel info' , 'un');
INSERT INTO T_Categories ( CatName, Description ) VALUES  ( 'logiciel' , 'deux');
INSERT INTO T_Categories ( CatName, Description ) VALUES  ( 'PC' , 'trois');
INSERT INTO T_Categories ( CatName, Description ) VALUES  ( 'Smartphone','quatre');
--
alter table t_articles add column IdCategory INT(4);
alter table t_articles add foreign key(IdCategory) references T_Categories(IdCategory);
--
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Souris' , 'Logitoch', 65,1);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Clavier' , 'Microhard', 49.5,1);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Systeme d''exploitation' , 'Fenetres Vistouille',150,2 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Tapis sourid' , 'Chapeau bleu',5,1 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Cle USB 8 To' , 'Syno', 8,1);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Laptop' , 'PH',1199,3 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'CD x 500' , 'CETME',250,1 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'DVD-R x 100' , 'CETME',99,1 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'DVD+R x 100' , 'CETME',105,1);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Batterie Laptop' , 'PH',80,1 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Casque Audio' , 'Syno',105,1 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Webcam' , 'Logitoch', 755,1);
--
insert into T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Macbook' , 'Apple', 2000,3);
insert into T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'S10','Samsung', 2000,4);
insert into T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Iphone50', 'Apple',20000,4);
insert into T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'Office','Microsoft',150,2);
--SELECT * FROM T_Articles;
--INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ,IdCategory) VALUES  ( 'SuperWebcam' , 'Logi', 360,3);
--update t_articles set Brand='proLogi' where IdArticle= 1;
--SELECT * FROM T_Articles;
--delete from t_articles where IdArticle=13;
SELECT * FROM T_Articles;
