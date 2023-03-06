package fr.ldnr.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.ldnr.entities.Article;

public class ArticleDaoImpl implements Dao<Article>{//<Article>

	public void create(Article obj) {
		String str = "INSERT INTO T_Articles (description, brand, UnitaryPrice, idCategory) VALUES (?,?,?,?);";
			try (PreparedStatement ps = connection.prepareStatement(str)){
				ps.setString(1, obj.getDescription());
				ps.setString(2, obj.getBrand());
				ps.setDouble(3, obj.getPrice());
				ps.setInt(4, obj.getIdCategory());
				if(ps.executeUpdate() == 1) {
					System.out.println("insertion ok");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**@param Int ArticleId
	 * @return the Article corresponding to Id
	 * TODO if Article =null in db
	 */
	public Article read(int id) {
		Article myArticle = new Article(id);
		String str = "SELECT * FROM T_Articles WHERE IdArticle=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, id);
			try(ResultSet resultSet = ps.executeQuery()){
				while(resultSet.next()) {
					myArticle.setDescription(resultSet.getString(2));
					myArticle.setBrand(resultSet.getString(3));
					myArticle.setPrice(resultSet.getDouble(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myArticle;
	}
	/**@param Article object
	 * @return true if article update ok, else false
	 */
	public Boolean update(Article obj) {
		String str = "UPDATE T_Articles SET description=?,brand=?,UnitaryPrice=?,idCategory=? WHERE IdArticle=?;";
		
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getIdCategory());
			ps.setInt(5, obj.getIdArticle());
			if(ps.executeUpdate() == 1) {
				return true;
			}
			else return false;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
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
		return true;
	}
	/**@return a list of all articles of T_Articles
	 * 
	 */
	public ArrayList<Article> readAll(){
		ArrayList<Article> myArticleList= new ArrayList<>();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myArticleList;
	}

}
