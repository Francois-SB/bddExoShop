package fr.ldnr.bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.ldnr.entities.User;

public class UserDaoImpl implements Dao<User>{
//	ArrayList<User> users = new ArrayList<>();
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	public void create(User obj) {
		String str = "INSERT INTO T_Users (login, password) VALUES (?,?);";
			try (PreparedStatement ps = connection.prepareStatement(str)){
				ps.setString(1, obj.getLogin());
				ps.setString(2, obj.getPassword());
				if(ps.executeUpdate() == 1) {
					System.out.println("insertion ok");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**@param Int UserId
	 * @return the User corresponding to Id
	 * TODO if User =null in db
	 */
	public User read(int id) {

		User myUser = new User(id);
		String str = "SELECT * FROM T_Users WHERE IdUser=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, id);
			try(ResultSet resultSet = ps.executeQuery()){
				while(resultSet.next()) {
					myUser.setLogin(resultSet.getString(2));
					myUser.setPassword(resultSet.getString(3));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myUser;
	}
	/**@param User object
	 * @return true if User update ok, else false
	 */
	public Boolean update(User obj) {
		String str = "UPDATE T_Users SET login=?,password=? WHERE IdUser=?;";
		
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			ps.setInt(3, obj.getIdUser());
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
	 * @param User object
	 * delete an User from T_Users with the given User object corresponding id.
	 */
	public boolean delete(User obj) {
		String str = "DELETE FROM T_Users where IdUser=?;";
		
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getIdUser());

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
	
	/**@return a list of all Users of T_Users
	 * 
	 */
	public ArrayList<User> readAll(){
		ArrayList<User> myUserList= new ArrayList<>();
		String strSql = "select * from T_Users";
		try (Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){
				while(resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					myUserList.add((new User(rsIdUser,rsLogin,rsPassword)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myUserList;
	}
}
