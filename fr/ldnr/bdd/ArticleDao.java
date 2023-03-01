package fr.ldnr.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.ldnr.entities.Article;

public class ArticleDao implements Dao<Article>{
	//ArrayList<Article> articles = new ArrayList<>();
	
	public Connection connection = BddConnection.getConnection();
		
	
	public void createPrepared(Article obj) {
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(1, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(3, obj.getIdCategory());
			if(ps.executeUpdate() == 1) {
				System.out.println("insertion ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Article read(int id) {
		
	}
	/**@param Article object
	 * @return true if article update ok, else false
	 */
	public Boolean update(Article obj) {
		String str = "UPDATE T_Article set Description='?',Brand='?',UnitaryPrice='?',IdCategory='?' WHERE IdArticle=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getIdCategory());
			ps.setInt(5, obj.getIdArticle());
			if(ps.executeUpdate() == 1) {
				System.out.println("insertion ok");
				return true;
			}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param Article object
	 * delete an Article from T_Article with the given Article object corresponding id.
	 */
	public boolean delete(Article obj) {
		String str = "DELETE FROM T_Articles where IdArticle=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getIdArticle());

			if(ps.executeUpdate() == 1) {
				System.out.println("deletion ok");
				return true;
			}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**@return a list of all articles of T_Articles
	 * 
	 */
	public Arraylist<Article> readAll(){
		Arraylist<Article> myArticleList= new ArrayList<>();
		String strSql = "select * from T_articles";
		try (Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){
				while(resultSet.next()) {
					int rsIdArticle = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					myArticleList.add((new Article(rsIdArticle,rsDescription, rsBrand, rsPrice)));
				}
		}
		return myArticleList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
