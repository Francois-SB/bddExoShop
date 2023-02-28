-- 1.7	prix > 100
select * from T_Articles where UnitaryPrice > 100;
-- 1.8	50<prix<150
select * from T_Articles where (UnitaryPrice > 50 AND UnitaryPrice< 150);
-- 1.9 ordre croissant
select * from T_Articles order by UnitaryPrice; -- ASC default
-- 1.10 desc article only
select Description from T_Articles;
-- 1.11 requette interessante
-- toutes les marques ayant la somme de valeur d'articles la composant, qui depasse 100e
select * from T_Articles group by Brand having SUM(UnitaryPrice) > 100; --TODO
-- having ~ where but possibility to use SUM.
-- 1.12 add categorie + add some

-- 1.13	request for tab
select * from T_Articles inner join T_Categories on T_Articles.IdArticle = T_Categories.IdCategorie
where;
