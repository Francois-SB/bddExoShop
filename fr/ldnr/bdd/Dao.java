package fr.ldnr.bdd;

import fr.ldnr.entities.Article;
import java.sql.Connection;
import java.util.ArrayList;


public interface Dao<T> {
	public Connection connection = BddConnection.getInstance().getConnection();
	public void create(Article obj);
	public Article read(int id);
	public Boolean update(Article obj);
	public boolean delete(Article obj);
	public ArrayList<Article> readAll();
}
