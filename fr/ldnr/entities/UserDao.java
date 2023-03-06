package fr.ldnr.entities;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.ldnr.entities.User;

public class UserDao implements Dao<User>{
	ArrayList<User> users = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
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
}
