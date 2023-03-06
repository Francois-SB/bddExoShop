package fr.ldnr.job;

import java.util.ArrayList;

import fr.ldnr.entities.*;
import fr.ldnr.bdd.*;

public class IJobImpl implements IJob{

	public void displayAllArticlesForRegistredUser(User user){
		//check if connected
		ArrayList<User> myUsers = new ArrayList<>();
		UserDaoImpl udao = new UserDaoImpl();
		myUsers=udao.readAll();
		boolean foundUser=false;
		for(User userIt : myUsers) {
			if(userIt.getLogin().equalsIgnoreCase(user.getLogin())) {
				System.out.println(foundUser);
				break;
				
			}
		}
		//call readallarticles
		if(foundUser==true) {
			ArticleDaoImpl adao = new ArticleDaoImpl();
			ArrayList<Article> myArticles = new ArrayList<>();
			System.out.println(myArticles=adao.readAll());
		}else 
			System.out.println("Please log in.");
	}
}
