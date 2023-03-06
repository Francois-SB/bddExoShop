package fr.ldnr;

import java.util.ArrayList;

import fr.ldnr.bdd.UserDaoImpl;
import fr.ldnr.entities.User;

public class Shop {

	public static void main(String[] args) {
		UserDaoImpl udao = new UserDaoImpl();
		User myUser = new User();
//		myUser.setLogin("Leaonard");
//		myUser.setPassword("5");
//		udao.create(myUser);
		myUser=udao.read(5);
		System.out.println(myUser.toString());
		ArrayList<User> myUserList= new ArrayList<>();
		myUserList=udao.readAll();
		myUserList.stream().forEach(System.out::println);
	}

}
