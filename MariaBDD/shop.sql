
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

INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Souris' , 'Logitoch', 65);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Clavier' , 'Microhard', 49.5);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Systeme d''exploitation' , 'Fenetres Vistouille',150 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Tapis sourid' , 'Chapeau bleu',5 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Cle USB 8 To' , 'Syno', 8);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Laptop' , 'PH',1199 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'CD x 500' , 'CETME',250 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'DVD-R x 100' , 'CETME',99 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'DVD+R x 100' , 'CETME',105);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Batterie Laptop' , 'PH',80 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Casque Audio' , 'Syno',105 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'Webcam' , 'Logitoch', 755);

SELECT * FROM T_Articles;
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES  ( 'SuperWebcam' , 'Logi', 360);
update t_articles set Brand='proLogi' where IdArticle= 1;
SELECT * FROM T_Articles;
delete from t_articles where IdArticle=13;
SELECT * FROM T_Articles;
