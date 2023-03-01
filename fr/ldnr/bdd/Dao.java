package fr.ldnr.bdd;

import fr.ldnr.entities.Article;

import java.sql.Connection;
import java.util.ArrayList;
public interface Dao {
	public Connection connection = BddConnection.getConnection();
	public void create(Article obj);
	public Article read(int id);
	public Boolean update(Article obj);
	public boolean delete(Article obj);
	public Arraylist<Article> readAll();
}
